package arch.line.base.baseline.repository.api;

import arch.line.base.baseline.BuildConfig;
import arch.line.base.baseline.utility.api.LiveDataCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class AppRestApi {
    public AppRestApi getAppRestApiInstant(){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
               // .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
