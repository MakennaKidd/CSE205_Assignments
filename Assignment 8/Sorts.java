// Assignment #: 8
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: The Sorts class is a utility class that will be used to sort
//               a list of Club objects. The Sorts class object will never be instantiated.
//

import java.util.Arrays;
import java.util.Comparator;

public class Sorts
{
    public static void sort(Club[] clubList, int size, Comparator<Club> clubComparator)
    {
        Arrays.sort(clubList, clubComparator);
    }
}
