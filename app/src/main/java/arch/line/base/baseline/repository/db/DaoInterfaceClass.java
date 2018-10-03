package arch.line.base.baseline.repository.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * To access your app's data using the Room persistence library.
 *
 * Ref https://developer.android.com/training/data-storage/room/accessing-data
 */

import java.util.List;

import arch.line.base.baseline.model.ExampleDataModel;

public class DaoInterfaceClass {

    @Dao
    public interface ExampleModuleDao extends BaseDao<ExampleDataModel>{

        @Query("SELECT * FROM ExampleDataModel")
        public LiveData<List<ExampleDataModel>> getSampleDataModel();

        @Query("SELECT * FROM ExampleDataModel WHERE Id like :id")
        public LiveData<ExampleDataModel> getSampleDataModel(String id);

    }
}
