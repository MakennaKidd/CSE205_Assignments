// Assignment #: 8
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: Tues + Thurs 1:30pm
//  Description: The ClubManagement class has a list of Club objects that can be organized
//               at the club management system. The club management system will be a fully encapsulated object.
//

public class ClubManagement
{
    private Club[] clubList;
    private int numberOfClubs;
    private int maxSize;

    //Constructor for ClubManagement Class.
    public ClubManagement(int maximumSize)
    {
        this.maxSize = maximumSize;
        this.clubList = new Club[maxSize];

        //Instantiating array and initializing each slot of the array for every index.
        //Initializing numberOfClubs to 0.
        for(int i = 0; i < this.maxSize; i++)
        {
            clubList[i] = null;
        }
        numberOfClubs = 0;
    }

    public int clubExists(String clubName, String university)
    {
        for(int i = 0; i < this.maxSize; i++)
        {
            Club club = this.clubList[i];

            //If the club exists and is the same, then the index of the club object will be returned.
            //If the club does not exist, then -1 is returned.
            if(club.getClubName().equalsIgnoreCase(clubName) &&
                    club.getUniversity().equals(university))
            {
                return i;
            }
        }
        return -1;
    }

    public int currentPresidentExists(String firstName, String lastName, String academicLevel)
    {
        for(int i = 0; i < this.maxSize; i++)
        {
            Club club = this.clubList[i];

            //If the club presidents information matches, the index of the object is returned.
            //If it does not match, then -1 is returned.
            if(null != club)
            {
                if(lastName.equalsIgnoreCase(club.getCurrentPresident().getLastName()))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean addClub(String clubName, int numOfMembers, String university, String firstName, String lastName, String academicLevel)
    {
        Club club = new Club();

        //Setting variables with the Club object.
        club.setClubName(clubName);
        club.setNumberOfMembers(numOfMembers);
        club.setUniversity(university);
        club.setCurrentPresident(firstName,lastName,academicLevel);

        //If the club information exists and is found, boolean returns true.
        //If club information doesn't exist and isn't found, boolean returns false.
        if(currentPresidentExists(firstName,lastName,academicLevel)<0)
        {
            if(numOfMembers < this.maxSize)
            {
                clubList[this.numberOfClubs] = club;
                this.numberOfClubs++;
                return true;
            }
        }
        return false;
    }

    public boolean removeClub(String clubName, String university)
    {
        for(int i = 0; i <this.maxSize; i++)
        {
            Club club = this.clubList[i];

            //If the club information is found, the club will be removed if found true.
            //If found false, the club will not be removed.
            if(club.getClubName().equalsIgnoreCase(clubName) && club.getUniversity().equals(university))
            {
                clubList[i] = null;
                this.numberOfClubs--;
                for(int k = i + 1; k< this.maxSize; k++)
                {
                    this.clubList[k-1] = this.clubList[k];
                }
                return true;
            }
        }
        return false;
    }

    //Sorts the list of Club objects by club names.
    public void sortByClubNames()
    {
        Sorts.sort(clubList, maxSize, new ClubNameComparator());
    }

    //Sorts the list of Club objects by number of members.
    public void sortByMemberNumbers()
    {
        Sorts.sort(clubList, maxSize, new MemberNumberComparator());
    }

    //Sorts the list of Club objects by president information.
    public void sortByCurrentPresidents()
    {
        Sorts.sort(clubList, maxSize, new CurrentPresidentComparator());
    }

    //Lists all Club objects in the club list.
    public String listClubs()
    {
        String stringResult = "";

        if(numberOfClubs >0)
        {
            for(int i=0; i<this.numberOfClubs ;i++)
            {
                Club numOfClubs = this.clubList[i];
                stringResult += numOfClubs.toString();
            }
            return stringResult;
        } else {
            return "\nno club\n\n";
        }
    }

    public void closeClubManagement()
    {
        for(int i = 0; i < this.maxSize; i++)
        {
            clubList[i] = null;
        }
        numberOfClubs = 0;
    }
}
