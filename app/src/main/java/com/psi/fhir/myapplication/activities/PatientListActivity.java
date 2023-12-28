package com.psi.fhir.myapplication.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.psi.fhir.myapplication.R;
import com.psi.fhir.myapplication.adapters.PatientAdapter;
import com.psi.fhir.myapplication.models.Patient;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientListActivity extends AppCompatActivity {

    ArrayList<Patient> arrayOfUsers;

    ListView listView;
    PatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_list);
        populateUsersList();

        setupPatientSelectedListener();
    }

    private void populateUsersList() {
        // Construct the data source
        arrayOfUsers = Patient.getUsers();
        // Create the adapter to convert the array to views
        adapter = new PatientAdapter(this, arrayOfUsers);

        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.lvPatient);
        listView.setAdapter(adapter);
    }

    public void setupPatientSelectedListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "selected Item Name is " + position, Toast.LENGTH_LONG).show();

                // Launch the detail view passing patient as an extra
                Intent intent = new Intent(PatientListActivity.this, PatientDetailsActivity.class);
                intent.putExtra("patient", adapter.getItem(position));

                startActivity(intent);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_book_list, menu);
//        final MenuItem searchItem = menu.findItem(R.id.action_search);
//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // Fetch the data remotely
//                fetchBooks(query);
//                // Reset SearchView
//                searchView.clearFocus();
//                searchView.setQuery("", false);
//                searchView.setIconified(true);
//                searchItem.collapseActionView();
//                // Set activity title to search query
//                PatientListActivity.this.setTitle(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
//        return true;
//  }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

}
