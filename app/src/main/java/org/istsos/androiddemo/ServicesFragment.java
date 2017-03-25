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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Server;
import org.istsos.client.Service;

import java.util.ArrayList;


public class ServicesFragment extends Fragment {

    private ArrayAdapter<String> mServicesAdapter;
    private ArrayList<Service> services = new ArrayList<>();

    public ServicesFragment(){

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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //load services in app
        loadServicesInApp();

        mServicesAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_services,
                R.id.list_item_service_textview,
                new ArrayList<String>());

        View rootView = inflater.inflate(R.layout.fragment_services, container, false);

        //get reference to the listView
        ListView listView = (ListView) rootView.findViewById(R.id.listview_services);
        listView.setAdapter(mServicesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String toService = mServicesAdapter.getItem(position);
                Toast.makeText(getActivity(), toService, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), ObservationActivities.class);
                intent.putExtra("service", toService);
                startActivity(intent);
            }
        });

        return rootView;
    }

    protected void loadServicesInApp(){

        IstSOS sos = IstSOS.getInstance();

        String serverName = "localhost";
        sos.initServer(serverName, "http://istsos.org/istsos/");

        final Server server = sos.getServer(serverName);

        server.loadServices(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                services = (ArrayList<Service>)server.getServices();

                if(services != null){
                    mServicesAdapter.clear();

                    for(Service service : services){
                        mServicesAdapter.add(service.getName());
                    }
                }


            }

            @Override
            public void onError(EventObject event) {

            }
        });

    }



}
