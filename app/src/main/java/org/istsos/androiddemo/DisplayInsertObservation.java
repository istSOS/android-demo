package org.istsos.androiddemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Server;
import org.istsos.client.Service;

/**
 * Created by Florin on 8/8/2016.
 */
public class DisplayInsertObservation extends AppCompatActivity{

    private SensorManager mSensorManager;
    private Sensor mTemperature;
    TextView AboutTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_insert_observation);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#252535")));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_layout_actionbar);
        View view=getSupportActionBar().getCustomView();
        AboutTV= (TextView) view.findViewById(R.id.about_tv);
        AboutTV.setText("Insert Observation");
    }

    public void insertObservation(View view){

        final Server server = IstSOS.getInstance().getServer("localhost");

        server.loadServices(new IstSOSListener() {

            @Override
            public void onSuccess(EventObject event) {

                Service service = server.getService("demo");

                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                mTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

                service.describeSensor("");

                //service.insertObservation("");


            }

            @Override
            public void onError(EventObject event) {

            }
        });
    }
}
