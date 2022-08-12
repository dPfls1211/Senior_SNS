package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JoinName extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_name);

        Button left = (Button) findViewById(R.id.joinBack);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinName.this, LoginActivity.class);
                JoinName.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.join2);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinName.this, JoinCall.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinName.this.startActivity(intent);
                finish();
            }
        });
    }

}

