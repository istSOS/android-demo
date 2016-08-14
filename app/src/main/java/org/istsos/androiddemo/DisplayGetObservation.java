package org.istsos.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

/**
 * Created by Florin on 8/8/2016.
 */
public class DisplayGetObservation extends AppCompatActivity{

    //parameters for getObservation method
    Offering offering;
    Procedure procedure;
    ObservedProperty defUrn;
    Date from;
    Date to;
    Observation obsToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_get_observation);

        //retrieve data from data array
        DataArray dataArray = obsToDisplay.getResult().getDataArray();

        ArrayList<String[]> values = dataArray.getValues();

        //prepare the chart
        LineChart chart = (LineChart) findViewById(R.id.chart);
        //initialize and store values to entries
        List<Entry> entries = getEntries(values);
        //assign entries to line data set
        LineDataSet dataSet = new LineDataSet(entries, "Get Observation");
        LineData lineData = new LineData(dataSet);
        //set data to chart
        chart.setData(lineData);

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

    public void handleObservation(View view) {

        final Server server = IstSOS.getInstance().getServer("localhost");

        server.loadServices(new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                final Service service = server.getService("demo");

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
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXX");
                String dateString1 = "2014-05-03T14:30:00";
                try {
                    from = sdf.parse(dateString1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String dateString2 = "2014-06-03T14:20:00";
                try {
                    to = sdf.parse(dateString2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                service.getObervation(offering, procedure, defUrn, from, to, new IstSOSListener() {
                    @Override
                    public void onSuccess(EventObject event) {

                        obsToDisplay = (Observation) event.getObject();

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
