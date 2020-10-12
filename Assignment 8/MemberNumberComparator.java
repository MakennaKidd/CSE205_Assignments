// Assignment #: 8
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: This MemberNumberComparator class compares the amount of members within
//               the clubs. Then based off the information during comparison, returns an int
//               correlating with the comparison.

import java.util.Comparator;

public class MemberNumberComparator implements Comparator<Club>
{
    public int compare(Club first, Club second)
    {
        int numCMembers = -1;

        //Comparing the two club member amounts
       numCMembers = first.getClubName().compareTo(second.getClubName());

        /*
        If number of members are less than, an int less than 0 is returned.
        If number of members are greater than, an int greater than 0 is returned
        If number of members are the same, 0 is returned.
        */
        if (numCMembers < 0)
        {

            return numCMembers;

        } else if(numCMembers > 0) {

            return 1;

        } else if ( numCMembers == 0) {

            return 0;

        }
        return numCMembers;
    }
}
