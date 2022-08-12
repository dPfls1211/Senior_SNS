package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinBirth  extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_birth);

        Button left = (Button) findViewById(R.id.join2);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinBirth.this, JoinCall.class);
                JoinBirth.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.join4);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinBirth.this, JoinAddress.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinBirth.this.startActivity(intent);
                finish();
            }
        });
    }

}

