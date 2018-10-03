package arch.line.base.baseline;

import android.app.Application;

import arch.line.base.baseline.injection.AppComponent;
import arch.line.base.baseline.injection.AppModule;

import arch.line.base.baseline.injection.DaggerAppComponent;
import arch.line.base.baseline.injection.DatabaseModule;
import arch.line.base.baseline.injection.RestModule;


public class MyApplication extends Application {
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .restModule(new RestModule())
                .databaseModule(new DatabaseModule())
                .build();

    }

    public AppComponent getAppComponent() {
        if (mAppComponent != null)
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .restModule(new RestModule())
                    .databaseModule(new DatabaseModule())
                    .build();
        return mAppComponent;
    }
}
