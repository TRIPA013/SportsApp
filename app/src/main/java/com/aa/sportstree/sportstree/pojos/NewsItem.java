package com.aa.sportstree.sportstree.pojos;

/**
 * Created by Augth_000 on 11/10/2014.
 */
public class NewsItem {
    private String id;
    private String content;
    private Team team;
    //maybe an image
    public NewsItem(String id, String content, Team team) {
        this.id = id;
        this.content = content;
        this.team = team;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
