/** 
 * Attendee.java File for creating attendee objects in Party Planner
 * @author Mikael Choi 
 * @since 2/3/2025
 * Preconditions: txt file to import attendee objects
 * Postconditions: generates an attendee object with name, tableID, tablePos and companyID
 * Purpose: Create a blueprint of attributes and methods for the 
 * attendee object to better store data about each attendee at the conference
 **/

/*
Attendee Class: Creates attendee objects with purpose of 
organizing storage of data to make it easier for storing data
within a 2D ArrayList attendeeList, a representation of the many
tables and seats which each Attendee would be seated at in the
actual conference
*/

public class Attendee{

    //Creation of Attribute Variables
    private String name;
    private int companyID;
    private String companyName;
    private int tablePos; //col in attendeeList 2D ArrayList
    private int tableID; //row in attendeeList 2D ArrayList
    private int attendeeID;

    //Constructor to set custom Attendee object arguments to private attributes
    public Attendee(String attName, String compName, int attID, int compID){
        name = attName;
        companyName = compName;
        attendeeID = attID;
        companyID = compID;
        tableID = -1; //to be reassigned when Attendee object is placed
        tablePos = -1; //to be reassigned when Attendee object is placed
    }

    //Getters & Setter Methods

    /*
    Getter Method to return String name 
    Must be accessed through Attendee object
    */
    public String getName(){
        return name;
    }

    /*
    Setter Method to set String name 
    Must be accessed through Attendee object
    */
    public void setName(String setName){
        name = setName;
    }

    /*
    Getter Method to return integer attendeeID 
    Must be accessed through Attendee object
    */
    public int getID(){
        return attendeeID;
    }

    /*
    Setter Method to set String attendeeID 
    Must be accessed through Attendee object
    */
    public void setID(int setAttID){
        attendeeID = setAttID;
    }

    /*
    Getter Method to return integer tableID 
    Must be accessed through Attendee object
    */
    public int getTableID(){
        return tableID;
    }

    /*
    Setter Method to set integer tableID 
    Must be accessed through Attendee object
    */
    public void setTableID(int setTableID){
        tableID = setTableID;
    }

    /*
    Getter Method to return integer tablePos 
    Must be accessed through Attendee object
    */    
    public int getTablePos(){
        return tablePos;
    }

    /*
    Setter Method to set integer tablePos 
    Must be accessed through Attendee object
    */
    public void setTablePos(int setTablePos){
        tablePos = setTablePos;
    }

    /*
    Getter Method to return integer companyID 
    Must be accessed through Attendee object
    */
    public int getCompanyID(){
        return companyID;
    }

    /*
    Setter Method to set integer companyID 
    Must be accessed through Attendee object
    */
    public void setCompanyID(int setCompanyID){
        companyID = setCompanyID;
    }

    /*
    Getter Method to return String companyName 
    Must be accessed through Attendee object
    */    
    public String getCompanyName(){
        return companyName;
    }

    /*
    Setter Method to set String companyName 
    Must be accessed through Attendee object
    */    
    public void setCompanyName(String setCompanyName){
        companyName = setCompanyName;
    }

    /*
    Overriden toString Method to return a String representation of all of the Attendee object's attributes 
    Must be accessed through Attendee object
    */   
    public String toString(){
        return ("Name: " + name + "\n") + ("Company Name: " + companyName + "\n") + ("Company ID: " + companyID + "\n") + ("Table ID: " + tableID + "\n") + ("Table Position: " + tablePos + "\n");
    }
}
