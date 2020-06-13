package com.example.evoting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button b,login;
    private EditText phone,aadhar,election;
    private DatabaseReference register;
    int flag=0;
    Object aa,e,mb,ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= (Button)findViewById(R.id.btnRegNew);
        login=findViewById(R.id.btnLogin);
        aadhar=findViewById(R.id.LogAadhar);
        phone=findViewById(R.id.LogMobile);
        election=findViewById(R.id.LogElection);
        register= FirebaseDatabase.getInstance().getReference().child("Voters");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String aid=aadhar.getText().toString();
               String ph=phone.getText().toString();
                String eid=election.getText().toString();

                if ( aid.isEmpty() && eid.isEmpty() &&ph.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"All Fields Are Required",Toast.LENGTH_LONG).show();
                }

                 if(aid.isEmpty())
                {
                    aadhar.setError("Enter your Aadhar Card Number");
                    aadhar.requestFocus();
                }
                else if(aid.length()!=12)
                {
                    aadhar.setError("Aadhar number should be 12 digits!!!");
                    aadhar.requestFocus();
                }
                else if(eid.isEmpty())
                {
                    election.setError("Enter your Election Card Number");
                    election.requestFocus();
                }
                else if(eid.length()!=10)
                {
                    election.setError("Election Card Number should be 10 characters long!!!");
                    election.requestFocus();
                }
                else if(ph.isEmpty())
                {
                    phone.setError("Enter your Mobile Number");
                    phone.requestFocus();
                }
                else if(ph.length()!=10)
                {
                    phone.setError("Mobile Number should be 10 digits!!!");
                    phone.requestFocus();
                }
                else if(!(aid.isEmpty() && eid.isEmpty() &&ph.isEmpty()))
                 {
                     register.addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                             if(dataSnapshot.exists()) {
                                 for(DataSnapshot vote:dataSnapshot.getChildren()) {
                                     aa = vote.child("Aadhar No").getValue();
                                     String aaf = String.valueOf(aa);
                                     Log.i("AADhar", aaf);
                                     Log.i("AADhar1", aadhar.getText().toString());

                                     e = vote.child("Election Id").getValue();
                                     String ef = String.valueOf(e);
                                     Log.i("Election", ef);
                                     mb = vote.child("Mobile No").getValue();
                                     String mbf = String.valueOf(mb);
                                     Log.i("Mobile", mbf);

                                     if ((aaf.equals(aadhar.getText().toString())) && (ef.equals(election.getText().toString())) && (mbf.equals(phone.getText().toString())))
                                     {
                                         if(vote.child("E-Voter").exists())
                                         {
                                             Toast.makeText(MainActivity.this, "You are Logged In", Toast.LENGTH_LONG).show();
                                             Intent i = new Intent(MainActivity.this, Fingerprint.class);
                                             startActivity(i);
                                             flag = 1;
                                             break;
                                         }
                                         else {
                                            Toast.makeText(MainActivity.this,"Please Signup before using the services of this Application",Toast.LENGTH_LONG).show();
                                         }
                                     }

                                 }
                                 if(flag==0)
                                 {
                                     Toast.makeText(MainActivity.this, "You are not Registered.Please Proceed to SignUp By clicking on below button", Toast.LENGTH_LONG).show();
                                 }
                             }

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError databaseError) {

                         }
                     });
                 }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });
    }
}
