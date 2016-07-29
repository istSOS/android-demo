package istsos.org.androiddemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import istsos.EventObject;
import istsos.IstSOS;
import istsos.IstSOSListener;
import istsos.Procedure;
import istsos.Server;
import istsos.Service;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void describeSensor(View view){

        Button button = (Button) findViewById(R.id.button);

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
                        Intent showData = new Intent(Intent.ACTION_VIEW, Uri.parse(procedure.toString()));

                        startActivity(showData);

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
