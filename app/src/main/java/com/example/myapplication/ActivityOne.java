package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;


public class ActivityOne extends Activity {
    ListView listView1;
    Thems [] themesArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            themesArray = ReadJSONFile.readThemesJSONFile(this);
            listView1 = (ListView)findViewById(R.id.lv1);
            String[] items = new String[themesArray.length];
            for(int i=0; i < themesArray.length ; i++)
            {
                Thems data = themesArray[i];
                String name = data.getName();
                items[i] = name;
            }
            ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            listView1.setAdapter(adapter);

        } catch(Exception e) {
            e.printStackTrace();
        }



        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.activity_main);
                    }
                };
                Thems selectedLine = themesArray[position];
                JSONArray subTopics = selectedLine.getSubThemes();
                if (subTopics.length() > 0 ){
                    Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("selectedLine", selectedLine);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else {
                    Intent intent2 = new Intent(ActivityOne.this, ActivityThree.class);
                    intent2.putExtra("text", selectedLine.getText());
                    startActivity(intent2);
                }
            }
        });
    }

}