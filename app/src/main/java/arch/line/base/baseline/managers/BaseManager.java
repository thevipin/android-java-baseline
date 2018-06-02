package arch.line.base.baseline.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

abstract public class BaseManager {

    final static ManagersKeys KEYS = new ManagersKeys();
    protected String getSharedPreferencesName(){
        return KEYS.DEFAULT_PREFERENCES_NAME;
    }

    SharedPreferences getPreferences(@NonNull Context context){
        return context.getSharedPreferences(getSharedPreferencesName(),Context.MODE_PRIVATE);
    }

    SharedPreferences.Editor getEditor(@NonNull Context context){
        return context.getSharedPreferences(getSharedPreferencesName(), Context.MODE_PRIVATE).edit();
    }

    /**
     * This function allow to save a object
     * Note : the object must be shorter one
     * @param context app constact
     * @param key the key to store
     * @param tObject the object to store
     * @param <T> the object type
     */
    protected <T> void  saveShortObject(@NonNull Context context,String key, @NonNull T tObject){
        Gson gson = new Gson();
        String json = gson.toJson(tObject);
        getEditor(context).putString(key,json);
    }

    protected <T> T getShortObject(@NonNull Context context, String key, Class<T> classOfT)
    {
        String stringValue;
        T objectValue;
         stringValue = getPreferences(context).getString(key,null);
         if(stringValue== null)
             return null;
        Gson gson = new Gson();
        objectValue = gson.fromJson(stringValue, classOfT);
        return objectValue;
    }
}
