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

    public static List<Team> getTeams(Context context) {
        UserSelection userSelection = getUserSelection(context);
        if(userSelection==null){
            return null;
        }
        return userSelection.getTeamList();
    }
}
