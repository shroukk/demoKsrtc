package runner;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        // Create a TestNG instance
        TestNG testNG = new TestNG();

        // Create a list to store the test suites
        List<String> suites = new ArrayList<String>();

        // Add the testng.xml file to the list of suites (you can add multiple if needed)
        suites.add("testng.xml"); // Replace with the path to your testng.xml file

        // Set the suites to be executed
        testNG.setTestSuites(suites);

        // You can add listeners or other configuration options here if needed
        TestListenerAdapter tla = new TestListenerAdapter();
        testNG.addListener(tla);

        // Run the tests
        testNG.run();
    }
}

