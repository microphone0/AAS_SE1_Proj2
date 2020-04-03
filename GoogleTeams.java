/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Accept a list of names from a .txt and create a Matrix
 * Due Date: ¯\_(ツ)_/¯
 *
 */

import java.lang.Object;
import java.util.*;
import java.util.Arrays;
import java.util.Random;

public class GoogleTeams {
    private static int test = 0;
    private static int numberOfPeople = 0; // should be 9
    private static int preferences = 6;

    // adam Saxtons variables
    private static int groupsize = 3;
    private static int n = 1000;
    private static int l = 5;
    private static int r = 2;
    private static boolean v_one = false;
    private static boolean v_two = false;
    private static boolean v_three = false;
    private static boolean v_four = false;

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

        // creates and outputs matrix
        System.out.println("");
        System.out.println("New Matrix: ");
        KeanuReeves = createMatrix(inputString);

        System.out.println("GroupSize: " + groupsize);
        System.out.println("Number of People: " + numberOfPeople);
        outputMatrix(KeanuReeves);
    }



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