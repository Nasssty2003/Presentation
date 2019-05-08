package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private final String LOG_TAG = "myLogs";
    ListView lv1;
    Button bstart;
    ImageView physics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        physics = (ImageView)findViewById(R.id.imageView);
        physics.setImageResource(R.drawable.physics);
        bstart = (Button) findViewById(R.id.buttonStart);
        bstart.setText("Теория");
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                startActivity(intent1);
            }
        });



        //new JSONObject = JSONArray[position];
        //JSONArray jsonArray = jsonObject.getJSONArray("themes");
        //if jsonArray.count =0 -{ переход к тексту
        //Intent intent1 = new Intent(MainActivity.this, ActivityTwo.class);
        //intent1.putExtra("position", position);
        //startActivity(intent1);}

        //else {переход к таблице
        //Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
        //intent1.putExtra("position", position);
        //startActivity(intent1);}
/*                  switch (position){
                        case 0:
                            Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                            startActivity(intent1);
                        break;
                        case 1:
                            Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                            startActivity(intent2);0
                            break;
                        case 2:
                            Intent intent3 = new Intent(MainActivity.this, ActivityThree.class);
                            startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4 = new Intent(MainActivity.this, ActivityFour.class);
                            startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5 = new Intent(MainActivity.this, ActivityFive.class);
                            startActivity(intent5);
                            break;

                    }
                    }
                    });*/


    }
}



