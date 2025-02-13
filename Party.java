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
                String[] splitStr = line.split(",");
                int compID =  Integer.parseInt(splitStr[3]);
                Attendee attendee = new Attendee(splitStr[2] + " " + splitStr[1], companyList.get(compID-1).getCompanyName(), compID);
                companyList.get(compID-1).setEmployee(attendee, numTables);

            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void register(){
        Scanner scan = new Scanner(System.in);
        printVacancy();

        System.out.println("Would you like to register? Enter y/n: ");
        String input = scan.nextLine();

        if(!input.equals("n")){
            System.out.println("Registrar Name: ");
            String name = scan.nextLine();
            System.out.println("Registrar Company: ");
            String companyName = scan.nextLine(); 
            int companyID;    
            String registrars = "";

            while(true){
                inner: while(true){
                    for(int i = 0; i < numCompany; i++){
                        if(companyList.get(i).getCompanyName().toLowerCase().equals(companyName.toLowerCase())){
                            companyID = companyList.get(i).getCompanyID();
                            break inner;
                        }
                    }
                    System.out.println("Company not found. Please enter a new company: ");
                    companyName = scan.nextLine();
                }


                Attendee attendee = new Attendee(name, companyName,companyID);
                companyList.get(companyID-1).setEmployee(attendee, numTables);  
                registrars += attendee.toString() + "\n";  


                System.out.println("Would you like to register another attendee? Enter y/n: ");
                input = scan.nextLine();

                if (input.equals("n")) break;
                else{
                    System.out.println("Registrar Name: ");
                    name = scan.nextLine();
                    System.out.println("Registrar Company: ");
                    companyName = scan.nextLine();                 
                }
            }
            System.out.println("Added Registrars: \n" );
            System.out.println(registrars);
        }

    }

    public void printVacancy(){
        System.out.println("Here is a list of open registrations for each company: ");
        for(int i = 0; i < numCompany; i++){
            System.out.println(companyList.get(i).getCompanyName() + " " + companyList.get(i).getCompanySize() + "/" + numTables);
        }
    }

    public void printCompanyList(){
        for(int i = 0; i < numCompany; i++){
            System.out.println(companyList.get(i).getCompanyName());
        }

        for(int i = 0; i < numCompany; i++){
            for(int j = 0; j < companyList.get(i).getCompanySize(); j++){
                System.out.println(companyList.get(i).getEmployee(j).toString());
            }
        }
    }
}
