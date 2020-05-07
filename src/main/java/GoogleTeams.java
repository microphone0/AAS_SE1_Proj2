/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Accept a list of names from a .txt and create a Matrix
 * Due Date: ¯\_(ツ)_/¯
 *
 *****************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Random;
import java.lang.Object;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;

public class GoogleTeams {
    // global variables
    private static int numberOfPeople = 0;
    private static int groupsize = 3; // -t
    private static int verbosity = 0; // -v
    private static boolean v_one = false; // delete
    private static ArrayList<String> bucket_list;
    private static String fileName = ""; // sub for readFile() to work
    public static ArrayList<ArrayList<String>> stringMatrix;
    public static ArrayList<String> allNames = new ArrayList<String>();
    public static ArrayList<ArrayList<Integer>> intMatrix;
    private static Float[] weights = null;
    private static ArrayList<Float> posInMatrix = null;
    private static ArrayList<ArrayList<Integer>> teams;
    // setters for variables
    public void v_oneSetter(boolean setterV_one) { v_one = setterV_one; }

    // getters
    public static ArrayList<ArrayList<Integer>> getIntMatrix() { return intMatrix; }
    public static ArrayList<ArrayList<String>> getStringMatrix() { return stringMatrix; }
    public ArrayList<String> getAllNames() { return allNames; }

    // reset function for testing
    public static void reset() {
        numberOfPeople = 0;
        groupsize = 3;
        verbosity = 0;

        stringMatrix = new ArrayList<ArrayList<String>>();
        allNames = new ArrayList<String>();
        intMatrix = new ArrayList<ArrayList<Integer>>();
        weights = null;
    }


    // change input String into number of peopleNames
    public static void main(String[] args)
    {
        // reading input from comand line
        if (args.length > 0)
        {

            // iterating the args array and printing 
            // the command line arguments 
            for (int val = 0; val < args.length; val+=2)
            {

                // Verbosity // The higher the number the more debugging code the user can see
                if(args[val].equals("-v"))
                {
                    verbosity = Integer.valueOf(args[val+1]);
                }

                // GroupSize
                if(args[val].equals("-t")){
                    groupsize = Integer.valueOf(args[val+1]);
                }
            }
        }
        else {
            System.out.println("No command line "+ 
                               "arguments found."); 
        }            

        // outputs command line information
        if(verbosity >= 2)
        {
            System.out.println("\nThe command line arguments are:"); 
            System.out.println("Verbosity (v): " + verbosity);
            System.out.println("Groupsize (t): " + groupsize);
            System.out.println("Filename: " + fileName);
        }

        // reads in file
        readFile(fileName);
        // creates matrix
        System.out.println("New Matrix: ");
        createAdjacencyMatrix();
        outputAdjacencyMatrix(intMatrix); // -v
        pageRank();
        teamMaker();
    }



    public static boolean readFile(String file) {

        System.out.println("ReadFile Function");
        String line = "";
        String cvsSplitBy = ", ";
        bucket_list = new ArrayList<String>(); // can delete
        stringMatrix = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner;

        // numPerson help with tracking the people in the csv and makes printing more sense
        int numPerson = 1;
        
        Scanner scanner = new Scanner(System.in);

        //try (System.in != null) {

            while (scanner.hasNext()) {

                line = scanner.nextLine();
                System.out.println("SCANNER OUTPUT: " + line);
                // use comma as separator
                // doesn't need quotes around any of the things in the file
                // may cause type errors in the future
                String[] member = line.split(cvsSplitBy);

                System.out.println("Member String Array:");
                for (int i = 0; i < member.length; i++){
                    System.out.println(member[i]);
                }
                allNames.add(member[0]); // assings each name into all names //* need to check if in allNames for A Proposal *//
                
                // creating Arraylist of Arraylist String matrix
                inner = new ArrayList<String>();
                for (int i = 0; i < member.length; i++)
                {
                    inner.add(member[i]);
                }
                stringMatrix.add(inner);

                if(v_one){
                    // Print out what's in the csv
                    System.out.print("Member "+numPerson+": "+member[0]+" [");
                    if (member.length > 1){
                        System.out.print(member[1]);
                        for (int i = 2; i < member.length; i++) {
                            System.out.print(","+member[i]);
                        }
                    }
                    System.out.println(" ]");
                }
                bucket_list.add(String.valueOf(numPerson));
                				
				numPerson++;
            }
            // -v // outputStringMatrix(stringMatrix);
            System.out.println("FINISHED RUNNING READFILE");
            
            return true;

        // } catch (IOException e) {
        //     e.printStackTrace();
        //     System.out.println("DID NOT READ FILE IN CORRECTLY");
        //     return false;
        // }

    }

    
   
    public static void pageRank() {
    	numberOfPeople = intMatrix.size();
        numberOfPeople = 5; // For testing, won't need when connecting to rest of program
        Float firstWeight = 1.0f/numberOfPeople; // Used to initialize
        weights = new Float[numberOfPeople]; // Holds the final weights or what is currently been calculated
        float dampingFactor = .85f; // Used at last step
        Integer[] numOutgoing = new Integer[numberOfPeople]; // Number of outgoing links
        Float[] newWeights = new Float[numberOfPeople]; // To hold temporarily the new weights calculated

        // The matrix components will need inner not outerMatrix when connecting to rest of the code
        intMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner = new ArrayList<Integer>();

        // Initialize all arrays to 0
        for (int i=0; i < numberOfPeople; i++) {
            weights[i] = 0.0f;
            numOutgoing[i] = 0;
            newWeights[i] = 0.0f;
        }

        // ALL TESTING CODE ***********************
        //////////////////////////////////////////////////////////////// Adam G added
        /* code to create Matrix (ArrayList of Arraylist) 
          A B C
        A 0 1 1
        B 1 0 0
        C 0 1 0
        
        https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
        https://stackoverflow.com/questions/25147799/java-arraylist-of-arraylist
        */        

        // inner.add(0);     
        // inner.add(1);
        // inner.add(1);
        // outerMatrix.add(inner); // add first list
        // inner = new ArrayList<Integer>(); // create a new inner list

        // inner.add(1);     
        // inner.add(0);
        // inner.add(0);                               
        // outerMatrix.add(inner); // add second list
        // inner = new ArrayList<Integer>(); // create a new inner list

        // inner.add(0);     
        // inner.add(1);
        // inner.add(0);                       
        // outerMatrix.add(inner); // add third list
        //*******************************************
        /////////////////////////////////////////////////////////        
        /////////////////////////////////////////////////////////
        // ALL TESTING CODE ***********************
        /////Vertical is INCOMING; Horizontal is OUTGOING
        /*
          A B C D E
        A 0 1 0 0 0
        B 0 0 0 0 1
        C 1 1 0 1 1
        D 0 0 1 0 1
        E 0 0 0 1 0

        A has one incoming from C; and C has one outgoing to A
        B has one incoming from A; and B has one outgoing to E
        */
        inner.add(0);     
        inner.add(1);
        inner.add(0);
        inner.add(0);
        inner.add(0);
        intMatrix.add(inner); // add first list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(0);     
        inner.add(0);
        inner.add(0); 
        inner.add(0);
        inner.add(1);                              
        intMatrix.add(inner); // add second list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(1);     
        inner.add(1);
        inner.add(0);
        inner.add(1);
        inner.add(1);                       
        intMatrix.add(inner);
        inner = new ArrayList<Integer>();

        inner.add(0);     
        inner.add(0);
        inner.add(1);
        inner.add(0);
        inner.add(1);                       
        intMatrix.add(inner);
        inner = new ArrayList<Integer>();

        inner.add(0);     
        inner.add(0);
        inner.add(0);
        inner.add(1);
        inner.add(0);                       
        intMatrix.add(inner);
        inner = new ArrayList<Integer>();
        //*******************************************

        // Initialize weights (Initial step)
        for (int i=0; i < weights.length; i++) {
            weights[i] = firstWeight;
        }

        if (verbosity >= 1) {
            System.out.print("First Weights: ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }
        
        // Calculate outgoing links (First step A)
        // Divide the weights by the number of outgoing links
        for (int i=0; i < intMatrix.size(); i++) {
            int numOut = 0;
            // Get the row at i
            inner = intMatrix.get(i);
            for (int j=0; j < inner.size(); j++) {
                if (inner.get(j) == 1) {
                    numOut++;
                    numOutgoing[i] = numOutgoing[i]+1;
                }
            }
            weights[i] = weights[i]/numOut;
        }

        if (verbosity >= 3) {
            System.out.print("Outgoing Array: ");
            System.out.print(numOutgoing[0]);
            for (int i=1; i < numOutgoing.length; i++) {
                System.out.print(", "+numOutgoing[i]);
            }
            System.out.print("\n");
        }

        if (verbosity >= 1) {
            System.out.print("First Step A: ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }

        // Calculate incoming links (First step B)
        // Add the weights of the incoming links and assign to the node we are looking at
        for (int i=0; i < intMatrix.size(); i++) {
            // Get the row at i
            inner = intMatrix.get(i);
            for (int j=0; j < inner.size(); j++) {
                if (inner.get(j) == 1) {
                    newWeights[j] += weights[i];
                }
            }
        }
        // Initialize newWeights to all 0 (I had to do this the long annoying way for it to work)
        for (int i=0; i < newWeights.length; i++) {
            weights[i] = newWeights[i];
            newWeights[i] = 0.0f;
        }

        if (verbosity >= 1) {
            System.out.print("First Step B: ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }

        // Calculate PageRank (Second step)
        // Basically combining both parts of step 1 (made it easier to figure out splitting them first)
        for (int i=0; i < intMatrix.size(); i++) {
            // Get the row at i
            inner = intMatrix.get(i);
            for (int j=0; j < inner.size(); j++) {
                if (inner.get(j) == 1) {
                    newWeights[j] = newWeights[j]+(weights[i]/numOutgoing[i]);
                }
            }
        }
        // Initialize newWeights to all 0 (I had to do this the long annoying way for it to work)
        for (int i=0; i < newWeights.length; i++) {
            weights[i] = newWeights[i];
            newWeights[i] = 0.0f;
        }

        if (verbosity >= 1) {
            System.out.print("Second Step: ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }

        posInMatrix = new ArrayList<Float>();

        // Apply damping factor (Last step)
        for (int i=0; i < weights.length; i++) {
            Float temp = (weights[i]*dampingFactor);
            Float temp1 = (1.0f-dampingFactor);
            weights[i] = (1.0f-dampingFactor)+(weights[i]*dampingFactor);
            posInMatrix.add(i,(temp1+temp));
        }

        if (verbosity >= 1) {
            System.out.print("Last Step (Damping): ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }
    }



    public static void teamMaker() {

        // Initailize the teams data structure and data structure currently holding the team that is being built
    	  teams = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentTeam;

        ArrayList<Float> sortedPR = new ArrayList<Float>();
        for (int i=0; i < weights.length; i++) {
            sortedPR.add(weights[i]);
        }

        // Sort the list in Descending Order, so we can get the highest PageRank
        sortedPR.sort(Collections.reverseOrder());
        currentTeam = new ArrayList<Integer>();
        
        for (int i=0; i < sortedPR.size(); i++) {

            boolean notInTeam = true;

            ArrayList<Integer> checkingTeam;
            int tempIndex = posInMatrix.indexOf(sortedPR.get(i));
            // Check if index is in team already
            for (int j=0; j < teams.size(); j++) {

                checkingTeam = new ArrayList<Integer>();
                checkingTeam = teams.get(j);
                if (checkingTeam.contains(tempIndex)) {
                    notInTeam = false;
                }
            }

            // Start making teams
            if (notInTeam) {

                currentTeam.add(tempIndex);
                ArrayList<Integer> tempPref = new ArrayList<Integer>();
                tempPref = intMatrix.get(tempIndex);
                for (int k=1; k < groupsize; k++) {

                    boolean didNotGetOne = true;
                    for (int l=0; didNotGetOne && l < tempPref.size(); l++) {

                        int oneOrNot = tempPref.get(l);
                        if (oneOrNot == 1) {
                            // Check if index is in team already
                            boolean notInTeam2 = true;
                            for (int j=0; j < teams.size(); j++) {

                                checkingTeam = teams.get(j);
                                if (checkingTeam.contains(tempPref.indexOf(oneOrNot)) && currentTeam.contains(tempPref.indexOf(oneOrNot))) {
                                    notInTeam2 = false;
                                }
                            }

                            if (notInTeam) {
                                int tempIndex2 = tempPref.indexOf(oneOrNot);
                                currentTeam.add(tempIndex2);
                                didNotGetOne = false;
                            }
                        }
                    }

                    if (didNotGetOne) {
                        boolean notDone = true;
                        for (int n=0; notDone && n < sortedPR.size(); n++) {
                            boolean notInTeam3 = true;

                            ArrayList<Integer> checkingTeam2;
                            int tempIndex2 = posInMatrix.indexOf(sortedPR.get(n));
                            // Check if index is in team already
                            for (int j=0; j < teams.size(); j++) {

                                checkingTeam2 = new ArrayList<Integer>();
                                checkingTeam2 = teams.get(j);
                                if (checkingTeam2.contains(tempIndex2) && currentTeam.contains(tempIndex2)) {
                                    notInTeam3 = false;
                                }
                            }

                            if (notInTeam3) {
                                currentTeam.add(tempIndex2);
                                notDone = false;
                                tempIndex = tempIndex2;
                                tempPref = intMatrix.get(tempIndex2);
                            }
                        }
                    }
                }
                System.out.println("Current Team: ");
                for (int j=0; j < currentTeam.size(); j++) {
                    System.out.print(" "+currentTeam.get(j));
                }
                System.out.println("\n");
                
                teams.add(currentTeam);
                currentTeam = new ArrayList<Integer>();
            }
        }

        ArrayList<Integer> tempCurrentTeam = new ArrayList<Integer>();
        System.out.println("Teams:");
        for (int i=0; i < teams.size(); i++) {
            tempCurrentTeam = teams.get(i);
            for (int j=0; j < tempCurrentTeam.size(); j++) {
                System.out.print(" "+tempCurrentTeam.get(j));
            }
            System.out.print("\n");
        }
    }



    // takes an arraylist of arraylist of Strings and returns adjacency arraylist of arraylist of Integers
    // works so long as allNames is assigned correctly  <-- *** needs to be fixed ***
    public static void createAdjacencyMatrix()
    {
        intMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempArrayList;
        boolean match = false;

        // -v // System.out.println( "allNames Size: " + allNames.size()); // needs to be put in 
        // -v // System.out.println( "stringMatrix Size: " + stringMatrix.size()); // test
        for(int outer = 0; outer < stringMatrix.size(); outer++)
        {
            tempArrayList = new ArrayList<Integer>(); // clears tempArrayList
            for(int compare = 0; compare < allNames.size(); compare++)
            {
                match = false; // resets match
                for(int inner = 1; inner < stringMatrix.get(outer).size(); inner++) // starts at one bc '0' doesnt count
                {
                    if( stringMatrix.get(outer).get(inner).contains(allNames.get(compare) ))
                        match = true;
                }

                if(match) 
                    tempArrayList.add(1); // if match inset 1
                if(!match) 
                    tempArrayList.add(0); // if no match insert 0
            }
            intMatrix.add(tempArrayList); // adds a row to intMatrix
        }

    }



    // outputs adjecency matrix
    public static void outputAdjacencyMatrix(ArrayList<ArrayList<Integer>> matrix) // may not need parameters
    {
        for(int outer = 0; outer < matrix.size(); outer++)
        {
            System.out.println( matrix.get(outer) );
        }
    }



    // outputs string matrix
    public static void outputStringMatrix(ArrayList<ArrayList<String>> matrix) // may not need parameters
    {
        for(int outer = 0; outer < matrix.size(); outer++)
        {
            System.out.println( matrix.get(outer) );
        }
    }



    public static void setAllNames(ArrayList<String> reassign)
    {
        // create new allNames that contains arrayList passed into method
        allNames = new ArrayList<String>(reassign);
    }
}