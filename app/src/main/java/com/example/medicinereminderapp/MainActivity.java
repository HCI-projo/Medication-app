package com.example.medicinereminderapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb ;
    Button AddMedication;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    List<MedicationModel> medicationModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddMedication = (Button) findViewById(R.id.AddMedicationbutton);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        myDb = new DatabaseHelper(this);
        Cursor c = myDb.fetchAllData();
        if (c.getCount()==0){
            Toast.makeText(this, "No medication", Toast.LENGTH_SHORT).show();
        }
        else {
            while (c.moveToNext()) {
                String medicationName = c.getString(1);
                String pres1 = c.getString(3);
                String pres2 = c.getString(4);
                MedicationModel model = new MedicationModel(medicationName, pres1, pres2);
                medicationModels.add(model);

            }
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerViewAdapter = new RecyclerViewAdapter(this, medicationModels);
            recyclerView.setAdapter(recyclerViewAdapter);
        }


        AddMedication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,AddMedication.class);
                startActivity(intent);

            }
        });
       // setUpMedicationModels()
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,medicationModels);
        recyclerView.setAdapter( adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}