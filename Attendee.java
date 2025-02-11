/** 
 * Attendee.java Class for creating attendee objects in Party Planner
 * @author Mikael Choi 
 * @since 2/3/2025
 * Preconditions: txt file to import attendee objects
 * Postconditions: generates an attendee object with name, tableID, tablePos and companyID
 **/

public class Attendee{
    //Instance Variables
    private String name;
    private int companyID;
    private String companyName;
    private int tablePos;
    private int tableID;

    //Constructor
    public Attendee(String attName, String compName, int compID){
        name = attName;
        companyName = compName;
        companyID = compID;
        tableID = -1;
        tablePos = -1;
    }

    //Getters and Setters

    //Name
    public String getName(){
        return name;
    }
    public void setName(String setName){
        name = setName;
    }

    //TableID
    public int getTableID(){
        return tableID;
    }
    public void setTableID(int setTableID){
        tableID = setTableID;
    }

    //TablePos
    public int getTablePos(){
        return tablePos;
    }
    public void setTablePos(int setTablePos){
        tablePos = setTablePos;
    }

    //CompanyID
    public int getCompanyID(){
        return companyID;
    }
    public void setCompanyID(int setCompanyID){
        companyID = setCompanyID;
    }

    //CompanyName
    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String setCompanyName){
        companyName = setCompanyName;
    }

    //toString
    public String toString(){
        return ("Name: " + name + "\n") + ("Company Name: " + companyName + "\n") + ("Company ID: " + companyID + "\n") + ("Table ID: " + tableID + "\n") + ("Table Position: " + tablePos + "\n");
    }
}
