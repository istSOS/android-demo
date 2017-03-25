package org.istsos.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;


public class DescribeSensorFragment extends Fragment {

    String serviceName;
    Procedure describedSensor = new Procedure();
    //variables for set text
    String description;
    String name;
    String keywords;
    String assignedId;

    public DescribeSensorFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.

        setHasOptionsMenu(true);
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_main, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_describe_sensor, container, false);
        //retrieve intent from main activity
        Intent intent = getActivity().getIntent();
        //retrieve service name from intent
        serviceName = intent.getStringExtra("service");

        //describe sensor request
        loadDescribeSensor();

        displayData(rootView);

        return rootView;
    }

    private void displayData(View view){

        TextView systemTextView = (TextView) view.findViewById(R.id.name_result);
        systemTextView.setText(name);

        TextView assignedIdView = (TextView) view.findViewById(R.id.assigned_id_result);
        assignedIdView.setText(assignedId);

        TextView descriptionView = (TextView) view.findViewById(R.id.description_result);
        descriptionView.setText(description);

        TextView keywordsView = (TextView) view.findViewById(R.id.keywords_result);
        keywordsView.setText(keywords);

    }

    protected void loadDescribeSensor(){

        final Server server = IstSOS.getInstance().getServer("localhost");

        final Service service = server.getService(serviceName);

        service.describeSensor("BELLINZONA", new IstSOSListener() {

            @Override
            public void onSuccess(EventObject event) {
                describedSensor = (Procedure) event.getObject();
                name = describedSensor.getName();
                description = describedSensor.getDescription();
                keywords = describedSensor.getKeywords();
                assignedId = describedSensor.getAssignedId();
                System.out.println(name);
            }
            @Override
            public void onError(EventObject event) {

            }
        });
    }

}
