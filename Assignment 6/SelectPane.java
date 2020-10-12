// Arizona State University CSE 205
// Assignment #: Assignment 6
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th 1:30 pm
//  Description: SelectPane displays a list of available clubs
//               from which a user can select and compute their
//               total number of members.
//
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;


public class SelectPane extends BorderPane
{
    private ArrayList<Club> clubList;
    private ListView<Club> clubListView;
    private CheckBox checkbox;
    private int checkBoxSize;

    //constructor
    public SelectPane(ArrayList<Club> list)
    {
        //initialize instance variables
        this.clubList = list;



        //set up the layout





        //create an empty pane where you can add check boxes later
        //----
        checkBoxSize = 0;
        CheckBox checkBox = new CheckBox();


        //SelectPane is a BorderPane - add the components here
        //----



    } //end of constructor

    //This method uses the newly added parameter Club object
    //to create a CheckBox and add it to a pane created in the constructor
    //Such check box needs to be linked to its handler class
    public void updateClubList(Club newClub)
    {

    }

    //create a SelectionHandler class
    private class SelectionHandler implements EventHandler<ActionEvent>
    {
        //Override the abstract method handle()
        public void handle(ActionEvent event)
        {
            //When any radio button is selected or unselected
            //the total number of members of selected clubs should be updated
            //and displayed using a label.


        }
    } //end of SelectHandler class
} //end of SelectPane class
