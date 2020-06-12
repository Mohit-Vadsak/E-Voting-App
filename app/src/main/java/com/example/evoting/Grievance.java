package com.example.evoting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class Grievance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievance);

//        Spinner dropdown1=findViewById(R.id.spinner1);
//        String[] item1=new String[]{"1","2"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,item1);
//        dropdown1.setAdapter(adapter);

        String[] item1 = new String[] {"Party 1", "Party 2", "Party 3", "Party 4"};
        String[] item2 = new String[] {"Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup,
                        item1);

        AutoCompleteTextView editTextFilledExposedDropdown = (AutoCompleteTextView)
                findViewById(R.id.spinner1);
        editTextFilledExposedDropdown.setAdapter(adapter);

//        Spinner dropdown2=findViewById(R.id.spinner2);
//        String[] item2=new String[]{"1","2"};
//        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,item2);
//        dropdown2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(
                        this,
                        R.layout.dropdown_menu_popup,
                        item2);

        AutoCompleteTextView editTextFilledExposedDropdown2 = (AutoCompleteTextView)
                findViewById(R.id.spinner2);
        editTextFilledExposedDropdown2.setAdapter(adapter2);


    }
}
