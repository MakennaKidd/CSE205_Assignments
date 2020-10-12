// Assignment #: 9
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: Assignment 9 reads in a sequence of integers from standard input until 0 is read, and store them in an
//               array (including 0). This is done using iteration (choose one of for, while, or do while loop).
//               Then compute the minimum number, count odd integers, compute the sum of numbers that are larger than
//               the first number in the array, and compute the largest even integer in the sequence using recursion.
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment9
{
    //Start of main class
    public static void main(String[] args) throws IOException
    {
        //Objects to read files being input
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(inStream);

        // Array of integers(with a maximum of 100 elements to be read), index, and element variables
        int elementsArray[] = new int[100];
        int i = 0;
        int element;

        //start of while loop
        while (true)
        {
            element = Integer.parseInt(buffReader.readLine());
            elementsArray[i++] = element;
            if (element == 0)
            {
                break;
            }
        } // end of while loop
        buffReader.close();

        //Printing out arguments for methods below main class

        System.out.println("The minimum number is " + findMin(elementsArray, 0, i--));
        System.out.println("The count of odd integers in the sequence is " + countOddNumbers(elementsArray, 0, i--));
        System.out.println("The largest even integer in the sequence is " + computeLargestEven(elementsArray, 0, i--));
        System.out.print("The sum of numbers larger than the first is " + sumOfNumbersLargerThanFirst(elementsArray, 0, i--, elementsArray[0]));
    } // end of main

    //Method to find the minimum integer of numbers being input
    public static int findMin(int[] elements, int startIndex, int endIndex)
    {
        // if start of index is greater than or equal to end of index and reaching the end,
        //return the element and the index - 1.
        if (startIndex >= endIndex)
        {
            return elements[startIndex - 1];
        }

        //Computing minimum integer and returning it
        int targetElement = elements[startIndex];
        int minValue = findMin(elements, startIndex + 1, endIndex);
        return targetElement < minValue ? targetElement : minValue;
    }

    //Method to compute count of odd numbers within the input
    public static int countOddNumbers(int[] elements, int startIndex, int endIndex)
    {
        // If start of index is equal to end of index and reaching the end
       if (startIndex == endIndex)
       {
           //If the element at the index is modulo by two, but not equal to zero, return the remainder
            if (elements[startIndex] % 2 != 0)
            {
                return 1;
            } else { // else return 0
                return 0;
            }
        } else { //else turning to a new if statement
           //If the element at the index is modulo by two, but not equal to zero, return the remainder
           //of the counting odd numbers argument + 1.
            if (elements[startIndex] % 2 != 0)
            {
                return countOddNumbers(elements, startIndex + 1, endIndex) + 1;
            } else { //  Else return it again without incrementing by 1.
                return countOddNumbers(elements, startIndex + 1, endIndex);
            }
        }
    }
    // Method to compute largest even integer
    public static int computeLargestEven(int[] elements, int startIndex, int endIndex)
    {
        // if start of index is equal to end of index and reaching the end, return the element at 0
        if (startIndex == endIndex)
        {
            return elements[0];
        }

        //Computing maximum integer and plugging it into the if statement
        int maxValue = computeLargestEven(elements, startIndex + 1, endIndex);

        // If element at the index is modulo by 2 equal to 0, return  the number.
        if (elements[startIndex] % 2 == 0)
        {
            return (elements[startIndex] >= maxValue) ? elements[startIndex] : maxValue;
        }
        return computeLargestEven(elements, startIndex + 1, endIndex);
    }

    //Method to compute sum of numbers larger than the first number being read
    public static int sumOfNumbersLargerThanFirst(int[] elements, int startIndex, int endIndex, int firstNumber)
    {


        // if end of index is equal to start of index and reaching the end
        if (endIndex == startIndex)
        {
            int sumOfElements = elements[startIndex];
            // if the element value at the index is greater than the first number, return the element number
            if (elements[startIndex] > firstNumber)
            {
                sumOfElements += elements[startIndex];
                return sumOfElements;
            } else {
                // else, return 0
                return 0;
            }
        }

        //If the element number at the index is greater than the first number
        //return the element with the sum of the numbers being computed.
        if (elements[startIndex] > firstNumber)
        {
            return elements[startIndex] += sumOfNumbersLargerThanFirst(elements, startIndex + 1, endIndex, firstNumber);
        } else {
            return sumOfNumbersLargerThanFirst(elements, startIndex + 1, endIndex, firstNumber);
        }
    }
}
