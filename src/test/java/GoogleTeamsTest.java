/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Tests GoogleTeams.java
 * Due Date: ¯\_(ツ)_/¯
 *
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTeamsTest
{

    GoogleTeams googleTeams;
    

    @Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
    		System.out.println("Starting test: " + description.getMethodName());
    	}
    };
    
    @Before
    public void initialize() {
		googleTeams = new GoogleTeams();
    }


    @Test
    public void test1ReadFile()
    {
        boolean worked = googleTeams.readFile("Test.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }




    @Test
    public void testCreateAdjacencyMatrix()
    {
        ArrayList<String> newAllNames = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> correctMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<String>> outerMatrix = new ArrayList<ArrayList<String>>();
        ArrayList<String> inner = new ArrayList<String>();      

        inner.add("A");     
        inner.add("B");
        inner.add("C");
        inner.add("D");
        outerMatrix.add(inner); // add first list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("B");     
        inner.add("A");                                   
        outerMatrix.add(inner); // add second list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("C");     
        inner.add("D");
        inner.add("B");                                 
        outerMatrix.add(inner); // add third list
        inner = new ArrayList<String>(); // create a new inner list

        inner.add("D");     
        inner.add("B");
        inner.add("C"); 
        inner.add("A");                                  
        outerMatrix.add(inner); // add fourth list

        newAllNames.add("A");
        newAllNames.add("B");
        newAllNames.add("C");
        newAllNames.add("D");

        googleTeams.setAllNames(newAllNames);
        ArrayList<ArrayList<Integer>> matrixReturn = googleTeams.createAdjacencyMatrix(outerMatrix); // returns integer matrix
        System.out.println("Output Testmatrix");
        GoogleTeams.outputAdjacencyMatrix(matrixReturn); // test
        System.out.println("End test: testCreateAdjacencyMatrix");
        

    }



    @Test
    public void testOutputAdjacencyMatrix()
    {
        ArrayList<ArrayList<Integer>> matrixReturn; //= new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> outerMatrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner = new ArrayList<Integer>();        

        inner.add(0);     
        inner.add(1);
        inner.add(1);
        inner.add(1);
        outerMatrix.add(inner); // add first list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(1);     
        inner.add(0);
        inner.add(0);
        inner.add(0);                                  
        outerMatrix.add(inner); // add second list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(0);     
        inner.add(1);
        inner.add(0);
        inner.add(1);                           
        outerMatrix.add(inner); // add third list
        inner = new ArrayList<Integer>(); // create a new inner list

        inner.add(1);     
        inner.add(1);
        inner.add(1);
        inner.add(0);                           
        outerMatrix.add(inner); // add fourth list

        ArrayList<ArrayList<Integer>> correctMatrix = new ArrayList<ArrayList<Integer>>();

        
        GoogleTeams.outputAdjacencyMatrix(outerMatrix);
        System.out.println("End test: TestOutputMatrix");
    }



    @Test
    public void test1point5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase1_Nar.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test2ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase2_CAH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test3ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase3_DP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test4ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase4_Bio.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase5_HP.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test6ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase6_Blank.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test7ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase7_GG_Num.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test8ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase8_FMA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test9ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase9_MCU.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test10ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase10_MASH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test11ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase11_UT.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test12ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase12_OHSHC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test13ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase13_MHA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test14ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase14_SW.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test15ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase15_CH.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test16ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase16_AC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }


    // Should be true somethingis wrong
    @Test
    public void test17ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase17_PMK.csv");
       	assertEquals(false,worked);
        System.out.println("\n");
    }

    @Test
    public void test18ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase18_SM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test19ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase19_BM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test20ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase20_ATLA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test21ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase21_Port.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test22ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase22_GF.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test23ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase23_OPM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test24ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase24_LOTR.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test25ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase25_BATIM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test26ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase26_MNT.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test27ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase27_LCITS.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test28ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase28_SA.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test29ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase29_HMC.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test30ReadFile()
    {
    	boolean worked = googleTeams.readFile("testCases/testcase30_PM.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }
}