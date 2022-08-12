package com.example.senior_sns_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FeedActivity extends Fragment {
    ListView listView;
    FeedAdapter feedAdapter;
    ArrayList<FeedItem>FeedItemArrayList;

    View view;
    ImageView addFeed;
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        addFeed = (ImageView)getView().findViewById(R.id.newFeed);
        addFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), Write.class));
            }
        });
        listView=(ListView)getView().findViewById(R.id.feedListView);

        FeedItemArrayList= new ArrayList<FeedItem>();
        FeedItemArrayList.add(new FeedItem("한국, 코로나 백신 접종은 언제쯤일까.","코로나 백신 개발을 시작으로,  세계 여러 국가들은 코로나 19  백신 구매에 열을 올리고 있다.\n" +
                "한국정부는 2021년 하반기부터 백신접종을 시작할 예정이라고 밝혔다. 이에 정부가 이 코로나 사태 진정에 대해 여유를 부리는것은 아닌가 하는 의견이 다분하다.\n" +
                "한편, 정부는 현재 코백스 퍼실리티의 백신을 국내 인구 20% 에 해당하는 양을 선구매하기로 하였다.\n" +
                "정부가 2021년 하반기에 접종을 시작하려는것은 현재 약 10개의 백신이 임상시험중이고, 이에 대한 결과가 나온후에 논의를 거쳐 가장 좋은 백신을 선택하려하는것으로 보인다.",R.drawable.p1,"2020-11-24")); //DB에서 읽어와서 작성
        feedAdapter= new FeedAdapter(listView.getContext(),FeedItemArrayList);
        listView.setAdapter(feedAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_feed, container, false);

        return view;
    }
}
