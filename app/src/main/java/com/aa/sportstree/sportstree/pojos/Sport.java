package com.aa.sportstree.sportstree.pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abhinav on 11/9/2014.
 */
public class Sport implements Serializable {


    private String id;

    private String name;

    transient private List<Team> teams;


    public Sport(String id, String name, List<Team> teams) {
        this.id = id;
        this.name = name;
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return name;
    }
}
