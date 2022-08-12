package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinAddress  extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_address);

        Button left = (Button) findViewById(R.id.join3);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinAddress.this, JoinBirth.class);
                JoinAddress.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.join5);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinAddress.this, JoinSex.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinAddress.this.startActivity(intent);
                finish();
            }
        });
    }

}

