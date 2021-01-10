package com.example.androidworkshopapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText etClothingName;
    EditText etCollection;
    EditText etSeason;
    EditText etDesigner;

    List<String> brands  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brands.add(getString(R.string.lv));
        brands.add(getString(R.string.gucci));
        brands.add(getString(R.string.fendi));
        brands.add(getString(R.string.ferragamo));
        brands.add(getString(R.string.hermes));

        etClothingName = findViewById(R.id.editTextClothingName);
        etCollection = findViewById(R.id.editTextCollection);
        etSeason = findViewById(R.id.editTextSeason);
        etDesigner = findViewById(R.id.editTextDesigner);

        //Brands Spinner
        Spinner brandsSpinner = (Spinner) findViewById(R.id.brandsSpinner);
        ArrayAdapter<String> brandsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brands);
        brandsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandsSpinner.setAdapter(brandsAdapter);
        brandsSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        // Toast.makeText(getApplicationContext(), "Selected User: "+brands[position] ,Toast.LENGTH_SHORT).show();
        // brand = brands.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }
}