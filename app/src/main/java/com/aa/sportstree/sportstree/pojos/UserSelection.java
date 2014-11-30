package com.aa.sportstree.sportstree.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 11/17/2014.
 */
public class UserSelection implements  Serializable{

    List<Team> teamList;

    public UserSelection( List<Team> teamList) {
        this.teamList = teamList;
    }



    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }
}
