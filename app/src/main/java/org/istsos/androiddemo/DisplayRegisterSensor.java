package org.istsos.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;

/**
 * Created by Florin on 8/8/2016.
 */
public class DisplayRegisterSensor extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_register_sensor);
    }

    public void registerSensor(View view){

        final Server server = IstSOS.getInstance().getServer("localhost");


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
}
