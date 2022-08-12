package com.example.senior_sns_project;

public class FeedItem {
    String feedTitle;
    String feedText;
    int imageId;
    String feedDate;

    public FeedItem(String feedTitle, String feedText, int imageId,String feedDate){
        this.feedDate=feedDate;
        this.feedText=feedText;
        this.feedTitle=feedTitle;
        this.imageId=imageId;
    }
    public String getFeedTitle(){
        return feedTitle;
    }
    public String getFeedText(){
        return feedText;
    }
    public String getFeedDate(){
        return feedDate;
    }
    public int getImageId(){
        return imageId;
    }
    public void setFeedTitle(String feedTitle){
        this.feedTitle=feedTitle;
    }
    public void setFeedText(String feedText){
        this.feedText=feedText;
    }
    public void setFeedDate(String feedDate){
        this.feedDate=feedDate;
    }
    public void setImageId(int imageId){
        this.imageId=imageId;
    }
    @Override
    public String toString(){
        return "title"+feedTitle;
    }
}
