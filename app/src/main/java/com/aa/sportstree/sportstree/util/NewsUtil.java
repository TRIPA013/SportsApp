package com.aa.sportstree.sportstree.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.aa.sportstree.sportstree.NewsFeedItemFragment;
import com.aa.sportstree.sportstree.data.DataInitializer;
import com.aa.sportstree.sportstree.pojos.NewsItem;
import com.aa.sportstree.sportstree.pojos.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 11/14/2014.
 */
public class NewsUtil {
    /**
     * This is the method for when a news item displays, it only shows a display message if the news
     * item has not been retrieved yet. As it grabs the item, the message is replaced with the
     * news item.
     * @param mAdapter the fragment news item
     * @return the list of items for the news feed
     */
    public static List<NewsItem> getNewsList(NewsFeedItemFragment mAdapter){
        List<NewsItem> newsItems = new ArrayList<NewsItem>();
        List<Team> teams =DataInitializer.selectedTeams;
        if(teams!=null) {
            int id =0;
            for (Team team : teams) {
                String content="Please Wait...Loading Content..";
                NewsItem newsItem = new NewsItem(""+id++, content, team,"");
                getContent(newsItem,team.getTeamName() + " " + team.getSport().getName(), mAdapter);
                newsItems.add(newsItem);
            }
        }
        return newsItems;
    }

    /**
     * This method uses our google volley servie to return the content of the story for browser
     * purposes.
     * @param newsItem the news feed item
     * @param query the string of the faroo query
     * @param mAdapter the fragment news item
     * @return
     */
    public static String getContent(NewsItem newsItem,String query, NewsFeedItemFragment mAdapter){
        String content="Please Wait...Loading Content..";
        VolleyUtil.getContentFromFaroo(newsItem,query, mAdapter);
        return content;
    }
}
