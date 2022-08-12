package com.example.senior_sns_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    Context context;
    ArrayList<OtherUserItem>userItemArrayList;
    TextView otherUserNameView;
    ImageView otherUserImageView;

    public UserAdapter(Context context, ArrayList<OtherUserItem> usersItemArrayList) {
        this.context = context;
        userItemArrayList = usersItemArrayList;
    }

    @Override
    public int getCount() {
        return this.userItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.userItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.user_list_item, parent, false);
        }
        otherUserNameView=(TextView)convertView.findViewById(R.id.userListName);
        otherUserImageView=(ImageView)convertView.findViewById(R.id.otherUserImage);
        otherUserNameView.setText(userItemArrayList.get(position).getOtherUserName());
        otherUserImageView.setImageResource(userItemArrayList.get(position).getUserImageId());
        return convertView;
    }
}
