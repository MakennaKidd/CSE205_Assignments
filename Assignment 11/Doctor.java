// Assignment #: 11
// Name: Makenna Kidd
// StudentID: 1218102912
// Lecture: T + TH @ 1:30pm
// Description: Doctor class represents the doctor and establishes if they have a patient or not. It sets the doctor ID,
//              the current patient, and availability of a doctor. Methods to be used in main and PatientManagement class.


public class Doctor
{
    private int doctorID;
    private Patient currentPatient;

    //Constructor to initialize member variables
    //Initially no patient is assigned
    public Doctor(int id)
    {
        this.doctorID = id;
        currentPatient = null;
    }

    //toString method returns a string containing
    //the information of a doctor
    public String toString()
    {
        String result = "Doctor id " + doctorID;

        if (currentPatient == null)
            result += " is not seeing any patient";
        else
            result += " is seeing a patient with id " + currentPatient.getPatientID();

        return result;
    }
        /**************************************
            More Methods need to be added here
        ***************************************/

    //hasPatient method containing doctor availability with a patient boolean
    public boolean hasPatient()
    {
        // If the doctor has an assigned patient, then it should return true.
        // Otherwise, it should return false.
        if (currentPatient != null)
        {
            return true;
        }
        return false;
    } //End of hasPatient method

    //assignPatient method containing doctor to patient assignment boolean
    public boolean assignPatient(Patient patient1)
    {
        //If the doctor does not have any assigned patient, assign the parameter
        // patient1 to its currentPatient and return true,otherwise return false;
        if(currentPatient == null)
        {
            currentPatient = patient1;
            return true;
        }
        return false;
    } // End of assignPatient method

    //releasePatient method to assign a patient to a doctor
     Patient releasePatient()
     {
         //If the doctor has an assigned patient, it should set its currentPatient
         // to null, but it also needs to return the Patient object that was assigned
         // as its currentPatient. Otherwise, it should return null.
         if(currentPatient != null)
         {
             Patient releasePatient = currentPatient;
             currentPatient = null;
             return releasePatient;
         }
         return null;
     } // End of releasePatient method
} // End of Doctor class
