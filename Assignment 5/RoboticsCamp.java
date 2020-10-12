// Arizona State University - CSE205
// Assignment #: 5
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th  1:30pm
/*  Description:The robotics camp class inherits the parent class information, Summer Camp, and implements them in here.
                 It instantiates its own variables along with inheriting the parent class information, then instantiates
                 the information to be taken from the input of the user/computer. Then printing it out correctly.The robotics
                 camp will print the following information: camp title, location of the class, weekly rate it goes for,
                 number of weeks it is, the total cost for the camp, and two fees of competition and facility fee.
 */

//utils imported in order to implement the objects
import java.text.NumberFormat;
import java.util.Locale;

public class RoboticsCamp extends SummerCamp
{
    //Private variables because they cannot be changed nor seen.
    private double facilityFee = 0.0;
    private double competitionFee = 0.0;

    //These two objects are used for instantiating the currency correctly and in US dollars.
    Locale usMoney = new Locale("en", "US");
    NumberFormat cost = NumberFormat.getCurrencyInstance(usMoney);

    //Robotics constructor, inheriting Summer Camp variables and instantiating its own.
    public RoboticsCamp(String title, String location, double rate, int weeks, double facilityFee, double compFee)
    {
        super(title, location, rate, weeks);
        this.facilityFee = facilityFee;
        this.competitionFee = compFee;
    }

    // Method to compute total costs for robotics class with functions to do so.
    public void computeTotalCosts()
    {
        totalCost = (weeklyRate * numberOfWeeks) + (facilityFee + competitionFee);
    }

    // To string method to print out robotics camp info correctly.
    public String toString()
    {
        String roboticsCamp = "";
        roboticsCamp = "\nRobotics Camp:" +
                super.toString() +
                "Facility Fee:\t\t" + cost.format(facilityFee) + "\n" +
                "Competition Fee:\t" + cost.format(competitionFee) + "\n";
        return roboticsCamp;
    }
}
