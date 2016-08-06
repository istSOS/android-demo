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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener, AdapterView.OnItemSelectedListener {

    private SensorManager mSensorManager;
    private Sensor mTemperature;
    private ArrayList<Service> servicesLoadedInApp = null;
    private ArrayAdapter<String> servicesArrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        //convert to array adapter type string
        for (Service service : servicesLoadedInApp){

            servicesArrayAdapter.add(service.getName());
        }

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (List<String>) servicesArrayAdapter);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.notifyDataSetChanged();
    }

    public void loadServicesInApp(View view){

        IstSOS sos = IstSOS.getInstance();

        String serverName = "localhost";
        sos.initServer(serverName, "http://istsos.org/istsos/");

        final Server server = sos.getServer(serverName);

        server.loadServices(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                servicesLoadedInApp = (ArrayList<Service>)server.getServices();
            }

            @Override
            public void onError(EventObject event) {

            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
