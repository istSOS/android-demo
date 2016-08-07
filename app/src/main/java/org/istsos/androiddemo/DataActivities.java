package org.istsos.androiddemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;

/**
 * Created by Florin on 8/7/2016.
 */
public class DataActivities extends AppCompatActivity {

    private SensorManager mSensorManager;
    private Sensor mTemperature;


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




}
