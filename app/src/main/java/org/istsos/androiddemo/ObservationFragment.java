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


import java.util.ArrayList;


public class ObservationFragment extends Fragment {

    private ArrayAdapter<String> mObservationAdapter;

    public ObservationFragment(){

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ArrayList<String> options = new ArrayList<>();
        options.add("Get observation");
        options.add("Insert observation");
        options.add("Describe sensor");
        options.add("Register sensor");

        mObservationAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_observation,
                R.id.list_item_observation_textview,
                options);

        View rootView = inflater.inflate(R.layout.fragment_observation, container, false);

        //retrieve intent from main activity
        Intent intent = getActivity().getIntent();
        //retrieve service name from intent
        final String serviceName = intent.getStringExtra("service");
        System.out.println(serviceName);

        //get reference to the listView
        ListView listView = (ListView) rootView.findViewById(R.id.listview_observation);
        listView.setAdapter(mObservationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0:
                        intent = new Intent(getActivity(), GetObservationActivity.class);
                        intent.putExtra("service", serviceName);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(getActivity(), DisplayInsertObservation.class);
                        intent.putExtra("service", serviceName);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(getActivity(), DescribeSensorActivity.class);
                        intent.putExtra("service", serviceName);
                        startActivity(intent);
                        break;

                    case 3:
                        intent = new Intent(getActivity(), RegisterSensorActivity.class);
                        intent.putExtra("service", serviceName);
                        startActivity(intent);
                        break;

                    default:
                        break;
                }
            }
        });

        return rootView;
    }
}
