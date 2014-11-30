package com.aa.sportstree.sportstree.pojos;
import com.google.gson.annotations.Expose;

import java.io.*;
import java.util.*;
/**
 * Created by Abhinav on 11/9/2014.
 */
public class Team implements Serializable{
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

    @Override
    public String toString() {
        return teamName;
    }
}
