import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HappyTeamsTest
{
    HappyTeams teams;

    @Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
    		System.out.println("Starting test: " + description.getMethodName());
    	}
    };
    
    @Before
    public void initialize() {
		teams = new HappyTeams();
    }

    @Test
    public void test1ReadFile() 
    {
    	boolean worked = teams.readFile("Test.csv");
       	assertEquals(true,worked);
        System.out.println("\n");
    }

    // @Test
    // public void test2TotalNumPerson(){
    // 	// have to read the file again because it goes out of scope 
    // 	// or something in the previous test for total number of people
    // 	boolean worked = teams.readFile("Test.csv");
    // 	int numPerson = teams.getTotalNumPerson();
    //     System.out.println("Total Number of People: "+numPerson);
    // 	assertEquals(true, worked);
    // 	assertEquals(11,numPerson);
    //     System.out.println("\n");
    // }

    // @Test
    // public void test3ClearTotalNumPerson(){
    //     // have to read the file again because it goes out of scope 
    //     // or something in the previous test for total number of people
    //     boolean worked = teams.readFile("Test.csv");
    //     int numPerson = teams.getTotalNumPerson();
    //     assertEquals(true, worked);
    //     assertEquals(11,numPerson);
    //     System.out.println("Total Number of People: "+numPerson);
    //     teams.clearTotalNumPerson();
    //     numPerson = teams.getTotalNumPerson();
    //     System.out.println("Total Number of People: "+numPerson);
    //     assertEquals(0,numPerson);
    //     System.out.println("\n");
    // }

    // @Test
    // public void test4BeforeRandomizer(){
    //     boolean worked = teams.readFile("Test.csv");
    //     System.out.println("Bucket List "+teams.getList());
    //     assertEquals(true,worked);
    //     System.out.println("\n");
    // }

    // @Test
    // public void test5Randomizer(){
    //     boolean worked = teams.readFile("Test.csv");
    //     assertEquals(true,worked);
    //     worked = teams.randomizer(teams.getList());
    //     assertEquals(true,worked);
    //     System.out.println("\n");
    // }

    // @Test
    // public void testHappiness(){
    //     boolean worked = teams.readFile("Test.csv");
    //     assertEquals(true,worked);
    //     worked = teams.randomizer(teams.getList());
    //     assertEquals(true,worked);
    //     teams.happy_Checker();
    //     worked = teams.randomizer(teams.getList());
    //     assertEquals(true,worked);
    //     teams.happy_Checker();
    //     System.out.println("\n");
    // }

    // @Test
    // public void testHappinessWithUsingL(){
    //     boolean worked = teams.readFile("Test.csv");
    //     assertEquals(true,worked);
    //     int l = teams.getL();
    //     teams.happy_Checker();
    //     int happy = teams.getHappinessMain();
    //     int unHappy = teams.getZeroCountMain();
    //     int happyAfter = 0;
    //     int unHappyAfter = 0;
    //     for (int i = 0; i < l; i++) {
    //         worked = teams.randomizer(teams.getList());
    //         assertEquals(true,worked);
    //         teams.happy_Checker();
    //         happyAfter = teams.getHappinessMain();
    //         unHappyAfter = teams.getZeroCountMain();
    //         assert(happy <= happyAfter && unHappy >= unHappyAfter);
    //         if (happy <= happyAfter && unHappy >= unHappyAfter) {
    //             happy = happyAfter;
    //             unHappy = unHappyAfter;
    //         }
    //     }
    //     System.out.println("\n");
    // }

}









