package com.example.rectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        try {
            JSONObject object = new JSONObject(LoadJsonFromAsset());
            JSONArray array = object.getJSONArray("questions");
            HashMap<String, String> list;
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {

                JSONObject o = array.getJSONObject(i);
                String question_v = o.getString("question");
                JSONArray options_v = o.getJSONArray("options");
                list  = new HashMap<>();
                list.put("question", question_v);
                String options = "";
                Integer z=0;
                for (int h = 0; h < options_v.length(); h++){
                    String val = options_v.optString(h);
                    z=h+1;
                    String numstr=z.toString();
                    options = options.concat(numstr).concat(")").concat(val).concat("\n");
                }
                list.put("options", options);
                arrayList.add(list);
            }
            ListAdapter adapter = new SimpleAdapter(this,arrayList,R.layout.list_viewdegn,new String[]{"question","options"},new int[]{R.id.question,R.id.options});
            listView.setAdapter(adapter);
        }
            catch (JSONException e){
                e.printStackTrace();
            }

    }
    public String LoadJsonFromAsset(){
        String json = null;
        try{
            InputStream in = this.getAssets().open("MEmcq.json");
            int size = in.available();
            byte[] bbuffer = new byte[size];
            in.read(bbuffer);
            in.close();
            json = new String(bbuffer, "UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

}