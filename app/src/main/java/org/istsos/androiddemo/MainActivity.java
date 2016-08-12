package org.istsos.androiddemo;

import android.content.Intent;
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
import org.istsos.client.Server;
import org.istsos.client.Service;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<Service> servicesLoadedInApp = new ArrayList<>();
    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

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

                //convert to array adapter type string
                for (Service service : servicesLoadedInApp){

                    spinnerAdapter.add(service.getName());
                }

                if (spinner != null) {
                    spinner.setAdapter(spinnerAdapter);
                }

                //refresh adapter
                spinnerAdapter.clear();

                spinnerAdapter.notifyDataSetChanged();

                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

        Intent intent = new Intent(MainActivity.this, DataActivities.class);
        MainActivity.this.startActivity(intent);

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




}
