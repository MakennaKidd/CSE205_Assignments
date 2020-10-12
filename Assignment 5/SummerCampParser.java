// Arizona State University - CSE205
// Assignment #: 5
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th  1:30pm
/*  Description: The SummerCampParser class is a utility class that will be used to create an object of a child class
                 of SummerCamp class from a parsable string. The SummerCampParser class object will never be instantiated.
*/

public class SummerCampParser
{
    //Constructor for SummerCampParser in order to be accessed by SummerCamp
    public static SummerCamp parseStringToSummerCamp(String lineToParse)
    {
        SummerCamp camp = null;
        // The splitter for the Array List to separate the information given when the symbol ":" is identified.
        String campParsed[] = lineToParse.split(":");

        //If the DebateCamp is identified, then it will print the following information.
        if(campParsed[0].equalsIgnoreCase("DebateCamp"))
        {
             return new DebateCamp(campParsed[1], campParsed[2], Double.parseDouble(campParsed[3]), Integer.parseInt(campParsed[4]),
                                    Double.parseDouble(campParsed[5]), campParsed[6]);
        //If the RoboticsCamp is identified, then it will print the following information.
        }else if(campParsed[0].equalsIgnoreCase("RoboticsCamp"))
        {
            return new RoboticsCamp(campParsed[1], campParsed[2],Double.parseDouble(campParsed[3]), Integer.parseInt(campParsed[4]),
                                    Double.parseDouble(campParsed[5]), Double.parseDouble(campParsed[6]));
            //If the MathCamp is identified, then it will print the following information
        }else if(campParsed[0].equalsIgnoreCase("MathCamp"));
        {
            return new MathCamp(campParsed[1], campParsed[2], Double.parseDouble(campParsed[3]), Integer.parseInt(campParsed[4]),
                                campParsed[5]);
        }
    }
}