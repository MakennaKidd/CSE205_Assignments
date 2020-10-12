// Assignment #: 2
// Arizona State University - CSE205
// Name: Makenna Kidd
// StudentID: 1218102912
// Lecture: Tues + Thurs 1:30 - 2:45
/* Description: This class reads in an unspecified number of integers from standard input,
                performs some calculations on the inputted numbers, and outputs the results
                of those calculations to standard output.
 */

import java.util.Scanner;
public class Assignment2
{
    public static void main (String[] args)
    {
        //Declaring Variables
        int minimumInt = 0;
        int countOfOddInts = 0;
        int maximumEvenInt = 0;
        int sumOfPositiveInts = 0;

        // Scanning numbers in files provided
        Scanner scan = new Scanner(System.in);
        int nextInt = scan.nextInt();

        // While loop to read input provided by files
        while(nextInt != 0)
        {
            if(nextInt % 2 != 0) // if the int provided is divided by 2 and not equal to 0, then it's odd.
            {
                countOfOddInts++;
            }
            if(nextInt < minimumInt) // if the int is less than the min int, then that's the new min int.
            {
                minimumInt = nextInt;
            }
            if(nextInt > maximumEvenInt && nextInt % 2 == 0) // if the int is greater than the max int, divided by
            {                                               // 2, and equal to 0, the int is the new max int.
                maximumEvenInt = nextInt;
            }
            if(nextInt > 0) // if int is greater than 0, it outputs the sum of positive ints provided by file.
            {
               sumOfPositiveInts += nextInt;
            }
            nextInt = scan.nextInt(); // closing of scanner
        }

        // Prints a message with all of the integers in the correct place.
        System.out.print("The minimum integer is " + minimumInt + "\n"
                + "The count of odd integers in the sequence is " + countOfOddInts + "\n"
                + "The largest even integer in the sequence is " + maximumEvenInt + "\n"
                + "The sum of positive integers is " + sumOfPositiveInts + "\n");
    }
}
