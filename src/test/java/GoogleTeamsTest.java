/******************************************
 * Team Name: Project 2 Electric Googleoo
 * Authors: Adam Garcia, Adam Saxton, Sam Web
 * Class: Spring 2020 Dr,Reeves CS 3preference4 SE
 * Task: Tests GoogleTeams.java
 * Due Date: ¯\_(ツ)_/¯
 *
 */

import static org.junit.Assert.assertEquals;

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
    		System.out.println("Google Starting test: " + description.getMethodName());
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
        System.out.println("finishedtest1");
    }

}