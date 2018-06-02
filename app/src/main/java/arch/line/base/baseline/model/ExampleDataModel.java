package arch.line.base.baseline.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class ExampleDataModel extends BaseModel {
    @PrimaryKey @NotNull
    public String Id = "0";

    @NotNull
    public String getId() {
        return Id;
    }

    public void setId(@NotNull String id) {
        Id = id;
    }

    public String Title;

    @ColumnInfo(name = "year")
    public Integer Year;

    public String Rated;
}
