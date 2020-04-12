/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Accept a list of names from a .txt and create a Matrix
 * Due Date: ¯\_(ツ)_/¯
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Random;
import java.lang.Object;
import java.util.*;

public class GoogleTeams {
    private static int test = 0;
    private static int numberOfPeople = 0; // should be 9
    private static int preferences = 6;

    // adam Saxtons variables
    private static int groupsize = 3;
    private static int n = 1000;
    private static int l = 5;
    private static int r = 2;
    private static String fileName = "EMPTY";
    private static boolean v_one = false;
    private static boolean v_two = false;
    private static boolean v_three = false;
    private static boolean v_four = false;
    private static int totalNumPerson = 0; // readFile()

    private static int matrixColumns;
    private static int matrixRows;
    private static int[][] KeanuReeves;
    private static String[] testInputString = new String[]{"Calvin", "Bubba", "Blinkendorfer", "Suzie", "Snoopie", "Donald", "Billy", "Ivanka", "Mitch"};
    private static ArrayList<String> inputString = new ArrayList<String>();
    private static ArrayList<String> peopleNames = new ArrayList<String>();

    // change input String into number of peopleNames
    public static void main(String[] args)
    {
        // reading input from comand line
        if (args.length > 0)
        { 

            System.out.println("The command line"+ 
                               " arguments are:"); 

            // iterating the args array and printing 
            // the command line arguments 
            for (int val = 0; val < args.length; val+=2)
            {

                // verbosity
                if(args[val].equals("-v"))
                {
                    // The higher the number the more debugging code the user can see
                    if(Integer.valueOf(args[val + 1]) > 0){
                        v_one = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 1){
						v_one = true;
                        v_two = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 2){
						v_one = true;
                        v_two = true;
                        v_three = true;
                    }

                    if(Integer.valueOf(args[val + 1]) > 3){
						v_one = true;
                        v_two = true;
                        v_three = true;
                        v_four = true;
                    }
                }

                // GroupSize
                if(args[val].equals("-t")){
                    groupsize = Integer.valueOf(args[val+1]);
                }
                
                // looptimes
                if(args[val].equals("-n")){
                    n = Integer.valueOf(args[val+1]);
                }

                // how many shuffles
                if(args[val].equals("-l")){
                    l = Integer.valueOf(args[val+1]);
                }

                // decline percentage
                if(args[val].equals("-r")){
                    r = Integer.valueOf(args[val+1]);
                }
            }
        }
        else {
            System.out.println("No command line "+ 
                               "arguments found."); 
        }
        
        // outputs everything from command line
        for(String s : args){
            System.out.println(s);
            }
        
        // outputs command line information
        if(v_two)
        {
            System.out.println("Verbosity 1: " + v_one);
            System.out.println("Verbosity 2: " + v_two);
            System.out.println("Verbosity 3: " + v_three);
            System.out.println("Verbosity 4: " + v_four);
            System.out.println("Groupsize: " + groupsize);
            System.out.println("n: " + n);
            System.out.println("l: " + l);
            System.out.println("r: " + r);
        }

        // scans file into inputString (arraylist)
        if(test == 0)
		{
            System.out.println("GoogleTeams:");
            Scanner scanner = new Scanner(System.in);
            String tempString = ""; // if needed
			while(scanner.hasNext())
			{
                inputString.add(scanner.next());
			}
        }

        // shows what inputString has // needs to be parsed
        for(int i = 0; i < inputString.size(); i++)
        {
            System.out.println(inputString.get(i));
        }

        // reads in csv file
        System.out.println("Read in file:" + fileName);
        readFile(fileName);

        // creates matrix
        System.out.println("New Matrix: ");
        KeanuReeves = createMatrix(inputString);

        // outputs GroupSize, Number of People and Matrix
        System.out.println("GroupSize: " + groupsize);
        System.out.println("Number of People: " + numberOfPeople);
        outputMatrix(KeanuReeves);
    }

/////////////////////////////////////////////////////// moved from main file to new function for testing
public static boolean readFile(String csvFile) {
    System.out.println("READFILE FUNCTION:");
    String line = "";
    String cvsSplitBy = ",";
    ArrayList<String> bucket_list = new ArrayList<String>();
    ArrayList<String> teams_main = new ArrayList<String>();
    ArrayList<String> teams_other = new ArrayList<String>();
    ArrayList<String[]> preferences = new ArrayList<String[]>();
    
    // v_one = true;
    // v_two = true;
    // v_three = true;
    // v_four = true;

    // numPerson help with tracking the people in the csv and makes printing more sense
    int numPerson = 1;
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

        while ((line = br.readLine()) != null) {

            // use comma as separator
            // doesn't need quotes around any of the things in the file
            // may cause type errors in the future
            String[] member = line.split(cvsSplitBy);

            preferences.add(member);

            if(v_one){
                // Print out what's in the csv
                System.out.print("Member "+numPerson+": "+member[0]+" [");
                if (member.length > 1){
                    System.out.print(member[1]);
                    for (int i = 2; i < member.length; i++) {
                        System.out.print(","+member[i]);
                    }
                }
                System.out.println("]");
            }
            bucket_list.add(String.valueOf(numPerson));
                            
            numPerson++;
        }

        teams_other = bucket_list;
        totalNumPerson = numPerson - 1;

        return true;

    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }

}
///////////////////////////////////////////////////////

    // takes input String and creates a matrix
    public static int[][] createMatrix(ArrayList<String> becomeMatrix)
    {
        ArrayList<String> parsedArrayList = new ArrayList<String>(); // to be returned
        String tempString;
        String[] splitArray;

        // could become arraylist to split array function
        for(int i = 0; i < becomeMatrix.size(); i++)
        {
            // copy into tempstring
            tempString = becomeMatrix.get(i);

            // split temp string and assign to array
            splitArray = tempString.split(",");

            // take first in array and assign into names string
            peopleNames.add(splitArray[0]);
        }

        // creates new matrix with dimenensions
        numberOfPeople = peopleNames.size();
        int[][] newMatrix = new int[numberOfPeople][numberOfPeople];

        // assign splitArray values into matrix (two for loops)
        for(int i = 0; i < peopleNames.size(); i++)
        {
            tempString = becomeMatrix.get(i);
            splitArray = tempString.split(",");
            

            for(int n = 0; n < splitArray.length; n++)
            {
                
            }

        }

        return newMatrix;
    }
    


    // for demo
    public static void outputMatrix(int[][] matrix)
    {
        String matrixOutputLine;
        for(int i = 0; i < matrix.length; i++)
        {
            matrixOutputLine = "";
            for(int n = 0; n < matrix[i].length; n++)
            {
                matrixOutputLine = matrixOutputLine + matrix[i][n];
            }
            System.out.println(matrixOutputLine);
        }
    }

}