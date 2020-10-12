// Assignment #: 11
// Name: Makenna Kidd
// StudentID: 1218102912
// Lecture: T + TH @ 1:30pm
// Description: This program manages patient queues, assigns patients to doctors,
//              releases them to check out, etc.

import java.util.LinkedList;

public class PatientManagement
{
    private LinkedList<Patient> highPriorityQueue; //Requires immediate life-saving intervention
    private LinkedList<Patient> intermediateQueue; //Requires significant intervention within two to four hours.
    private LinkedList<Patient> delayedCareQueue; //Needs medical treatment, but this can safely be delayed.

    private LinkedList<Patient> checkOutQueue; //queue for patients that need to check out

    private Doctor[] doctorList; //an array of doctors

    //Constructor to initialize member variables
    public PatientManagement(int numOfDoctors)
    {
        highPriorityQueue = new LinkedList<Patient>();
        intermediateQueue = new LinkedList<Patient>();
        delayedCareQueue = new LinkedList<Patient>();
        checkOutQueue = new LinkedList<Patient>();

        //creating doctor objects
        doctorList = new Doctor[numOfDoctors];
        for (int i=0; i<doctorList.length; i++)
        {
            doctorList[i] = new Doctor(i);
        }
    }

    //The printQueue prints out the content
    //of the queues and the array of doctors
    public void printPatientQueues()
    {
        System.out.print("\nHigh Priority Queue:\n" + highPriorityQueue.toString() + "\n");
        System.out.print("\nIntermediate Queue:\n" + intermediateQueue.toString() + "\n");
        System.out.print("\nDelayed Care Queue:\n" + delayedCareQueue.toString() + "\n\n");
        for (int i = 0; i < doctorList.length; i++)
        {
            System.out.println(doctorList[i].toString());
        }
        System.out.print("\nCheck Out Queue:\n" + checkOutQueue.toString() + "\n\n");
    }

    /*****************************************
        More Methods need to be added here
     ****************************************/

    //addPatient boolean method to add patient ID to priority level to be put into queue
    public boolean addPatient(int patientID, String conditionLevel)
    {
        //This method attempts to add a patient of the parameter patientID and
        //conditionLevel to its corresponding queue. If the parameter conditionLevel
        //is “High Priority”, then instantiate a Patient object using its id and
        //conditionLevel, and add it to the highPriorityQueue. If the parameter
        //conditionLevel is “Intermediate”, then instantiate a Patient object using
        //its id and conditionLevel, and add it to the intermediateQueue. If the
        //parameter conditionLevel is “ Delayed Care”, then instantiate a Patient
        // object using its id and conditionLevel, and add it to the delayedCareQueue.
        //For those three cases, it should return true. If the conditionLevel is none
        // of these three, it should not add a Patient object to any queue, and it should
        //return false.

        //Start of conditionals for priority levels
        switch (conditionLevel)
        {
            case "High Priority": //High priority case statement
            {
                //Setting patient object for this conditional, adding patient to High Priority queue
                Patient patient = new Patient(patientID, conditionLevel);
                highPriorityQueue.add(patient); //Add to high priority queue
                return true;
            }
            case "Intermediate": //Intermediate priority case statement
            {
                //Setting patient object for this conditional, adding patient to intermediate queue
                Patient patient = new Patient(patientID, conditionLevel);
                intermediateQueue.add(patient); //Add to intermediate queue
                return true;
            }
            case "Delayed Care": //Delayed care priority case statement
            {
                //Setting patient object for this conditional, adding patient to Delayed Care queue
                Patient patient = new Patient(patientID, conditionLevel);
                delayedCareQueue.add(patient); //Add to delayed queue
                return true;
            }
        }
        //If none of these cases are true, then conditional returns false,  not adding a patient to the queue
        return false;
    } //End of addPatient method

    //assignPatientToDoctor method to assign High Priority to doctor, then runs through a loop
    // to check if other condition level patients are present.
    public Patient assignPatientToDoctor()
    {
        //This method needs to check if there is any patient in the highPriorityQueue,
        // and if there is, it tries to assign the patient to a doctor. If there is no
        // such patient, then it should check if there is any patient in the
        // intermediateQueue, if not, it should check if there is any patient in the
        // delayedCareQueue. Thus you need to find a next patient using their condition
        // level, and within a same condition level, whoever was added to the queue
        // first. Then you need to check each doctor to see who does not have any patient
        // at that time, in the order of their doctorIDs, 0, 1, … through the last index
        // of the doctor array. Once you find such an available doctor, then assign the
        // patient that you have obtained from one of the three queues to the doctor,
        // and return the Patient object. If there is no doctor available or no patient
        // in any of the three waiting queues, then it should return null.

        //If statement for highPriorityQueue patient parameter.
        if (highPriorityQueue.size() != 0)
        {
            //Setting patient object for this conditional
            Patient highAssignedPatient = highPriorityQueue.getFirst();
            // For loop to retrieve number of doctors, then assign a patient to a specific doctor
            for (int i = 0; i < doctorList.length; i++)
            {
                //Retrieving doctor ID within Array, and checking if they have a patient
                if (!doctorList[i].hasPatient())
                {
                    //If not true, then assigning a patient to the doctor takes place
                    doctorList[i].assignPatient(highAssignedPatient);
                    highPriorityQueue.removeFirst();
                    return highAssignedPatient; // Returning true, meaning returning the patient
                }
            }
         //If statement for intermediateQueue patient parameter.
        } else if (intermediateQueue.size() != 0)
        {
            //Setting patient object for this conditional
            Patient intermediateAssignedPatient = intermediateQueue.getFirst();
            // For loop to retrieve number of doctors, then assign a patient to a specific doctor
            for (int i = 0; i < doctorList.length; i++)
            {
                //Retrieving doctor ID within Array, and checking if they have a patient
                if (!doctorList[i].hasPatient())
                {
                    //If not true, then assigning a patient to the doctor takes place
                    doctorList[i].assignPatient(intermediateAssignedPatient);
                    intermediateQueue.removeFirst();
                    return intermediateAssignedPatient; // Returning true, meaning returning the patient
                }
            }
        //If statement for delayedCareQueue patient parameter.
        } else if (delayedCareQueue.size() != 0)
        {
            //Setting patient object for this conditional
            Patient delayedAssignedPatient = delayedCareQueue.getFirst();
            // For loop to retrieve number of doctors, then assign a patient to a specific doctor
            for (int i = 0; i < doctorList.length; i++)
            {
                //Retrieving doctor ID within Array, and checking if they have a patient
                if (!doctorList[i].hasPatient())
                {
                    //If not true, then assigning a patient to the doctor takes place
                    doctorList[i].assignPatient(delayedAssignedPatient);
                    delayedCareQueue.removeFirst();
                    return delayedAssignedPatient; // Returning true, meaning returning the patient
                }
            }
        }
        //If there is no doctor available or no patient in any of the
        // three waiting queues, then it should return null.
        return null;
    } //End of assignPatientToDoctor method

    //Method to check if the specific doctor has any patients, then release that patient appropriately to the checkout queue.
    public Patient releasePatientFromDoctorToCheckOutQueue(int doctorID)
    {
        //This method should check if the doctor of the given parameter doctorID has any
        // patient and if it has, release that patient (use a method of the Doctor class),
        // and add that patient into the checkOutQueue, and return true. If the doctor of the
        // given parameter doctorID does not have any patient or the parameter doctorID is
        // not valid (not within the range of the doctor array), it should return null.

        //If statement for the doctor w/ a specific ID has a certain patient
        if (doctorList[doctorID].hasPatient())
        {
            //Setting patient object for this conditional, adding patient to check out queue and returning that patient
            Patient releasedPatient = doctorList[doctorID].releasePatient();
            checkOutQueue.add(releasedPatient);
            return releasedPatient; // Returning true, meaning returning the patient
        }
        //If the doctor has no patient, or the doctorID is invalid, conditional returns null
        return null;
    } //End of releasePatientFromDoctorToCheckOutQueue method

    //Method to check if the check out queue is empty or not, then removing the patient when appropriate.
    public Patient checkOutPatient()
    {
        //If the checkOutQueue is not empty, this method should remove the next patient
        // from the queue and return it. Otherwise, it should return null.
        if (!checkOutQueue.isEmpty())
        {
            //Setting patient object for this conditional, getting/removing first patient, returning the assigned patient
            Patient checkedOutPatient = checkOutQueue.getFirst();
            checkOutQueue.removeFirst();
            return checkedOutPatient; // Returning true, meaning returning the patient
        }
        //If checkout queue is empty, the conditional returns null
        return null;
    } //End of checkOutPatient method
} //End of PatientManagement class.