package com.psi.fhir.myapplication.adapters;

import java.text.BreakIterator;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.psi.fhir.myapplication.R;
import com.psi.fhir.myapplication.models.Patient;

public class PatientAdapter extends ArrayAdapter<Patient> {

    // View lookup cache
    private static class ViewHolder {
        public TextView tvName;
        public TextView tvHometown;
    }

    private final Context mContext;

    ArrayList<Patient> patientList = null;

    public PatientAdapter(Context context, ArrayList<Patient> patients) {
        super(context, 0, patients);

        mContext = context;
        patientList = patients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


//        // Get the data item for this position
//        Patient patient = getItem(position);
//
//        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_item, parent, false);
//        }
//
//
//        // Lookup view for data population
//        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHometown);
//        // Populate the data into the template view using the data object
//        tvName.setText(patient.getName());
//        tvHome.setText(patient.getHometown());
//        // Return the completed view to render on screen
//
//
//
//        return convertView;


        // Get the data item for this position
        final Patient patient = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.patient_item, parent, false);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            viewHolder.tvHometown = (TextView)convertView.findViewById(R.id.tvHometown);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvName.setText(patient.getName());
        viewHolder.tvHometown.setText(patient.getHometown());
        // Return the completed view to render on screen
        return convertView;
    }
}