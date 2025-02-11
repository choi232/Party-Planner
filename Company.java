import java.util.ArrayList;

public class Company{
    private int companyID;
    private String companyName;
    private ArrayList<Attendee> employee = new ArrayList<Attendee>();
    private int numEmployee;
    public Company(int setCompanyID, String setCompanyName){
        companyID = setCompanyID;
        companyName = setCompanyName;
    }

    public int getCompanyID(){
        return companyID;
    }
    public String getCompanyName(){
        return companyName;
    }

    public int getNumEmployee(){
        return numEmployee;
    }

    public Attendee getEmployee(int index){
        return employee.get(index);
    }

    public void setEmployee(Attendee attendee, int numTables){
        if(employee.size() < numTables){
            employee.add(attendee);
            numEmployee = employee.size();
        }
    }
}
