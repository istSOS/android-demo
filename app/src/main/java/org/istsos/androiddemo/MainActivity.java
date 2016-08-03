package org.istsos.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
