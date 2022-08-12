package com.example.senior_sns_project;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private ListView noticeListView;
    private TextView textUserID;
    public static String userID;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        userID = getIntent().getStringExtra("userID");

        textUserID = (TextView) findViewById(R.id.textUserID);
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        textUserID.setText(userID+"님 환영합니다!");
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        final Button fragment1 = (Button) findViewById(R.id.fragment1Button);
        final Button fragment2 = (Button) findViewById(R.id.fragment2Button);
        final Button fragment3 = (Button) findViewById(R.id.fragment3Button);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        fragment1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                notice.setVisibility(View.GONE);
                fragment1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                fragment2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragment3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new FeedActivity());
                fragmentTransaction.commit();

            }
        });

        fragment2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                notice.setVisibility(View.GONE);
                fragment2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                fragment1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragment3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new OtherUserActivity());
                fragmentTransaction.commit();
            }
        });

        fragment3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                notice.setVisibility(View.GONE);
                fragment3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                fragment1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragment2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new Myinfo());
                fragmentTransaction.commit();
            }
        });
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {

        @Override
        protected String doInBackground(Void... voids) {

            return null;
        }

        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }

        public void onPostExecute(String result) {
            String noticeContent, noticeName, noticeDate;
            noticeContent = "관리자";
            noticeName = "   " +"다음 신문 배달일 11월 27일";
            noticeDate = "2020-11-24";
            Notice notice = new Notice(noticeContent, noticeName, noticeDate);
            noticeList.add(notice);
            adapter.notifyDataSetChanged();
        }

    }


    private long lastTimeBackPressed;

    public void onBackPressed(){
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed=System.currentTimeMillis();
    }


}
