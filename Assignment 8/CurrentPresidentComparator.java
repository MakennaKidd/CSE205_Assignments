// Assignment #: 8
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: The CurrentPresidentComparator class compares first name, and last name
//               of the club's president. Then returns certain information based on what's
//                compared.

import java.util.Comparator;

public class CurrentPresidentComparator implements Comparator<Club>
{
    public int compare(Club first, Club second)
    {
        int curCPresident = -1;
        int fName = -1;
        int lName = -1;

        //Comparing the two clubs
        curCPresident = first.getCurrentPresident().getLastName().compareTo(second.getCurrentPresident().getLastName());

        /*
        If lastName is less than, return int less than 0.
        If lastName is greater than, int greater than 0 is returned.
        If last names are the same, comparison of first names take place.
        If first is smaller, than a negative in is returned.
        If first name is larger, positive int is returned.
        If last name and first name is the same, then 0 is returned.
        */
        if(lName < 0)
        {

            return lName;

        }else if (lName > 0)
        {

            return lName;

        } else if( lName == 0)
        {
            //Comparing the first names of the president
            curCPresident = first.getCurrentPresident().getFirstName().compareTo(second.getCurrentPresident().getFirstName());
            String clubFirst = String.valueOf(first.getCurrentPresident());
            String clubSecond = String.valueOf(second.getCurrentPresident());

        } else if( fName < 0)
        {

            return lName;

        } else if ( fName > 0)
        {

            return fName;

        } else if( lName == fName)
        {

            return fName;

        }
        return lName;
    }
}
