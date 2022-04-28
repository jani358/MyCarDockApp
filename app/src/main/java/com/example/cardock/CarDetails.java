package com.example.cardock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CarDetails extends AppCompatActivity {
    TextView modelName;
    TextView chasiNumber;
    TextView fuelused;
    TextView ownerName;
    MaterialButton submitbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        modelName = findViewById(R.id.model);
        chasiNumber = findViewById(R.id.chasinumber);
        fuelused = findViewById(R.id.fuelused);
        ownerName = findViewById(R.id.ownername);
        submitbtn = findViewById(R.id.submitbtn);

        ArrayList<Car>car = new ArrayList<>();

        submitbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String modeln =  modelName.getText().toString();
                String chasin = chasiNumber.getText().toString();
                String fuelu = fuelused.getText().toString();
                String ownern = ownerName.getText().toString();
                Boolean check = validationInfo(modeln,chasin,fuelu,ownern);
                if(check == true) {
                    Car c = new Car();
                    c.chasiNumber = chasin;
                    c.fuelUsed = fuelu;
                    c.modelName = modeln;
                    c.ownerName = ownern;
                    car.add(c);
                    System.out.println(c.chasiNumber);
                }
            }
        });

    }
    private Boolean validationInfo(String modeln, String chasin,String fuelu, String owern){
        if(modeln.length() == 0){
            modelName.requestFocus();
            modelName.setError("Empty data provided");
            return false;
        }else if(chasin.length() == 0) {
            chasiNumber.requestFocus();
            chasiNumber.setError("Empty data provided");
            return false;
        }else if(fuelu.length()==0)
        {
            fuelused.requestFocus();
            fuelused.setError("Empty data provided");
            return false;
        }else if(owern.length()==0){
            ownerName.requestFocus();
            ownerName.setError("Empty data provided");
            return false;
        }else {
            Toast.makeText(CarDetails.this,"Submission Successfully",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}