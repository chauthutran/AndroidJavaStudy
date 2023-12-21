package com.psi.fhir.myapplication.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import android.support.v7.app.ActionBarActivity;


import androidx.appcompat.app.AppCompatActivity;

import com.psi.fhir.myapplication.R;
import com.psi.fhir.myapplication.models.Patient;


public class PatientDetailsActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtHometown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_detaisl);

        // Fetch views
        txtName = (TextView) findViewById(R.id.name);
        txtHometown = (TextView) findViewById(R.id.hometown);
        // Use the patient to populate the data into our views
        Patient patient = (Patient) getIntent().getSerializableExtra("patient");
        loadPatient(patient);
    }

    // Populate data for the patient
    private void loadPatient(Patient patient) {
//        this.setTitle(patient.getName()); // //change activity title

        // Populate data
        txtName.setText(patient.getName());
        txtHometown.setText(patient.getHometown());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:
//                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

