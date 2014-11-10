package com.aa.sportstree.sportstree.pojos;

import java.util.List;

/**
 * Created by Abhinav on 11/10/2014.
 */
public class NewsFeed {


    private List <NewsItem> newsItems;

    private int refreshTime;

    public NewsFeed(List<NewsItem> newsItems, int refreshTime) {

        this.newsItems = newsItems;
        this.refreshTime = refreshTime;
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

}
