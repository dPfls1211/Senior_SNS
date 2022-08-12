package com.example.senior_sns_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class OtherUserActivity extends Fragment {
    ListView listView;
    UserAdapter userAdapter;
    ArrayList<OtherUserItem> userItemArrayList;

    View view;
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        listView=(ListView)getView().findViewById(R.id.userListView);
        userItemArrayList= new ArrayList<OtherUserItem>();
        userItemArrayList.add(new OtherUserItem(R.drawable.ic_favorite_black_24dp,"박 성아")); //DB에서 읽어와서 작성
        userAdapter= new UserAdapter(listView.getContext(),userItemArrayList);
        listView.setAdapter(userAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_userlist, container, false);

        return view;
    }
}
