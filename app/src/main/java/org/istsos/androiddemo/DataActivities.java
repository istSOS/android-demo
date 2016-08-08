package org.istsos.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by Florin on 8/7/2016.
 */
public class DataActivities extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"Get observation", "Insert observation", "Describe sensor",
                "Register sensor",};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;

                switch(position){

                    case 0:
                        intent = new Intent(DataActivities.this, DisplayGetObservation.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(DataActivities.this, DisplayInsObservation.class);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(DataActivities.this, DisplayDescribeSensor.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(DataActivities.this, DisplayRegSensor.class);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }

            }
        });
    }













}
