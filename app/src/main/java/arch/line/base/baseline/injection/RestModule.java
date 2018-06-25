package arch.line.base.baseline.injection;

import com.google.gson.Gson;

import javax.inject.Singleton;

import arch.line.base.baseline.repository.api.AppRestApi;
import arch.line.base.baseline.utility.api.HeaderInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Module
public class RestModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return AppRestApi.getAppRestApiInstant(okHttpClient, gson);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(HeaderInterceptor headerInterceptor, Interceptor loggingInterceptor) {
        return AppRestApi.getHttpClient(headerInterceptor, loggingInterceptor);
    }

    @Provides
    @Singleton
    public HeaderInterceptor provideHeaderInterceptor() {
        return HeaderInterceptor.createHeaderInterceptor();
    }

    @Provides
    @Singleton
    public Interceptor provideLoggingInterceptor() {
        return AppRestApi.getHttpLoggingInterceptor();
    }


}
