// Assignment #: 4
// Name: Makenna Kidd
// StudentID: 1218102912
// Lecture: T + Th 1:30pm
// Description: Assignment 4 class displays a menu of choices to a user
//              and performs the chosen task. It will keep asking a user to
//              enter the next choice until the choice of 'Q' (Quit) is entered.

public class President {

    //private variables for the president class
    private String firstName;
    private String lastName;
    private String academicLevel;
    private String currentPresident;

    //Constructor that initialized firstName, lastName, academicLevel, and the currentPresident
    public President() {
        firstName = "?";
        lastName = "?";
        academicLevel = "?";
        currentPresident = "?";
    }
    //sets current president's information
    public void setCurrentPresident(String firstName, String lastName, String academicLevel) {
        this.currentPresident =  (lastName + "," + firstName + "(" + academicLevel + ")");;
    }
    //sets the first name user
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    //sets the last name of the user
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    //sets the users academic level
    public void setAcademicLevel(String academicLevel){
        this.academicLevel = academicLevel;
    }
    //gets the first name of the user
    public String getFirstName(){
        return firstName;
    }
    //gets the last name of the user
    public String getLastName(){
        return lastName;
    }
    //gets the academic level of the user
    public String getAcademicLevel(){
        return academicLevel;
    }
    //prints how the current president's information needs to be
    public String toString(){
        return ( lastName + "," + firstName + "(" + academicLevel + ")" );
    }
}
