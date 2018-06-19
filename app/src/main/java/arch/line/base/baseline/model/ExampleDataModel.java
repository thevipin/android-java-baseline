package arch.line.base.baseline.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class ExampleDataModel extends BaseModel {
    @PrimaryKey @NonNull
    public String Id = "0";

    public String getId() {
        return Id;
    }

    public void setId( String id) {
        Id = id;
    }

    public String Title;

    @ColumnInfo(name = "year")
    public Integer Year;

    public String Rated;
}
