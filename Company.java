public class Company{
    private int companyID;
    private String companyName;
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
}
