package zenus.com.androidfontadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zenus.com.androidfontadapter.util.Constants;
import zenus.com.androidfontadapter.util.FontController;
import zenus.com.androidfontadapter.util.SharedPreferencesHandler;

public class MainActivity extends Activity {
    private List<HashMap<String, String>> fontsList;
    private TextView txtView;
    private Spinner spinnerFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.txt_hello_world);
        initFontSettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFontSettings(){
        fontsList = new ArrayList<HashMap<String, String>>();
        fontsList = FontController.getFontsArray();
        spinnerFont = (Spinner) findViewById(R.id.font_setting_spinner);
        SimpleAdapter adapter = new SimpleAdapter(this, fontsList, android.R.layout.simple_list_item_1,
                new String[]{"name"}, new int[]{android.R.id.text1});

        spinnerFont.setAdapter(adapter);
        spinnerFont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferencesHandler.saveStringValue(Constants.FONT_FAMILY, fontsList.get(position).get("value"));
                FontController.changeFontSettings(txtView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
