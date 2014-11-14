package com.aa.sportstree.sportstree.util;

import com.aa.sportstree.sportstree.dummy.DataInitializer;
import com.aa.sportstree.sportstree.pojos.NewsItem;
import com.aa.sportstree.sportstree.pojos.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 11/14/2014.
 */
public class NewsUtil {

    public static List<NewsItem> getNewsList(){
        List<NewsItem> newsItems = new ArrayList<NewsItem>();
        List<Team> teams =DataInitializer.selectedTeams;
        if(teams!=null) {
            int id =0;
            for (Team team : teams) {
                String content = getContent(team.getTeamName() + " " + team.getSport().getName());
                NewsItem newsItem = new NewsItem(""+id++, content, team,"");
                newsItems.add(newsItem);
            }
        }
        return newsItems;
    }

    public static String getContent(String query){
        String content="Please Wait...Loading Content..";
        return content;
    }
}
