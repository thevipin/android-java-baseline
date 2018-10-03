package arch.line.base.baseline.injection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import arch.line.base.baseline.repository.api.AppRestApi;
import arch.line.base.baseline.repository.api.ImdbApi;
import arch.line.base.baseline.utility.api.HeaderInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Module
@Singleton
public class RestModule {
    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return AppRestApi.getAppRestApiInstant(okHttpClient, gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(HeaderInterceptor headerInterceptor, Interceptor loggingInterceptor) {
        return AppRestApi.getHttpClient(headerInterceptor, loggingInterceptor);
    }

    @Singleton
    @Provides
    public HeaderInterceptor provideHeaderInterceptor() {
        return HeaderInterceptor.createHeaderInterceptor();
    }

    @Singleton
    @Provides
    public Interceptor provideLoggingInterceptor() {
        return AppRestApi.getHttpLoggingInterceptor();
    }

    @Singleton
    @Provides
    public ImdbApi provideImdbApi(Retrofit retrofit) {
        return retrofit.create(ImdbApi.class);
    }

}
