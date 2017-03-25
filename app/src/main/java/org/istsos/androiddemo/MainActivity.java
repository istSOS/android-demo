package org.istsos.androiddemo;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton SensorDescribe,Observation,About,Status,Coordinate,NewService;
    TextView AboutTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#252535")));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_layout_actionbar);
        View view=getSupportActionBar().getCustomView();
        AboutTV= (TextView) view.findViewById(R.id.about_tv);
        AboutTV.setText("Server");

        Observation= (ImageButton) findViewById(R.id.observation_img_btn);
        SensorDescribe= (ImageButton) findViewById(R.id.sensor_describe_img_btn);
        About=(ImageButton) findViewById(R.id.about_img_btn);
        Status= (ImageButton) findViewById(R.id.status_img_btn);
        Coordinate= (ImageButton) findViewById(R.id.coordinate_img_btn);
        NewService= (ImageButton) findViewById(R.id.new_service_img_btn);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new ServicesFragment())
//                    .commit();
//        }

        Observation.setOnClickListener(this);
        SensorDescribe.setOnClickListener(this);
        About.setOnClickListener(this);
        Status.setOnClickListener(this);
        Coordinate.setOnClickListener(this);
        NewService.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "You have already selected Server", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.service_settings:
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, new ServicesFragment())
                            .commit();
                AboutTV.setText("Services");
                Toast.makeText(this, "Selected Services Please Wait", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.data_manage_settings:
                Toast.makeText(this, "Selected Data Management", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.observation_img_btn:
                startActivity(new Intent(this,ObservationActivities.class));
                break;
            case R.id.sensor_describe_img_btn:
                startActivity(new Intent(this,DescribeSensorActivity.class));
                break;
            case R.id.status_img_btn:
                startActivity(new Intent(this,GetObservationActivity.class));
                break;
            case R.id.about_img_btn:
                startActivity(new Intent(this,AboutIstSos.class));
                break;
            case R.id.new_service_img_btn:
                startActivity(new Intent(this,RegisterSensorActivity.class));
                break;
            case R.id.coordinate_img_btn:
                startActivity(new Intent(this,ObservationActivities.class));
                break;
        }
    }
}