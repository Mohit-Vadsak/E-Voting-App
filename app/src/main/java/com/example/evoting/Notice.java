package com.example.evoting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Notice extends AppCompatActivity {
    //String[] notices = new String[15];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
/*

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_main, notices);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
*/
    }
}
