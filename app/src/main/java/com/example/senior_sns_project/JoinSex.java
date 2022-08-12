package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinSex  extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_sex);

        Button left = (Button) findViewById(R.id.join4);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinSex.this, JoinAddress.class);
                JoinSex.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.join6);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinSex.this, JoinInterst.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinSex.this.startActivity(intent);
                finish();
            }
        });
    }

}

