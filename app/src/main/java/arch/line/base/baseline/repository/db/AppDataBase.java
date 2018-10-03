package arch.line.base.baseline.repository.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import arch.line.base.baseline.R;
import arch.line.base.baseline.model.ExampleDataModel;
import arch.line.base.baseline.utility.storage.Converters;


/**
 * Ref https://developer.android.com/training/data-storage/room/
 */
@Database(entities = {ExampleDataModel.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
abstract public class AppDataBase extends RoomDatabase {

    public abstract DaoInterfaceClass.ExampleModuleDao getExampleModuleDao();

}
