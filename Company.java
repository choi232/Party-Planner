/** 
 * Company.java File for creating Company objects in Party Planner
 * @author Mikael Choi 
 * @since 2/20/2025
 * Preconditions: txt file to import Company objects
 * Postconditions: generates a Company object with companyName, companyID, and employee(ArrayList)
 * Purpose: Create a blueprint of attributes and methods for the 
 * Company object to better store data about each Company at the conference
 **/

import java.util.ArrayList; //Import ArrayList

/*
Company Class: Creates separate structure for companies with purpose of 
organizing storage of data to make it easier for placing attendees by directly
using the employee ArrayList from each Company Object
*/
public class Company{

    //Creation of Attribute Variables
    private int companyID;
    private String companyName;
    private ArrayList<Attendee> employee = new ArrayList<Attendee>(); 
    //ArrayList with purpose of storing up to first ten employees within company
    private int companySize = 0;

    //Constructor to set custom Company object arguments to private attributes
    public Company(int setCompanyID, String setCompanyName){
        companyID = setCompanyID;
        companyName = setCompanyName;
    }


    //Getter & Setter Methods

    /*
    Getter Method to return integer companyID 
    Must be accessed through company object
    */
    public int getCompanyID(){
        return companyID;
    }

    /*
    Getter Method to return String companyName 
    Must be accessed through company object
    */
    public String getCompanyName(){
        return companyName;
    }

    /*
    Getter Method to return integer companySize which is the size of the employee ArrayList 
    Must be accessed through company object
    */
    public int getCompanySize(){
        return companySize;
    }

    /*
    Getter Method to return Attendee object within employee ArrayList
    Must be accessed through company object and requires index of employee ArrayList
    */
    public Attendee getEmployee(int index){
        return employee.get(index);
    }

    /*
    Setter Method to set Attendee object within employee ArrayList 
    Must be accessed through company object as well as with the numTables to limit max attendees in employee ArrayList
    No Return Type
    */
    public void setEmployee(Attendee attendee, int numTables){
        //The if statement here fufills the condition of checking for the max amount of people  
        if(employee.size() < numTables){
            employee.add(attendee);
            companySize = employee.size();
        }
    }

} //end of class bracket
