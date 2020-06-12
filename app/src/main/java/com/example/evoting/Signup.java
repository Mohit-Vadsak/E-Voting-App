package com.example.evoting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
    private Button signup;
    private EditText fname,phone,aadhar,election;
    private DatabaseReference register;
    Object n,mb,a,e,ev;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname=findViewById(R.id.RegName);
        phone=findViewById(R.id.RegMobile);
        aadhar=findViewById(R.id.RegAadhar);
        election=findViewById(R.id.RegElection);
        signup=findViewById(R.id.btnReg);



        register= FirebaseDatabase.getInstance().getReference().child("Voters");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn=fname.getText().toString();
                String ph=phone.getText().toString();
                String aid=aadhar.getText().toString();
                String eid=election.getText().toString();

                if (fn.isEmpty() && aid.isEmpty() && eid.isEmpty() &&ph.isEmpty())
                {
                    Toast.makeText(Signup.this,"All Fields Are Required",Toast.LENGTH_LONG).show();
                }
                if(fn.isEmpty())
                {
                    fname.setError("Enter your Name");
                    fname.requestFocus();
                }

                else if(aid.isEmpty())
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
                else if(!(fn.isEmpty() && aid.isEmpty() && eid.isEmpty() &&ph.isEmpty()))
                {
                    register.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                for(DataSnapshot check:dataSnapshot.getChildren())
                                {
                                    n=check.child("Name").getValue();
                                    String name=String.valueOf(n);
                                    mb=check.child("Mobile No").getValue();
                                    String mobile=String.valueOf(mb);
                                    e=check.child("Election Id").getValue();
                                    String election1=String.valueOf(e);
                                    a=check.child("Aadhar No").getValue();
                                    String aadhar1=String.valueOf(a);

                                    if((name.equals(fname.getText().toString())) && (mobile.equals(phone.getText().toString())) && (election1.equals(election.getText().toString())) && (aadhar1.equals(aadhar.getText().toString())))
                                    {
                                        register.child(aadhar.getText().toString()+"/E-Voter").setValue("1");
                                        Toast.makeText(Signup.this,"Thank You,You are Registered As an E-Voter",Toast.LENGTH_LONG).show();
                                        Intent i=new Intent(Signup.this,MainActivity.class);
                                        startActivity(i);
                                        flag=1;
                                    }

                                }
                                if(flag==0)
                                {
                                    Toast.makeText(Signup.this,"Please enter your details as per Aadhar and Election Card.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                 /*   register.child(aadhar.getText().toString()+"/Aadhar No").setValue(aadhar.getText().toString());
                    register.child(aadhar.getText().toString()+"/Election Id").setValue(election.getText().toString());
                    register.child(aadhar.getText().toString()+"/Name").setValue(fname.getText().toString());
                    register.child(aadhar.getText().toString()+"/Mobile No").setValue(phone.getText().toString());

                    */

                }
            }
        });


    }
}
