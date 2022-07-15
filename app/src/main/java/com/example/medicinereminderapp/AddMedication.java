package com.example.medicinereminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMedication extends AppCompatActivity {
    EditText medicationName,numberOfTablets,firstPrescriptionNumber,secondPrescriptionNumber;
    Button addMedication;
    DatabaseHelper myDb ;
    Button goToAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

        medicationName = (EditText) findViewById(R.id.editTextMedicationName);
        numberOfTablets = (EditText) findViewById(R.id.editTextNumberOfTablets);
        firstPrescriptionNumber = (EditText) findViewById(R.id.editTexFirstPrescriptionNumber);
        secondPrescriptionNumber = (EditText) findViewById(R.id.editTextSecondPrescriptionNumber);
        addMedication = (Button) findViewById(R.id.insertData);
        goToAlarmButton =(Button) findViewById(R.id.gotToAlarmActivityButton);


        goToAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddMedication.this,AlarmSetter.class);
                startActivity(intent);
            }
        });

        AddData();


        myDb = new DatabaseHelper(this);
    }
    public void AddData(){
        addMedication.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean dataInserted = myDb.insertData(medicationName.getText().toString(),
                                numberOfTablets.getText().toString(), firstPrescriptionNumber.getText().toString()
                                , secondPrescriptionNumber.getText().toString());
                        if (dataInserted = true) {
                            Toast.makeText(AddMedication.this, "Medication added successfully", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(AddMedication.this, "Medication not successfully", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
 }
