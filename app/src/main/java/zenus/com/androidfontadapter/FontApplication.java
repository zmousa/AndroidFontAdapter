package zenus.com.androidfontadapter;

import android.app.Application;
import android.content.Context;

public class FontApplication extends Application{
    public static FontApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized FontApplication getInstance() {
        return instance;
    }

    public static Context getContext(){
        return FontApplication.getInstance().getApplicationContext();
    }

}
