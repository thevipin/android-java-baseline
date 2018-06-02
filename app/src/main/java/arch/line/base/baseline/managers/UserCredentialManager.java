package arch.line.base.baseline.managers;

import android.content.Context;
import android.support.annotation.NonNull;


/**
 * UserCredentialManager will hold all user details data
 */
public class UserCredentialManager extends BaseManager {

    public @NonNull
    String getAccessToken(@NonNull Context context){
        String value;
        value = getPreferences(context)
                .getString(KEYS.APP_USER_ACCESS_TOKEN,null);
        return value;
    }
    public void saveAccessToken(@NonNull Context context, @NonNull String accessToken){
        final int minAccessTokenLength = 5;
        if(accessToken.length()>minAccessTokenLength){
            getEditor(context)
                    .putString(KEYS.APP_USER_ACCESS_TOKEN,accessToken)
                    .commit();
        }
        else {
            // The bellow string cannot save on the strings because this is base line code.
            throw new IllegalArgumentException(String.format("Access Token should be at least %d long",minAccessTokenLength));
        }
    }
    public @NonNull boolean isUserLogin(@NonNull Context context){
        boolean value ;
        value = getPreferences(context).contains(KEYS.APP_USER_ACCESS_TOKEN);
        return value;
    }
    public void LogOutUser(@NonNull Context context){
        getEditor(context)
                .clear()
                .apply();
    }
}
