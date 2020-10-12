// Arizona State University - CSE205
// Assignment #: 5
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th  1:30pm
/*  Description:The math camp class inherits the parent class information, Summer Camp, and implements them in here.
                 It instantiates its own variables along with inheriting the parent class information, then instantiates
                 the information to be taken from the input of the user/computer. Then printing it out correctly. The math
                 camp will print the following information: camp title, location of the class, weekly rate it goes for,
                 number of weeks it is, the total cost for the camp, and if there is test taking or not.
 */

//utils imported in order to implement the objects
import java.text.NumberFormat;
import java.util.Locale;

public class MathCamp extends SummerCamp
{
    //Private variable because they cannot be changed nor seen.
    private boolean testTaking;

    //These two objects are used for instantiating the currency correctly and in US dollars.
    Locale usMoney = new Locale("en", "US");
    NumberFormat cost = NumberFormat.getCurrencyInstance(usMoney);

    //Debate constructor, inheriting Summer Camp variables and instantiating its own.
    public MathCamp(String title, String location, double rate, int weeks, String tTaking)
    {
        super(title, location, rate, weeks);
        if(tTaking.equalsIgnoreCase("yes"))
            testTaking = true;
        else
            testTaking = false;
    }

    // Method to compute total costs for debate class with functions to do so.
    public void computeTotalCosts( )
    {
        totalCost = (weeklyRate * numberOfWeeks);
        if (testTaking == true)
            totalCost += (25);
    }

    // To string method to print out debate camp info correctly.
    public String toString()
    {
        String mathCamp = "";
        mathCamp= "\nMath Camp:" +
               super.toString();
                if(testTaking)
                    mathCamp +="Test Taking:\t\tyes\n";
                else
                    mathCamp += "Test Taking:\t\tno\n";
                return mathCamp ;
    }
}
