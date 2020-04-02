import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Random;
import java.util.*;

public class HappyTeams {

    private int totalNumPerson = 0;
    private ArrayList<String> bucket_list = null;
    private ArrayList<String[]> preferences = null;
    private ArrayList<String> teams_main = null;
    private ArrayList<String> teams_other = null;

    private int happiness_main = 0;
    private int zero_count_main = 0;
    private int happiness_other = 0;
    private int zero_count_other = 0;

    // Variables that will get the values from the command line args
    private static int groupsize = 4;
    private static int n = 1000;
    private static int l = 5;
    private static int r = 2;
    private static boolean v_one = false;
    private static boolean v_two = false;
    private static boolean v_three = false;
    private static boolean v_four = false;

    public static void main(String[] args) { 
        // check if length of args array is 
        // greater than 0 

        if (args.length > 0) { 

            System.out.println("The command line"+ 
                               " arguments are:"); 

            // iterating the args array and printing 
            // the command line arguments 
            for (int val = 0; val < args.length; val+=2) {

                if(args[val].equals("-v")){
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

                if(args[val].equals("-t")){
                    groupsize = Integer.valueOf(args[val+1]);
                }

                if(args[val].equals("-n")){
                    n = Integer.valueOf(args[val+1]);
                }

                if(args[val].equals("-l")){
                    l = Integer.valueOf(args[val+1]);
                }

                if(args[val].equals("-r")){
                    r = Integer.valueOf(args[val+1]);
                } 
            }
        } else {
            System.out.println("No command line "+ 
                               "arguments found."); 
        }
        if(v_two){
            System.out.println(v_one);
            System.out.println(v_two);
            System.out.println(v_three);
            System.out.println(v_four);
            System.out.println(groupsize);
            System.out.println(n);
            System.out.println(l);
            System.out.println(r);
        }
    }

    public boolean readFile(String file) {

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

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void swap() {
        ArrayList<String> group = new ArrayList<String>();
        ArrayList<String[]> test = new ArrayList<String[]>(); //test contains the names and numbers of the csv
        ArrayList<String[]> csv_number_list = new ArrayList<String[]>();
        ArrayList<String> current_team = new ArrayList<String>();

        int happiness_team = 0;
        int zero_count_team = 0;
        int counter = 0;
        int a = 0;
        int rand_1 = 0;
        int rand_2 = 0;

        // Pick two random people to swap
        Random rand = new Random();
        rand_1 = rand.nextInt(bucket_list.size()-1);
        rand_2 = rand.nextInt(bucket_list.size()-1);
        if(v_three) {
            System.out.println(bucket_list.size()-1);
            System.out.println("Rand_1: "+rand_1);
            System.out.println("Rand_2: "+rand_2);
        }

        String swapholder = "";
        swapholder = teams_other.get(rand_1);
        teams_other.set(rand_1,teams_other.get(rand_2));
        teams_other.set(rand_2,swapholder);    
        if(v_two){
            System.out.println("Swapholder works");
            System.out.println("rand_1 works");
            System.out.println("rand_2 works");
        }
        if(v_three){
                    System.out.println("swapholder="+swapholder);
                    System.out.println("Current_List swapped:" + current_team);
        }
                

        int runtime = (int) Math.ceil((double) teams_other.size() / groupsize);
        
        if(v_one){
                System.out.println("runtime="+runtime);
            }

        for(int outer = 0; outer < runtime; outer++){
            
            //Checks how long current_team is
            counter = 0;
            
            // GRAB TEAM WE WANT TO CHECK NEXT
            for(int b = 0; b < groupsize && a < teams_other.size(); b++){
                current_team.add(teams_other.get(a).toString());
                a++;
                counter++;
            }
            
            if(v_one){
                System.out.println("outer="+outer);
            }

            // TO PRINT OUT current team
            if(v_two){
                for(int x = 0; x < current_team.size(); x++){
                    System.out.println("current_team: "+current_team.get(x));
                }
                System.out.println("END OF ITERATION");
            }

            // Loops through current_teams
            for(int d = 0; d < counter; d++){
                
                if(v_one){
                    System.out.println("d="+d);
                }
                

                //TO PRINT OUT current team
                if(v_two){
                
                    System.out.println("current_team(d): "+current_team.get(d));
                }
                
                int num = preferences.get(Integer.valueOf(current_team.get(d))-1).length; // ))-1
                
                if(v_three){
                    System.out.println("Length" +num);
                    
                    System.out.println("current_team d:" +current_team.get(d));
                }
                
                // Take member of current_teams and look at their preferences to see how happy they are
                for(int f = 1; f < num; f++){
                    
                    if(v_four){
                        System.out.println("Members: "+preferences.get(Integer.valueOf(current_team.get(d))-1)[f]);
                    }
                    if(current_team.get(Integer.valueOf(d)).equals(preferences.get(Integer.valueOf(current_team.get(d))-1)[f])){
                        happiness_team += (num - (f+1));
                    }
                }

                happiness_other += happiness_team;

                if(happiness_team == 0){
                    zero_count_team += 1;
                } 
            }

            zero_count_other += zero_count_team;

            if(v_two){
                System.out.println("happiness_team: "+happiness_team);
                System.out.println("unhappiness_team: "+zero_count_team);
            }
            
            happiness_team = 0;
            zero_count_team = 0;
            
            //TO RESET current_team so you can grab next team
            current_team.clear();
        }
        //System.out.println("Here");
        if(happiness_main < happiness_other && zero_count_main >= zero_count_other) {
            swapholder = teams_other.get(rand_1);
            teams_other.set(rand_1,teams_other.get(rand_2));
            teams_other.set(rand_2,swapholder); 
            if(v_two){
                System.out.println("Swapholder works");
                System.out.println("rand_1 works");
                System.out.println("rand_2 works");
            }
            if(v_two){
                    System.out.println("Current_List reverted: " + current_team);
            }
        }
        if (v_two) {
            System.out.println("Main happiness: "+happiness_main);
            System.out.println("Main zeroes: "+zero_count_main);
            System.out.println("Other happiness: "+happiness_other);
            System.out.println("Other zeroes: "+zero_count_other);
        }
    }

	public void happy_Checker() {
        for (int i = 0; i < n; i++) {
            swap();
        }
        if((happiness_main < happiness_other && zero_count_main >= zero_count_other) || happiness_main == 0) {
            teams_main = teams_other;
            happiness_main = happiness_other;
            zero_count_main = zero_count_other;
        }
        System.out.println("Teams"+teams_main);
        System.out.println("Happiness: "+happiness_main);
        System.out.println("Unhappiness: "+zero_count_main);
        happiness_other = 0;
        zero_count_other = 0;
    }

    public int getL() {
        return l;
    }
	
    public List getList() {
        return teams_main;
    }

    public int getHappinessMain() {
        return happiness_main;
    }

    public int getZeroCountMain() {
        return zero_count_main;
    }

    public boolean randomizer(List<Integer> bucket_list) {
        if (teams_other == null) {
            return false;
        }
        Collections.shuffle(teams_other);
        //System.out.println("Teams "+teams_other);
        return true;
    }

    public int getTotalNumPerson() {
        return totalNumPerson;
    }

    public void clearTotalNumPerson() {
        totalNumPerson = 0;
    }

}
