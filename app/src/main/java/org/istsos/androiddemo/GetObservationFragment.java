package org.istsos.androiddemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Observation;
import org.istsos.client.ObservedProperty;
import org.istsos.client.Offering;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;
import org.istsos.client.observation.DataArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class GetObservationFragment extends Fragment {

    String serviceName;
    //parameters for getObservation method
    Offering offering = new Offering();
    Procedure procedure = new Procedure();
    ObservedProperty defUrn = new ObservedProperty();
    Date from = new Date();
    Date to = new Date();
    Observation obsToDisplay = new Observation();

    public GetObservationFragment() {

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
        View rootView = inflater.inflate(R.layout.fragment_get_observation, container, false);

        //retrieve intent from main activity
        Intent intent = getActivity().getIntent();
        //retrieve service name from intent
        serviceName = intent.getStringExtra("service");

        //make the get observation request
        requestGetObservation();

        //retrieve data from data array
        DataArray dataArray = obsToDisplay.getResult().getDataArray();

        ArrayList<String[]> values = dataArray.getValues();

        //prepare the chart
        LineChart chart = (LineChart) rootView.findViewById(R.id.chart);
        //initialize and store values to entries
        List<Entry> entries = getEntries(values);
        //assign entries to line data set
        LineDataSet dataSet = new LineDataSet(entries, "Get Observation");
        LineData lineData = new LineData(dataSet);
        //set data to chart
        if (chart != null) {
            chart.setData(lineData);
        }

        return rootView;
    }


    public List<Entry> getEntries(ArrayList<String[]> values){

        List<Entry> entries = new ArrayList<Entry>();

        for (String[] arrayValues : values){

            String getX = arrayValues[0];
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXX");
            float formattedGetX = 0;

            try {
                formattedGetX = sdformat.parse(getX).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String[] yValues = Arrays.copyOfRange(arrayValues, 1, arrayValues.length);

            for(String getY : yValues){

                float formattedGetY = Float.valueOf(getY);

                entries.add(new Entry(formattedGetX, formattedGetY));
            }
        }
        return entries;

    }

    public void requestGetObservation() {

        final Server server = IstSOS.getInstance().getServer("localhost");

        final Service service = server.getService(serviceName);


        service.loadOfferings(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                offering = service.getOffering("T_LUGANO");

            }

            @Override
            public void onError(EventObject event) {

            }
        });

        service.loadProcedures(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                procedure = service.getProcedure("T_LUGANO");
            }

            @Override
            public void onError(EventObject event) {

            }
        });

        service.loadObservedProperties(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                defUrn = service.getObservedProperty("urn:ogc:def:parameter:x-istsos:1.0:meteo:air:temperature");
            }

            @Override
            public void onError(EventObject event) {

            }
        });

        //add dates
        //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXX");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        //String dateString1 = "2014-05-03T14:30:00";
        String dateString1 = "2014-05-03T14:30:00.235-0700";
        try {
            from = sdf.parse(dateString1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //String dateString2 = "2014-06-03T14:20:00";
        String dateString2 = "2014-06-03T14:20:00.235-0700";
        try {
            to = sdf.parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        service.getObervation(offering, procedure, defUrn, from, to, new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                obsToDisplay = (Observation) event.getObject();
                System.out.print(obsToDisplay.getResult());
            }

            @Override
            public void onError(EventObject event) {

            }
        });
    }
}

