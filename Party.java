import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; //Import ArrayList class


public class Party{
    private ArrayList<ArrayList<Attendee>> attendeeList = new ArrayList<ArrayList<Attendee>>();
    private ArrayList<Company> companyList = new ArrayList<Company>();
    private int numCompany;
    private int numSeats;
    private int numTables;

    public Party(int setNumSeats, int setNumTables){
        numSeats = setNumSeats;
        numTables = setNumTables;
    }

    public void readFile(){
        try {
            File companyFile = new File("companies.txt");
            File partyGuestsFile = new File("partyguests.txt");

            Scanner scanCompany = new Scanner(companyFile);
            Scanner scanGuests = new Scanner(partyGuestsFile);

            while(scanCompany.hasNextLine()){
                String line = scanCompany.nextLine();
                if(line.length() > 0){
                    String[] splitStr = line.split(",");
                    Company company = new Company(Integer.parseInt(splitStr[0]), splitStr[1]);
                    companyList.add(company);
                }
            }
            numCompany = companyList.size();

            while(scanGuests.hasNextLine()){
                String line = scanGuests.nextLine();
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void register(){

    }

    public void printCompanyList(){
        for(int i = 0; i < numCompany; i++){
            System.out.println(companyList.get(i).getCompanyName());
        }
    }
}
