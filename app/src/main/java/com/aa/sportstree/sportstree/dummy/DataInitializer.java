package com.aa.sportstree.sportstree.dummy;

import android.content.Context;
import android.content.res.AssetManager;

import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;
import com.aa.sportstree.sportstree.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhinav on 11/10/2014.
 */
public class DataInitializer {

    public static List<Sport> sports;

    public static void initializeAllSports(Context context) throws IOException {
        sports = new ArrayList<Sport>();
        AssetManager assetManager = context.getResources().getAssets();
        String[] listOfTextFiles = assetManager.list("");
        int id =0;
        for(String textFile: listOfTextFiles) {
            List<String> teamNames = FileUtil.getTeams(assetManager.open(textFile));
            Sport sport = new Sport(id++ + "",textFile.replace(".txt",""), null);
            int teamId=0;
            List<Team> teams = new ArrayList<Team>();
            for(String teamName: teamNames){
                Team team = new Team(sport, teamName,teamId++ +"" );
                teams.add(team);
            }
               sport.setTeams(teams);
            sports.add(sport);
        }
    }
}
