package com.example.senior_sns_project;

import android.widget.ImageView;
import android.widget.TextView;

public class OtherUserItem {
    int OtherUserImage;
    String userListName;

    public OtherUserItem(int otherUserImage, String userListName) {
        OtherUserImage = otherUserImage;
        this.userListName = userListName;
    }

    public String getOtherUserName(){
        return userListName;
    }
    public int getUserImageId(){
        return OtherUserImage;
    }
    public void setOtherUserName(String userName){
        this.userListName=userName;
    }
    public void setUserImageId(int imageId){
        this.OtherUserImage=imageId;
    }
    @Override
    public String toString(){
        return "title"+userListName;
    }
}
