package com.example.senior_sns_project;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinInterst  extends AppCompatActivity {
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_interest);

        Button left = (Button) findViewById(R.id.join5);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(JoinInterst.this, JoinSex.class);
                JoinInterst.this.startActivity(registerIntent);
            }
        });

        Button right = (Button) findViewById(R.id.joinEnd);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(JoinInterst.this);
                dialog = builder.setMessage("회원가입을 성공했습니다.").setPositiveButton("확인", null).create();
                dialog.show();
                Intent intent = new Intent(JoinInterst.this, LoginActivity.class);
                //intent.putExtra("userID", userID); 이름 정보 넘기기
                JoinInterst.this.startActivity(intent);
                finish();
            }
        });
    }
    }


