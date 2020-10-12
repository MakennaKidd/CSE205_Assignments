// Arizona State University CSE 205
// Assignment #: Assignment 6
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th 1:30 pm
//  Description: CreatePane generates a pane where a user can enter
//               club information and create a list of available clubs.

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import

//import all other necessary javafx classes here//----
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CreatePane extends HBox
{
    ArrayList<Club> clubList;

    private SelectPane selectPane;
    private TextField clubName;
    private TextField numberOfMembers;
    private TextField university;
    private Label popUpMessage;
    private TextArea area;
    private Button createClubButton;

    //The relationship between CreatePane and SelectPane is Aggregation

    //constructor
    public CreatePane(ArrayList<Club> list, SelectPane sePane)
    {
        this.clubList = list;
        this.selectPane = sePane;

        //Setting Up Layout
        HBox hbox = new HBox();
        hbox.setSpacing(10);

        popUpMessage = new Label(" ");
        popUpMessage.setTextFill(Color.RED);

        //Labels and Text Fields for clubName, numberOfMembers,and university.
        Label clubTitle = new Label("Club Name: ");
        clubName = new TextField();

        Label clubMembers = new Label("Number of Members:");
        numberOfMembers = new TextField();

        Label clubUniversity = new Label("University:");
        university = new TextField();

        createClubButton = new Button("Create a Club");
        createClubButton.setOnAction(new ButtonHandler());

        //GridPane setting in order to store the information in the correct format
        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(15);

        //Setting where the variables will be at in which row and column.
        gridPane.add(popUpMessage, 1,0);
        gridPane.add(clubTitle, 1,1);
        gridPane.add(clubName,2,1);
        gridPane.add(clubMembers, 1,2);
        gridPane.add(numberOfMembers,2,2);
        gridPane.add(clubUniversity, 1,3);
        gridPane.add(university,2,3);
        gridPane.add(createClubButton,2,4);

        //Right of gridPane to store the information above
        area = new TextArea();
        area.setEditable(false);

        //Positioning button
        GridPane.setHalignment(createClubButton, HPos.CENTER);

        setSpacing(10);
        this.getChildren().add(gridPane);
        this.getChildren().add(area);

        ButtonHandler createClubButtonHandler = new ButtonHandler();
        createClubButton.setOnAction(createClubButtonHandler);
    } //end of constructor

    //saving information in text area
    public void refresh()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(Club club : clubList )
        {
            stringBuilder.append("\nClub Name:\t");
            stringBuilder.append(club.getClubName());
            stringBuilder.append("\nClub Members:\t");
            stringBuilder.append(club.getNumberOfMembers());
            stringBuilder.append("\nUniversity:\t");
            stringBuilder.append(club.getUniversity());
        }
        area.setText(stringBuilder.toString());
    }
;
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        //Override the abstract method handle()
        public void handle(ActionEvent event)
        {
            //If these variables = 0, then an error message will come up
            if(clubName.getText().length() == 0 || numberOfMembers.getText().length() == 0
                        || university.getText().length() == 0)
            {
                popUpMessage.setText("Please fill all fields");
            } else {
                try
                {
                    //parsing information to be correct input, then stored in text area
                    // and "Club Added" comes up
                    String title = clubName.getText();
                    int members = Integer.parseInt(numberOfMembers.getText());
                    String universityField = university.getText();
                    Club club = new Club();

                    club.setClubName(title);
                    club.setNumberOfMembers(members);
                    club.setUniversity(universityField);
                    clubList.add(club);
                    selectPane.updateClubList(club);
                    refresh();
                    clubName.setText("");
                    numberOfMembers.setText("");
                    university.setText("");
                    popUpMessage.setText("Club Added");
                    //If number input isn't an integer, error message will come up.
                } catch (NumberFormatException e)
                {
                    popUpMessage.setText("Please enter an integer for a number of members.");
                }
                }
        } //end of handle() method
    } //end of ButtonHandler class

}