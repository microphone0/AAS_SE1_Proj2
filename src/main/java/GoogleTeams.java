/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Accept a list of names from a .txt and create a Matrix
 * Due Date: ¯\_(ツ)_/¯
 *
 *****************************************/

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
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;

public class GoogleTeams {
    private static int test = 0;
    private static int numberOfPeople = 0; // should be 9
    //private static int preferences = 6;

    // adam Saxtons variables
    private static int groupsize = 3;
    private static int verbosity = 1;
    private static int n = 1000;
    private static int l = 5;
    private static int r = 2;
    private static String fileName = "EMPTY";
    private static boolean v_one = false;
    private static boolean v_two = false;
    private static boolean v_three = false;
    private static boolean v_four = false;
    private static int totalNumPerson = 0; // readFile()
    private static ArrayList<String> bucket_list;
    private static ArrayList<String> teams_main;
    private static ArrayList<String> teams_other;
    private static ArrayList<String[]> preferences;

    private static int matrixColumns;
    private static int matrixRows;
    private static int[][] KeanuReeves;
    private static String[] testInputString = new String[]{"A,S,A2","S,A2,A", "A2,A,S"};
    private static ArrayList<String> matrixTestInput = new ArrayList<String>();/////
    private static ArrayList<String> inputString = new ArrayList<String>();
    private static ArrayList<String> peopleNames = new ArrayList<String>();

    private static ArrayList<ArrayList<String>> stringMatrix;
    private static ArrayList<String> allNames = new ArrayList<String>(); // used in createAdjacencyMatrix() // same as peopleNames
    private static ArrayList<ArrayList<Integer>> intMatrix;

    private static Double[] weights = null;
    private static Map<Integer,Integer> teams = null;



    // change input String into number of peopleNames
    public static void main(String[] args)
    {
        matrixTestInput.add("A,S,B");
        matrixTestInput.add("S,B,A");
        matrixTestInput.add("B,A,S");
        // reading input from comand line
        if (args.length > 0)
        {

            // iterating the args array and printing 
            // the command line arguments 
            for (int val = 0; val < args.length; val+=2)
            {

                // Verbosity
                if(args[val].equals("-v"))
                {
                    // The higher the number the more debugging code the user can see
                    if (Integer.valueOf(args[val + 1]) > 0) {
                        verbosity = Integer.valueOf(args[val+1]);
                        if (verbosity > 4){
                            verbosity = 4;
                        }
                    }
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

        // outputs command line information
        if(verbosity == 2)
        {
            System.out.println("The command line arguments are:\n"); 
            System.out.println("Verbosity: " + verbosity);
            System.out.println("Groupsize (t): " + groupsize);
            System.out.println("Verbosity 1: " + v_one);
            System.out.println("Verbosity 2: " + v_two);
            System.out.println("Verbosity 3: " + v_three);
            System.out.println("Verbosity 4: " + v_four);
            System.out.println("t: " + groupsize);
            System.out.println("n: " + n);
            System.out.println("l: " + l);
            System.out.println("r: " + r);
        }

        // scans file into inputString (arraylist)
        // if(test == 0)
		// {
        //     System.out.println("GoogleTeams:");
        //     Scanner scanner = new Scanner(System.in);
        //     String tempString = ""; // if needed
		// 	while(scanner.hasNext())
		// 	{
        //         inputString.add(scanner.next());
		// 	}
        // }

        // shows what inputString has // needs to be parsed
        for(int i = 0; i < inputString.size(); i++)
        {
            System.out.println(inputString.get(i));
        }

        // creates matrix
        System.out.println("New Matrix: ");
        //KeanuReeves = createMatrix(matrixTestInput);

        // outputs GroupSize, Number of People and Matrix
        System.out.println("GroupSize: " + groupsize);
        System.out.println("Number of People: " + numberOfPeople);
        //outputMatrix(KeanuReeves);

        pageRank();
        teamMaker();
    }



/////////////////////////////////////////////////////// moved from main file to new function for testing
public boolean readFile(String file) {

        System.out.println("ReadFile Function");
        String csvFile = file;
        String line = "";
        String cvsSplitBy = ",";
        bucket_list = new ArrayList<String>();
        teams_main = new ArrayList<String>();
        teams_other = new ArrayList<String>();
        preferences = new ArrayList<String[]>();
		
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
			totalNumPerson = numPerson-1;
            System.out.println("ReadFile WORKED");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
///////////////////////////////////////////////////////
    
   
    public static void pageRank() {
    	numberOfPeople = intMatrix.size();
        //int tempNumPeople = 5; // For testing, won't need when connecting to rest of program
        Double firstWeight = 1.0/numberOfPeople; // Used to initialize
        weights = new Double[numberOfPeople]; // Holds the final weights or what is currently been calculated
        double dampingFactor = .85; // Used at last step
        Integer[] numOutgoing = new Integer[numberOfPeople]; // Number of outgoing links
        Double[] newWeights = new Double[numberOfPeople]; // To hold temporarily the new weights calculated

        // The matrix components will need inner not outerMatrix when connecting to rest of the code
        //ArrayList<ArrayList<Integer>> outerMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner = new ArrayList<Integer>();

        // Initialize all arrays to 0
        for (int i=0; i < numberOfPeople; i++) {
            weights[i] = 0.0;
            numOutgoing[i] = 0;
            newWeights[i] = 0.0;
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
        // inner.add(0);     
        // inner.add(1);
        // inner.add(0);
        // inner.add(0);
        // inner.add(0);
        // outerMatrix.add(inner); // add first list
        // inner = new ArrayList<Integer>(); // create a new inner list

        // inner.add(0);     
        // inner.add(0);
        // inner.add(0); 
        // inner.add(0);
        // inner.add(1);                              
        // outerMatrix.add(inner); // add second list
        // inner = new ArrayList<Integer>(); // create a new inner list

        // inner.add(1);     
        // inner.add(1);
        // inner.add(0);
        // inner.add(1);
        // inner.add(1);                       
        // outerMatrix.add(inner);
        // inner = new ArrayList<Integer>();

        // inner.add(0);     
        // inner.add(0);
        // inner.add(1);
        // inner.add(0);
        // inner.add(1);                       
        // outerMatrix.add(inner);
        // inner = new ArrayList<Integer>();

        // inner.add(0);     
        // inner.add(0);
        // inner.add(0);
        // inner.add(1);
        // inner.add(0);                       
        // outerMatrix.add(inner);
        // inner = new ArrayList<Integer>();
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
            double numOut = 0;
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
            newWeights[i] = 0.0;
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
            newWeights[i] = 0.0;
        }

        if (verbosity >= 1) {
            System.out.print("Second Step: ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
        }

        // Apply damping factor (Last step)
        for (int i=0; i < weights.length; i++) {
            weights[i] = (1.0-dampingFactor)+(weights[i]*dampingFactor);
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
    	// Create Map to hold new teams
    	teams = Collections.synchronizedMap(new HashMap());

    	//Sort weight array to get highest pageRank
    	Arrays.sort(weights, Collections.reverseOrder());

    	//if (verbosity >= 2) {
    		System.out.print("Last Step (Damping): ");
            System.out.print(weights[0]);
            for (int i=1; i < weights.length; i++) {
                System.out.print(", "+weights[i]);
            }
            System.out.print("\n");
    	//}

    	for (int i=0; i < weights.length; i++) {
    		
    	}

    }



    // takes an arraylist of arraylist of Strings and returns adjacency arraylist of arraylist of Integers
    // works so long as allNames is assigned correctly  <-- *** needs to be fixed ***
    public static void createAdjacencyMatrix(ArrayList<ArrayList<String>> stringMatrix)
    {
        intMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempArrayList;
        boolean match = false;

        System.out.println( "allNames Size: " + allNames.size()); // test
        System.out.println( "stringMatrix Size: " + stringMatrix.size()); // test
        for(int outer = 0; outer < stringMatrix.size(); outer++)
        {
            tempArrayList = new ArrayList<Integer>(); // clears tempArrayList
            for(int compare = 0; compare < allNames.size(); compare++)
            {
                match = false; // resets match
                for(int inner = 1; inner < stringMatrix.get(outer).size(); inner++) // starts at one bc '0' doesnt count
                {
                    if(stringMatrix.get(outer).get(inner) == allNames.get(compare))
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



    public static void setAllNames(ArrayList<String> reassign)
    {
        // create new allNames that contains arrayList passed into method
        allNames = new ArrayList<String>(reassign);
    }


    public static ArrayList<ArrayList<Integer>> getIntMatrix() {
    	return intMatrix;
    }
}