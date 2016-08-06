package org.istsos.androiddemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mTemperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void describeSensor(View view){
        IstSOS sos = IstSOS.getInstance();

        String serverName = "localhost";
        sos.initServer(serverName, "http://istsos.org/istsos/");

        final Server server = sos.getServer(serverName);

        server.loadServices(new IstSOSListener() {

            @Override
            public void onSuccess(EventObject event) {


                Service service = server.getService("demo");

                service.describeSensor("BELLINZONA", new IstSOSListener() {
                    @Override
                    public void onSuccess(EventObject event) {

                        //store data from DescribeSensor
                        Procedure procedure = (Procedure) event.getObject();
                        //show data from procedure
                        System.out.println(procedure.getName());
                        System.out.println(procedure.getLocation());
                    }

                    @Override
                    public void onError(EventObject event) {

                    }
                });
            }


            @Override
            public void onError(EventObject event) {



            }

        });
    }

    public void registerSensor(View view){

        IstSOS sos = IstSOS.getInstance();

        String serverName = "localhost";
        sos.initServer(serverName, "http://istsos.org/istsos/");

        final Server server = sos.getServer(serverName);

        server.loadServices(new IstSOSListener() {

            @Override
            public void onSuccess(EventObject event) {

                final Service service = server.getService("demo");

                service.describeSensor("T_LUGANO", new IstSOSListener() {
                    @Override
                    public void onSuccess(EventObject event) {

                        //store data from DescribeSensor
                        Procedure procedure = (Procedure) event.getObject();
                        //change name
                        procedure.setSystem("T_MURES");

                        service.registerSensor(procedure, new IstSOSListener() {
                            @Override
                            public void onSuccess(EventObject event) {



                            }

                            @Override
                            public void onError(EventObject event) {

                            }
                        });

                    }

                    @Override
                    public void onError(EventObject event) {

                    }
                });



            }

            @Override
            public void onError(EventObject event) {

            }
        });
    }



    public void insertObservation(View view){

        IstSOS sos = IstSOS.getInstance();

        String serverName = "localhost";
        sos.initServer(serverName, "http://istsos.org/istsos/");

        final Server server = sos.getServer(serverName);

        server.loadServices(new IstSOSListener() {

            @Override
            public void onSuccess(EventObject event) {

                Service service = server.getService("demo");

                mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
                mTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

                //service.describeSensor("");

                //service.insertObservation();


            }

            @Override
            public void onError(EventObject event) {

            }
        });
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mTemperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float sensorValue = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
