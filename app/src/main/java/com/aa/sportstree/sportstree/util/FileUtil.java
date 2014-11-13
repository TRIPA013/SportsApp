package com.aa.sportstree.sportstree.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.json.*;


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

    public static void storeSharedPreferences(List<String> sports) {
        Context context = null; //placeholder
        SharedPreferences prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
        String value = prefs.getString("list", null);

        //GsonBuilder gsonb = new GsonBuilder();
        //Gson gson = gsonb.create();
        //MyObject[] list = gson.fromJson(value, MyObject[].class);
    }
}
