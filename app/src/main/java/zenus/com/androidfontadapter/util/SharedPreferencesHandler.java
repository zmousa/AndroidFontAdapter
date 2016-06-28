package zenus.com.androidfontadapter.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import zenus.com.androidfontadapter.FontApplication;

public class SharedPreferencesHandler {
    public static void saveStringValue(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(FontApplication.getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringValue(String key){
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(FontApplication.getContext());
        String value = sharedPreferences.getString(key, null);
        return value;
    }
}
