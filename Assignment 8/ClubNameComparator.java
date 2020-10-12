// Assignment #: 8
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: ClubNameComparator implements the "Comparator" interface
//               and compares two clubs and returns either less than zero,
//               zero, or greater than zero during the comparison.

import java.util.Comparator;

public class ClubNameComparator implements Comparator<Club>
{
    public int compare(Club first, Club second)
    {
        int cName = -1;

        //Comparing the two clubs
        cName = first.getClubName().compareTo(second.getClubName());

        /*
        If club names are the same, then comparison takes place.
        If club names are the same, then 0 is returned.
        */

        if (cName == 0)
        {
            String clubFirst = String.valueOf(first.getClubName());
            String clubSecond = String.valueOf(second.getClubName());
            cName = clubFirst.compareTo(clubSecond);

            return cName;

        } else if (cName < 0) {

            return cName;

        } else if( cName > 0) {

            return 1;

        } else if (cName == 0) {

            return 0;

        }
        return cName;
    }
}

