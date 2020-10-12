// Assignment #: 4
// Name: Makenna Kidd
// StudentID: 1218102912
// Lecture: T + Th 1:30pm
// Description: Assignment 4 class displays a menu of choices to a user
//              and performs the chosen task. It will keep asking a user to
//              enter the next choice until the choice of 'Q' (Quit) is entered.

public class Club<CurrentPresident> {

    //private variables for the club class
    private String clubName;
    private int numOfMembers;
    private String university;
    private String currentPresident;
    private President president = new President();

    //Constructor that initialized clubName, numOfMembers, and university, and president
    public Club() {
        clubName = "?";
        numOfMembers = 0;
        university = "?";
        President president = new President();
    }
    // sets the clubName for the club
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    // sets the number of members in the club
    public void setNumberOfMembers(int numOfMembers) {
        this.numOfMembers = numOfMembers;
    }
    // sets the university name
    public void setUniversity(String university) {
        this.university = university;
    }
    //sets the current president information
    public void setCurrentPresident(String firstName, String lastName, String academicLevel) {
        president.setFirstName(firstName);
        president.setLastName(lastName);
        president.setAcademicLevel(academicLevel);
    }
    //gets the club name
    public String getClubName() {
        return clubName;
    }
    //gets the number of members
    public int getNumberOfMembers() {
        return numOfMembers;
    }
    //gets the university
    public String getUniversity() {
        return university;
    }
    //returns president information from president class
    public CurrentPresident getCurrentPresident() {
        return (CurrentPresident) president;
    }
    //prints the information that is necessary to be organized for club information*
    public String toString(){
        return ("\nClub Name:\t\t" + clubName + "\n"+
                  "Number Of Members:\t" + numOfMembers + "\n"+
                  "University:\t\t" + university + "\n"+
                  "President:\t\t" + president + "\n\n");
    }
}
