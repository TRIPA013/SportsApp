package com.aa.sportstree.sportstree.pojos;

/**
 * Created by Abhinav on 11/9/2014.
 */
public class Team {
    private Sport sport;
    private String teamName;
    private String teamId; // every team has an id

    public Team(Sport sport, String teamName, String teamId) {
        this.sport = sport;
        this.teamName = teamName;
        this.teamId = teamId;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
