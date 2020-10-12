// Arizona State University - CSE205
// Assignment #: 5
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th  1:30pm
/*  Description: The debate camp class inherits the parent class information, Summer Camp, and implements them in here.
                 It instantiates its own variables along with inheriting the parent class information, then instantiates
                 the information to be taken from the input of the user/computer. Then printing it out correctly.The debate
                 camp will print the following information: camp title, location of the class, weekly rate it goes for,
                 number of weeks it is, the total cost for the camp, if there is a group discount if applicable, and the
                 material fee.
 */

//utils imported in order to implement the objects
import java.text.NumberFormat;
import java.util.Locale;

public class DebateCamp extends SummerCamp
{
    //Private variables because they cannot be changed nor seen.
    private double materialFee = 0.0;
    private boolean groupDiscount;

    //These two objects are used for instantiating the currency correctly and in US dollars.
    Locale usMoney = new Locale("en", "US");
    NumberFormat cost = NumberFormat.getCurrencyInstance(usMoney);

    //Debate constructor, inheriting Summer Camp variables and instantiating its own.
    public DebateCamp (String title, String location, double rate, int weeks, double fee, String discount)
    {
        super(title, location, rate, weeks);
        this.materialFee = fee;
        if(discount.equalsIgnoreCase("yes")) // If the groupDiscount is "yes", then a discount will be
            groupDiscount = true;                        // applied. If not, then no discount will be applied.
        else
            groupDiscount = false;
    }

    // Method to compute total costs for debate class with functions to do so.
    public void computeTotalCosts()
    {
        totalCost = (weeklyRate * numberOfWeeks);
                if(groupDiscount)
                    totalCost = (totalCost * 0.9); // If there is a group discount, then it it applied with this if statement.
                    totalCost += materialFee;
    }

    // To string method to print out debate camp info correctly.
    public String toString()
    {
        String debateCamp = "";
        debateCamp = "\nDebate Camp:" +
                super.toString() +
                "Material Fee:\t\t" + cost.format(materialFee) + "\n" +
                "Group Discount:\t\t";
                 if(groupDiscount)
                  debateCamp += "yes\n";
                 else
                     debateCamp += "no\n";
        return debateCamp;
    }
}

