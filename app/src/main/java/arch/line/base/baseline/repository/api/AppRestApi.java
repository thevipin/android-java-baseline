package arch.line.base.baseline.repository.api;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import arch.line.base.baseline.BuildConfig;
import arch.line.base.baseline.utility.api.HeaderInterceptor;
import arch.line.base.baseline.utility.api.LiveDataCallAdapterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class AppRestApi {

    public static Retrofit getAppRestApiInstant(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static OkHttpClient getHttpClient(HeaderInterceptor headerInterceptor, Interceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .followRedirects(false)
                .addInterceptor(headerInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public static Interceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return loggingInterceptor;
    }
}
