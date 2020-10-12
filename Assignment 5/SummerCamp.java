// Arizona State University - CSE205
// Assignment #: 5
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th  1:30pm
/*  Description: This class is the parent class of the other summer camp classes. This class holds all of
                 the important information for the other classes to call from and inherit. The summer camp class
                 will hold the camp title, location, weekly rate, total cost, and number of weeks for the other
                 classes to grab and implement from.
 */

//utils imported in order to implement the objects
import java.text.NumberFormat;
import java.util.Locale;

public abstract class SummerCamp
{
    //Protected variables because it's the parent class.
    protected String title;
    protected String location;
    protected double weeklyRate = 0;
    protected double totalCost = 0;
    protected int numberOfWeeks = 0;

    //These two objects are used for instantiating the currency correctly and in US dollars.
    Locale usMoney = new Locale("en", "US");
    NumberFormat cost = NumberFormat.getCurrencyInstance(usMoney);

    // Constructor for Summer Camp to list all of the camp info
    public SummerCamp(String someTitle, String someLocation, double someWeeklyRate, int someNumberOfWeeks)
    {
        title = someTitle;
        location = someLocation;
        weeklyRate = someWeeklyRate;
        numberOfWeeks = someNumberOfWeeks;
        totalCost = 0;
    }

    public String getCampTitle() // Method to grab camp title
    {
        return title;
    }

    public abstract void computeTotalCosts(); // Method to compute the total costs of fees for classes

    public String toString() //to string method to print the camp information correctly
    {
        return ("\nCamp Title:\t\t" + title + "\n" +
                "Location:\t\t" + location + "\n" +
                "Weekly Rate:\t\t" + cost.format(weeklyRate) + "\n" +
                "Weeks:\t\t\t" + numberOfWeeks + "\n" +
                "Total Cost:\t\t" + cost.format(totalCost) + "\n");
    }
}