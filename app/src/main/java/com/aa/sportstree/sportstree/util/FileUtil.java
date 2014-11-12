package com.aa.sportstree.sportstree.util;

import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Abhinav on 11/10/2014.
 */
public class FileUtil {
    public static List<String> getTeams(File file) {
        List<String> teams = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                teams.add(scanner.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Didn't find " + e);
        }


        return teams;
    }
}
