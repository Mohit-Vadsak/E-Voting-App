package com.example.evoting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {
    private ImageView VoteImg;
    private TextView VoteTxt;

    private ImageView NoticeImg;
    private TextView NoticeTxt;

    private ImageView GrievanceImg;
    private TextView GrievanceTxt;

    private ImageView UpdateImg;
    private TextView UpdateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        VoteImg = (ImageView)findViewById(R.id.VoteImg);
        VoteTxt = (TextView)findViewById(R.id.VoteText);

        NoticeImg = (ImageView)findViewById(R.id.NoticeImg);
        NoticeTxt = (TextView)findViewById(R.id.NoticeTxt);

        UpdateImg = (ImageView)findViewById(R.id.UpdateImg);
        UpdateTxt = (TextView)findViewById(R.id.UpdateTxt);

        GrievanceImg =(ImageView)findViewById(R.id.GrievanceImg);
        GrievanceTxt = (TextView)findViewById(R.id.GrievanceTxt);

        VoteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Dashboard.this,CastVote.class);
                startActivity(intent1);
            }
        });
        VoteTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Dashboard.this,CastVote.class);
                startActivity(intent2);
            }
        });

        NoticeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Dashboard.this,Notice.class);
                startActivity(intent3);
            }
        });
        NoticeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Dashboard.this,Notice.class);
                startActivity(intent4);
            }
        });

        UpdateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Dashboard.this,UpdateInfo.class);
                startActivity(intent5);
            }
        });

        UpdateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(Dashboard.this,UpdateInfo.class);
                startActivity(intent6);
            }
        });

        GrievanceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(Dashboard.this,Grievance.class);
                startActivity(intent7);
            }
        });

        GrievanceTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(Dashboard.this,Grievance.class);
                startActivity(intent8);
            }
        });
    }
}
