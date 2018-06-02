package arch.line.base.baseline.repository.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

@Dao @SuppressWarnings("unchecked")
public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(T... t);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void update(T... t);

    @Delete
    public void delete(T... t);
}
