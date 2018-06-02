package arch.line.base.baseline.utility.storage;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    //String array
    @TypeConverter
    public String fromStringArrayList(ArrayList<String> list) {
        if(list == null) {
            return "";
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @TypeConverter
    public @Nullable
    ArrayList<String> fromString(String value)  {
        Type listType = new TypeToken<ArrayList<String>>() {

        }.getType();
        return new Gson().fromJson(value, listType);
    }
}
