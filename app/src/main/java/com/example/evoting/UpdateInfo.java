package com.example.evoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInfo extends AppCompatActivity {
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* Address = (EditText) findViewById(R.id.Address);
        pollno = (EditText)findViewById(R.id.pollbth) ;
        */super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        update = (Button)findViewById(R.id.btnReg);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(UpdateInfo.this,Dashboard.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"You've Information has been Updated successfully!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
