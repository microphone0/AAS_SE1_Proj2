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
    public void test1matrixTest()
    {
        ArrayList<String> matrixTest = new ArrayList<String>();

        matrixTest.add("adam, sam, adam2");
        matrixTest.add("sam, adam, adam2");
        matrixTest.add("adam2, sam, adam");

        int [][] matrix = googleTeams.createMatrix(matrixTest);
        int [][] realMatrix = {{0,1,0},{1,0,1},{1,1,0}};

        //assertEquals(realMatrix, matrix);
        for(int i = 0; i < realMatrix.length; i++)
        {
            for(int j = 0; j < realMatrix[i].length; j++)
            {
                assertEquals(realMatrix[i][j], matrix[i][j]);
            }
        }

    }

    @Test
    public void test1point5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase1.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test2ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase2.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test3ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase3.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test4ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase4.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test5ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase5.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test6ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase6.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test7ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase7.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test8ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase8.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test9ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase9.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test10ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase10.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test11ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase11.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test12ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase12.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test13ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase13.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test14ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase14.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test15ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase15.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test16ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase16.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test17ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase17.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test18ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase18.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test19ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase19.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    @Test
    public void test20ReadFile()
    {
    	boolean worked = googleTeams.readFile("testcase20.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }
}