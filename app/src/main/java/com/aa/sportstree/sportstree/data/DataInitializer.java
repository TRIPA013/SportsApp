package com.aa.sportstree.sportstree.data;

import android.content.Context;
import android.content.res.AssetManager;

import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;
import com.aa.sportstree.sportstree.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that helps initialize the sports when the user opens the application.
 * Created by Abhinav on 11/10/2014.
 */
public class DataInitializer {

    /**
     * List of all sports.
     */
    public static List<Sport> sports;

    /**
     * List of selected sports.
     */
    public static List<Sport> selectedSports;

    /**
     * List of all teams according to selected sports.
     */
    public static List<Team> teams;

    /**
     * List of selected teams.
     */
    public static List<Team> selectedTeams;

    /**
     * A method that sets the sports selected by the user and generates teams accordingly.
     * @param sports list of sports selected.
     */
    public static void setSelectedSports(List<Sport> sports){
        selectedSports = sports;
        teams = new ArrayList<Team>();
        for(Sport sport: selectedSports){
            teams.addAll(sport.getTeams());
        }
    }

    /**
     * A method that sets the selected teams.
     * @param context Context of the calling activity.
     * @param teams list of teams selected.
     */
    public static void setSelectedTeams(Context context,List<Team> teams){
        setSelectedTeams(teams);
        FileUtil.storeSharedPreferences(context,selectedTeams);
    }

    /**
     * A method that sets the teams selected.
     * @param teams list of teams selected.
     */
    public static void setSelectedTeams(List<Team> teams){
        selectedTeams = teams;
    }

    /**
     * A method that helps initialize all sports according to the text files in the application.
     * @param context Context of calling activity.
     * @throws IOException
     */
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
