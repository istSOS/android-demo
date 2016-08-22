package org.istsos.androiddemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.istsos.client.EventObject;
import org.istsos.client.IstSOS;
import org.istsos.client.IstSOSListener;
import org.istsos.client.Procedure;
import org.istsos.client.Server;
import org.istsos.client.Service;


public class RegisterSensorMessage extends Fragment {

    String serviceName;
    String sensorName;

    public RegisterSensorMessage() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_register_sensor_message, container, false);

        Intent intent = getActivity().getIntent();
        //retrieve service name from intent
        serviceName = intent.getStringExtra("service");
        sensorName = intent.getStringExtra("sensor");

        registerSensor();

        String message = sensorName + " has been registered.";

        TextView textView = (TextView) rootView.findViewById(R.id.registered_sensor_id);
        textView.setText(message);

        return rootView;
    }


    public void registerSensor(){

        final Server server = IstSOS.getInstance().getServer("localhost");

        final Service service = server.getService(serviceName);

        service.describeSensor("T_LUGANO", new IstSOSListener() {
            @Override
            public void onSuccess(EventObject event) {

                //store data from DescribeSensor
                Procedure procedure = (Procedure) event.getObject();
                //change name
                procedure.setSystem(sensorName);

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

}
