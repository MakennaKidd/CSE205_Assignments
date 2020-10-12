// Arizona State University CSE 205
// Assignment #: Assignment 6
//         Name: Makenna Kidd
//    StudentID: 1218102912
//      Lecture: T + Th 1:30 pm
//  Description: PaneWithRectangles class creates a pane where we can use
//               mouse key to drag on grids and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaneWithRectangles extends BorderPane
{
    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> backColorCombo;
    private ComboBox<String> widthCombo;
    private Color primaryColor, secondaryColor, backgroundColor;
    private double selectWidth;
    private Rectangle[][] rectArray;
    private MouseHandler mouseHandle;
    private WidthHandler widthHandle;
    private PrimColorHandler primColorHandle;
    private BackColorHandler backColorHandle;
    private Label primColorSelection, backColorSelection, strokeWidthSelection;
    private int columns = 7, rows = 7 , horizontal = 470/7,  vertical = 390/7;

    public PaneWithRectangles()
    {
        primaryColor = Color.BLACK;
        secondaryColor = Color.GRAY;
        backgroundColor = Color.WHITE;
        selectWidth = 1.0;

        //Primary Color Selection label, combo box, and value set
        primColorSelection = new Label(" PrimaryColor ");
        String primaryColors[] = {"Black", "Blue", "Red", "Green"};
        primaryColorCombo = new ComboBox<String>();
        primaryColorCombo.setValue("Black");
        primaryColorCombo.setMinWidth(100);
        for (int i = 0; i < primaryColors.length; i++) {
            primaryColorCombo.getItems().add(primaryColors[i]);
        }

        //Background Color Selection label, combo box, and value set
        backColorSelection = new Label(" BackgroundColor ");
        String backgroundColors[] = {"White", "Yellow", "Orange"};
        backColorCombo = new ComboBox<String>();
        backColorCombo.setValue("White");
        backColorCombo.setMinWidth(100);
        for (int i = 0; i < backgroundColors.length; i++) {
            backColorCombo.getItems().add(backgroundColors[i]);
        }

        //Width Selection label, combo box, and value set
        strokeWidthSelection = new Label(" StrokeWidth ");
        String strokeWidthNumbers[] = {"1", "3", "5", "7"};
        widthCombo = new ComboBox<String>();
        widthCombo.setValue("1");
        widthCombo.setMinWidth(100);
        for (int i = 0; i < strokeWidthNumbers.length; i++) {
            widthCombo.getItems().add(strokeWidthNumbers[i]);
        }

        //grid is a GridPane containing 49 rectangles.
        GridPane grid = new GridPane();

        //Putting rectangle array into a grid of 49 rectangles all together.
        rectArray = new Rectangle[columns][rows];
        for(int i = 0; i < columns; ++i)
        {//Iterate through columns
            for(int j = 0; j < rows; ++j)
            {//Iterate through rows
                rectArray[i][j]= new Rectangle(i, j, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)
                rectArray[i][j].setStroke(Color.BLACK);
                rectArray[i][j].setStrokeWidth(selectWidth);
                rectArray[i][j].setFill(backgroundColor);
                grid.add(rectArray[i][j],i,j);
                grid.setHgap(1);
                grid.setVgap(1);
            }
        }

        //leftPane is a VBox, containing child labels and combo boxes
        VBox leftPane = new VBox();
        leftPane.getChildren().addAll(primColorSelection, primaryColorCombo, backColorSelection, backColorCombo, strokeWidthSelection, widthCombo);
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 0, 10, 0));

        //add the left pane to the left of the pane
        //and the grid pane contains rectangles at the center
        this.setLeft(leftPane);
        this.setCenter(grid);

        //register/link the source nodes with its handler objects
        mouseHandle = new MouseHandler();

        //  grid.setOnMousePressed(mouseHandle); commented out - personal use
        grid.setOnMouseDragged(mouseHandle);
        //  grid.setOnMouseReleased(mouseHandle); commented out - personal use

        //Combo box handles and action sets
        primColorHandle = new PrimColorHandler();
        primaryColorCombo.setOnAction(primColorHandle);
        backColorHandle = new BackColorHandler();
        backColorCombo.setOnAction(backColorHandle);
        widthHandle = new WidthHandler();
        widthCombo.setOnAction(widthHandle);

    }

    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
            //to check whether the mouse key is dragged
            //write your own codes here
            //---
            //System.out.println(event.getTarget());  commented out - personal use of debugging
            //System.out.println("RectArray: " + rectArray[0][0]);  commented out - personal use of debugging

            Rectangle targetRectangle = (Rectangle) event.getTarget();

            int rectangleX = (int) targetRectangle.getX();
            int rectangleY = (int) targetRectangle.getY();

            //Changing primary + secondary color in rectangle grid
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                rectArray[rectangleX][rectangleY].setFill(primaryColor);
                if (    rectArray[rectangleX - 1][rectangleY] != null &&
                        rectArray[rectangleX + 1][rectangleY] != null &&
                        rectArray[rectangleX][rectangleY - 1] != null &&
                        rectArray[rectangleX][rectangleY + 1] != null) {
                    rectArray[rectangleX - 1][rectangleY].setFill(secondaryColor);
                    rectArray[rectangleX + 1][rectangleY].setFill(secondaryColor);
                    rectArray[rectangleX][rectangleY - 1].setFill(secondaryColor);
                    rectArray[rectangleX][rectangleY + 1].setFill(secondaryColor);
                } else {
                    targetRectangle.setFill(backgroundColor);
                    rectArray[rectangleX - 1][rectangleY].setFill(backgroundColor);
                    rectArray[rectangleX + 1][rectangleY].setFill(backgroundColor);
                    rectArray[rectangleX][rectangleY - 1].setFill(backgroundColor);
                    rectArray[rectangleX][rectangleY + 1].setFill(backgroundColor);
                }
            }//end handle()
        }//end MouseHandler
    }

    //A handler class used to handle primary and secondary colors
    private class PrimColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            String selected = primaryColorCombo.getSelectionModel().getSelectedItem();
            switch(selected.toUpperCase())
            {
                case "BLACK" :
                    primaryColor = Color.BLACK;
                    secondaryColor = Color.GRAY;
                    break;
                case "BLUE" :
                    primaryColor = Color.BLUE;
                    secondaryColor = Color.POWDERBLUE;
                    break;
                case "RED" :
                    primaryColor = Color.RED;
                    secondaryColor = Color.PINK;
                    break;
                case "GREEN" :
                    primaryColor = Color. GREEN;
                    secondaryColor = Color.LIGHTGREEN;
                    break;
                default :
                    primaryColor = Color.BLACK;
                    secondaryColor = Color.GRAY;
            }
        }
    }//end PrimColorHandler

    //A handler class used to handle background color
    private class BackColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            String selected = backColorCombo.getSelectionModel().getSelectedItem();
            switch(selected.toUpperCase())
            {
                case "WHITE" :
                    backgroundColor = Color.WHITE;
                    break;
                case "YELLOW" :
                    backgroundColor = Color.YELLOW;
                    break;
                case "ORANGE" :
                    backgroundColor = Color.ORANGE;
                    break;
                default :
                    backgroundColor = Color.WHITE;
            }
            //background color changer loop
            for(int i = 0; i < rectArray.length; i++){
                for(int j = 0; j < rectArray[i].length; j++){
                    rectArray[i][j].setFill(backgroundColor);
                }
            }
        }
    }//end BackColorHandler

    //A handler class used to handle stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            selectWidth = Double.parseDouble(widthCombo.getValue());
        }
    }//end WidthHandler
} //end of PaneWithRectangles