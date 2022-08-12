package com.example.senior_sns_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FeedAdapter extends BaseAdapter {
    Context context;
    ArrayList<FeedItem>FeedItemArrayList;
    TextView feedTitleView;
    TextView feedTextView;
    TextView feedDateView;
    ImageView feedImageView;

    public FeedAdapter(Context context, ArrayList<FeedItem> feedItemArrayList) {
        this.context = context;
        FeedItemArrayList = feedItemArrayList;
    }

    @Override
    public int getCount() {
        return this.FeedItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.FeedItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       if(convertView==null){
           //convertView= LayoutInflater.from(context).inflate(R.layout.feed_list_item,null);
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.feed_list_item, parent, false);
       }
        feedDateView=(TextView)convertView.findViewById(R.id.feedListDate);
        feedTextView=(TextView)convertView.findViewById(R.id.feedListText);
        feedTitleView=(TextView)convertView.findViewById(R.id.feedListTitle);
        feedImageView=(ImageView)convertView.findViewById(R.id.feedListImage);
        feedTitleView.setText(FeedItemArrayList.get(position).getFeedTitle());
        feedTextView.setText(FeedItemArrayList.get(position).getFeedText());
        feedDateView.setText(FeedItemArrayList.get(position).getFeedDate());
        feedImageView.setImageResource(FeedItemArrayList.get(position).getImageId());
       return convertView;
    }
}
