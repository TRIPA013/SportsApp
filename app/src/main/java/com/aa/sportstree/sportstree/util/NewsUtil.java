package com.aa.sportstree.sportstree.util;

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

    public static String getContent(NewsItem newsItem,String query, NewsFeedItemFragment mAdapter){
        String content="Please Wait...Loading Content..";
        VolleyUtil.getContentFromFaroo(newsItem,query, mAdapter);
        return content;
    }
}
