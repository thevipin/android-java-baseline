package arch.line.base.baseline.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import arch.line.base.baseline.R;
import arch.line.base.baseline.repository.db.AppDataBase;
import arch.line.base.baseline.repository.db.DaoInterfaceClass;
import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class DatabaseModule {

    @Singleton
    @Provides
    @Inject
    public AppDataBase provideAppDatabase(Context context) {
        synchronized(AppDataBase.class) {
            return Room.databaseBuilder(
                    context,
                    AppDataBase.class,
                    context.getString(R.string.app_name))
                    .build();
        }
    }

}
