package arch.line.base.baseline;

import android.app.Application;

import arch.line.base.baseline.injection.DaggerAppComponent;


public abstract class BaseApplication extends Application {
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
