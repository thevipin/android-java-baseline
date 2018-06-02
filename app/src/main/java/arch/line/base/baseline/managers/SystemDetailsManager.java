package arch.line.base.baseline.managers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class SystemDetailsManager extends BaseManager {
    @Override
    protected String getSharedPreferencesName() {
        return super.getSharedPreferencesName()+ this.getClass();
    }
    public void setFireBaseDeviceToken(@NonNull Context context, @NonNull String token){
        getEditor(context)
                .putString(KEYS.SYSTEM_DEVICE_TOKEN,token)
                .commit();
    }
    public @Nullable
    String getFireBaseDeviceToken(@NonNull Context context){
        @Nullable String value;
        value = getPreferences(context).getString(KEYS.SYSTEM_DEVICE_TOKEN,null);
        return value;
    }
}
