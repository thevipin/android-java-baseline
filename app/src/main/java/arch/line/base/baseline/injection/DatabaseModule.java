package arch.line.base.baseline.injection;

import android.content.Context;

import javax.inject.Singleton;

import arch.line.base.baseline.repository.db.AppDataBase;
import arch.line.base.baseline.repository.db.DaoInterfaceClass;
import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class DatabaseModule {
    @Singleton
    @Provides
    public AppDataBase provideAppDatabase(Context context){
        return AppDataBase.getAppDataBaseInstant(context);
    }

    @Singleton
    @Provides
    public DaoInterfaceClass.ExampleModuleDao provideSampleModuleDao(AppDataBase appDataBase){
        return appDataBase.getExampleModuleDao();
    }
}
