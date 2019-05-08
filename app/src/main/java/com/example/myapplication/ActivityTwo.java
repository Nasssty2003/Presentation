package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;

public class ActivityTwo extends AppCompatActivity {
 ListView listView2;
    Thems [] subthemesArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        Intent intent = getIntent();
        Thems thems = (Thems) intent.getSerializableExtra("selectedLine");
        JSONArray subThemes = thems.getSubThemes();
        try {
            subthemesArray = ReadJSONFile.parseThemesArray(subThemes);
            listView2 = (ListView)findViewById(R.id.lv2);
            String[] items = new String[subthemesArray.length];
            for(int i=0; i < subthemesArray.length ; i++)
            {
                Thems data = subthemesArray[i];
                String name = data.getName();
                items[i] = name;
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            listView2.setAdapter(adapter);

        } catch(Exception e) {
            e.printStackTrace();
        }
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.activity_three);
                    }
                };
                Thems selectedLine = subthemesArray[position];

                    Intent intent2 = new Intent(ActivityTwo.this, ActivityThree.class);
                    intent2.putExtra("text", selectedLine.getText());
                    startActivity(intent2);
            }
        });


    }

}
