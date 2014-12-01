package com.aa.sportstree.sportstree.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.*;

import com.aa.sportstree.sportstree.pojos.UserSelection;
import com.google.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by Abhinav on 11/10/2014.
 */

/**
 * This class is a helper function to read in all of the files using some file reading logic.
 * It accesses the input stream to do this.
 */
public class FileUtil {
    public static List<String> getTeams(InputStream input) {
        List<String> teams = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(input);
            while (scanner.hasNext()) {
                teams.add(scanner.nextLine());

            }
        } catch (InputMismatchException e) {
            System.out.println("Didn't find " + e);
        }
        return teams;
    }

    /**
     * This method handles shared preferences and storing persistent data storage
     * for our application.
     * @param context the context of the application
     * @param teams the list of teams currently selected
     */
    public static void storeSharedPreferences(Context context, List<Team> teams) {

       try {
           SharedPreferences mPrefs = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
           UserSelection userSelection = new UserSelection(teams);
           SharedPreferences.Editor prefsEditor = mPrefs.edit();
           Gson gson = new Gson();
           String json = gson.toJson(userSelection);
           prefsEditor.putString("MyObject", json);
           prefsEditor.commit();
       }
       catch(Exception e){
           //To-Do
       }
    }

    /**
     * This method, with it's cohesive name, does the handling of what object
     * is selected by the clicking of the user. It utilizes the preferences chosen previously from
     * our appropriate getSharedPreferences method.
     * @param context the context of the application
     * @return the user selection of items
     */
    public static UserSelection getUserSelection(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        UserSelection userSelection = null;
        try {
            Gson gson = new Gson();
            String json = mPrefs.getString("MyObject", "");
            if (!json.isEmpty()) {
                userSelection = gson.fromJson(json, UserSelection.class);
            }
        }
        catch(Exception e){}
        return userSelection;
    }

    /**
     * This method takes the selections from previous methods, and
     * takes the context of the application. Afterwards, the list is returned to the caller.
     * @param context the context of the application
     * @return the user selected teams
     */
    public static List<Team> getTeams(Context context) {
        UserSelection userSelection = getUserSelection(context);
        if(userSelection==null){
            return null;
        }
        return userSelection.getTeamList();
    }
}
