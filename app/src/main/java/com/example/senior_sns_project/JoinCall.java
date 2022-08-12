package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinCall extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_call_number);

        Button left = (Button) findViewById(R.id.join1);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinCall.this, JoinName.class);
                JoinCall.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.join3);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinCall.this, JoinBirth.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinCall.this.startActivity(intent);
                finish();
            }
        });
    }

}

