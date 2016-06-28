package zenus.com.androidfontadapter.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import zenus.com.androidfontadapter.FontApplication;

public class FontController {
    private static final String TAG = "FontController";

    private static final Hashtable<String, Typeface> cache = new Hashtable();

    public static Typeface get(Context c, FontEnum font) {
        synchronized (cache) {
            String assetPath = getFontAssetPath(font);
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                            + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

    public static String getFontAssetPath(FontEnum font){
        switch (font){
            case EN_ARIAL: return "fonts/EN_Arial.ttf";
            case EN_CAMBRIA: return "fonts/EN_Cambria.ttf";
            case EN_COMIC: return "fonts/EN_Comic.ttf";
            case EN_IMPACT: return "fonts/EN_Impact.ttf";
            case EN_TAHOMA: return "fonts/EN_Tahoma.ttf";
            case EN_TIMES: return "fonts/EN_Times.ttf";
            case EN_VERDANA: return "fonts/EN_Verdana.ttf";
        }
        return "";
    }

    public static List<HashMap<String, String>> getFontsArray(){
         String[] fonts = new String[]{
                "EN_ARIAL",
                "EN_CAMBRIA",
                "EN_COMIC",
                "EN_IMPACT",
                "EN_TAHOMA",
                "EN_TIMES",
                "EN_VERDANA"
        };

        List<HashMap<String, String>> fontsList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        for (String font : fonts){
            map = new HashMap<String, String>();
            map.put("name", font.substring(3));
            map.put("value", font);
            fontsList.add(map);
        }

        return fontsList;
    }

    public static void changeFontSettings(TextView view) {
        String font = SharedPreferencesHandler.getStringValue(Constants.FONT_FAMILY);

        if (font != null && !font.isEmpty()) {
            Typeface tf = FontController.get(FontApplication.getContext(), FontEnum.valueOf(font));
            view.setTypeface(tf);
        }
    }
}