
/** 
 * Party.java File for creating Party objects in Party Planner
 * @author Mikael Choi 
 * @since 2/20/2025
 * Preconditions: Attendee & Company classes; ArrayList, Scanner & File I/O libraries; txt files
 * Postconditions: generates a full instance of Party Planner to be run in the Main "runner/tester" class
 * Purpose: Organize all the logic for Party Planner into a single instance of the class which 
 * can be customized with different seating and table arrangements for future use by simply creating and
 * running a simple method from the object within the Main class
 **/

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; //Import ArrayList class
import java.util.Collections;

/*
Party Class: Blueprint to create an instance of Party Planner program tailored
to user's choice of numTables and numSeats. Class will contain all necessary attributes
 such as the attendeeList, companyList and searchList ArrayLists and methods such as register, 
 placeAttendee, findAttendee and printing functions to properly create an instance of the program.
*/
public class Party{

    //Creation of Attribute Variables
    private ArrayList<ArrayList<Attendee>> attendeeList = new ArrayList<ArrayList<Attendee>>();
    private ArrayList<Company> companyList = new ArrayList<Company>();
    private ArrayList<Attendee> searchList = new ArrayList<Attendee>();
    private int numCompany;
    private int numSeats;
    private int numTables;
    private int currID;

    //Constructor to set private attributes to inputted arguments
    public Party(int setNumSeats, int setNumTables){
        numSeats = setNumSeats;
        numTables = setNumTables;
    }

    /*
    runPartyPlanner: void method with no return type or args to simply just assemble all other functions
    in the class so that main can run one simple function
    */

    public void runPartyPlanner(){
        readFile();
        register();
        placeAttendees();
        System.out.println("\nParty Planner has automatically created the best seating arrangements available with your inputted data.");
        printTableRoster();
        printCompanyRoster();
        //printIDArray();
        //printID();
        findAttendee();
    }
    /*
    readFile: method to access two txt files and read and format their data 
    into ArrayLists such as companyList and searchList; void return type and no args
    */
    public void readFile(){

        try {
            //Create File & Scanner Objects
            File companyFile = new File("companies.txt");
            File partyGuestsFile = new File("partyguests.txt");
            Scanner scanCompany = new Scanner(companyFile);
            Scanner scanGuests = new Scanner(partyGuestsFile);

            while(scanCompany.hasNextLine()){
                String line = scanCompany.nextLine();
                if(line.length() > 0){
                    String[] splitStr = line.split(",");
                    //split by comma delimiter & create company object
                    Company company = new Company(Integer.parseInt(splitStr[0]), splitStr[1]);
                    companyList.add(company);
                }
            }
            numCompany = companyList.size();

            while(scanGuests.hasNextLine()){
                String line = scanGuests.nextLine();
                String[] splitStr = line.split(",");
                //split by comma delimiter
                int compID =  Integer.parseInt(splitStr[3]);
                currID =  Integer.parseInt(splitStr[0]);
                //use split data to create Attendee object
                Attendee attendee = new Attendee(splitStr[2] + " " + splitStr[1], companyList.get(compID-1).getCompanyName(), currID, compID);
                searchList.add(attendee);
                companyList.get(compID-1).setEmployee(attendee, numTables);

            }
            scanCompany.close();
            scanGuests.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.out.print("Party Planner has read all imported files.");
    }

    public void register(){
        Scanner scan = new Scanner(System.in);

        //Print out prompt
        System.out.print("\n\nWould you like to view current registration? Enter 'y' or 'n': ");
        String input = scan.nextLine();
        //Input validation
        if(!input.equals("y") && !input.equals("n") && !input.equals("yes") && !input.equals("no")){
            while(true){
                //Continue asking until right format
                System.out.print("\nPlease enter either 'y' or 'n': ");
                input = scan.nextLine();
                if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")) break;
            }
        }
        if(input.equals("yes") || input.equals("y")){
            System.out.println("\nHere is a list of open registrations for each company based on the imported data: \n");
            //Iterate through companies to print each company and the available registration spots
            for(int i = 0; i < numCompany; i++){
                if (i == numCompany-1) System.out.print(companyList.get(i).getCompanyName() + " " + companyList.get(i).getCompanySize() + "/" + numTables);
                else System.out.print(companyList.get(i).getCompanyName() + " " + companyList.get(i).getCompanySize() + "/" + numTables + "; ");
                if((i+1)%2==0) System.out.println();
            } //for loop
        }

        System.out.print("\nWould you like to register an attendee? Enter 'y' or 'n': ");
        input = scan.nextLine();

        //Input Validation
        if(!input.equals("y") && !input.equals("n") && !input.equals("yes") && !input.equals("no")){
            while(true){
                System.out.print("\nPlease enter either 'y' or 'n': ");
                input = scan.nextLine();
                if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")) break;
            }
        }
        

        if(input.equals("yes") || input.equals("y")){
            System.out.print("\nRegistrar Name: ");
            String name = scan.nextLine();
            System.out.print("\nRegistrar Company: ");
            String companyName = scan.nextLine(); 
            int companyID;    
            String registrars = "";

            while(true){
                inner: while(true){
                    //Input Validation for correct company name when registering
                    for(int i = 0; i < numCompany; i++){
                        if(companyList.get(i).getCompanyName().toLowerCase().equals(companyName.toLowerCase())){
                            companyID = companyList.get(i).getCompanyID();
                            companyName = companyList.get(i).getCompanyName();
                            break inner;
                        } //if
                    }//for
                    Company company = new Company(companyList.size()+1, companyName);
                    companyID = company.getCompanyID();
                    companyList.add(company);
                    System.out.println("\nAdded New Company: " + company.getCompanyName());
                    numCompany = companyList.size();
                    break inner;
                } //outer while

                //Creating Attendee objects & adding to employee ArrayList
                currID++;
                Attendee attendee = new Attendee(name, companyName, currID, companyID);
                searchList.add(attendee);
                companyList.get(companyID-1).setEmployee(attendee, numTables);  
                registrars += attendee.toString() + "\n";  

                //Rest Below is Input Validation & Prompting/Scanning
                System.out.print("\nWould you like to register another attendee? Enter y/n: ");
                input = scan.nextLine();

                if (input.equals("n") || input.equals("no")) break;

                else if (input.equals("y") || input.equals("yes")){
                    System.out.print("\nRegistrar Name: ");
                    name = scan.nextLine();
                    System.out.print("\nRegistrar Company: ");
                    companyName = scan.nextLine();                 
                } //else if

                else{
                    while(true){
                        System.out.print("\nPlease enter either 'y' or 'n': ");
                        input = scan.nextLine();
                        if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")) break;
                    } // while
                    if (input.equals("n") || input.equals("no")) break;

                    else if (input.equals("y") || input.equals("yes")){
                    System.out.print("\nRegistrar Name: ");
                    name = scan.nextLine();
                    System.out.print("\nRegistrar Company: ");
                    companyName = scan.nextLine();                 
                    } //else if
                } //else

            } //while loop close

            System.out.println("\nAdded Registrars: \n" );
            System.out.println(registrars);
        }
    }

    /*
    printCompanyRoster: method to iterate through companyList and each employee
    ArrayList within to print out all the names of the possible attendees from each company;
    void return type & no args
    */
    public void printCompanyRoster(){
        numCompany = companyList.size();
        Scanner scan = new Scanner(System.in);
        //Input Validation of yes and no
        System.out.print("\nWould you like to view a company roster of the seating arrangements? Enter 'y' or 'n': ");
        String input = scan.nextLine();
        if(!input.equals("y") && !input.equals("n") && !input.equals("yes") && !input.equals("no")){
            while(true){
                System.out.print("\nPlease enter either 'y' or 'n': ");
                input = scan.nextLine();
                if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")) break;
            }
        }
        if(input.equals("yes") || input.equals("y")){
            System.out.println("Company: Full Name (TableID, TablePos)\n");
            //Iterating through companyList & employee ArrayLists and printing out names
            for(int i = 0; i < numCompany; i++){
                System.out.print(companyList.get(i).getCompanyName() + ": ");
                if(companyList.get(i).getCompanySize() == 0 || companyList.get(i).getEmployee(0).getTableID() == -1) System.out.print("N/A");
                for(int j = 0; j < companyList.get(i).getCompanySize(); j++){
                    if(companyList.get(i).getEmployee(j).getTableID() != -1){
                        if(j == companyList.get(i).getCompanySize()-1) System.out.print(companyList.get(i).getEmployee(j).getName() + " (" + companyList.get(i).getEmployee(j).getTableID() + ", " + companyList.get(i).getEmployee(j).getTablePos() + ")");
                        else System.out.print(companyList.get(i).getEmployee(j).getName() + " (" + companyList.get(i).getEmployee(j).getTableID() + ", " + companyList.get(i).getEmployee(j).getTablePos() + "), ");
                    }
                }
                System.out.println();
            }
        }
    }

    /*
    printCompanyRoster: method to iterate through attendeeList ArrayList and to print 
    out all the names of the possible attendees from each table and seat;
    void return type & no args
    */
    public void printTableRoster(){
        numCompany = companyList.size();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nWould you like to view a table roster of the seating arrangements? Enter 'y' or 'n': ");
        String input = scan.nextLine();
        if(!input.equals("y") && !input.equals("n") && !input.equals("yes") && !input.equals("no")){
            while(true){
                System.out.print("\nPlease enter either 'y' or 'n': ");
                input = scan.nextLine();
                if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")) break;
            }
        }
        if(input.equals("yes") || input.equals("y")){
            System.out.println("\nTable: Full Name (TableID, TablePos, CompanyName)\n");
            //Iterating through attendeeList ArrayList and printing out names
            outer: for(int i = 0; i < numTables; i++){
                System.out.print("Table " + (i+1) + ": ");
                for(int j = 0; j < numSeats; j++){
                    if(attendeeList.get(i).get(j).getTableID() == -1) break outer;
                    else if(j == numSeats-1) System.out.print(attendeeList.get(i).get(j).getName() + " (" + attendeeList.get(i).get(j).getTableID() + ", " + attendeeList.get(i).get(j).getTablePos() + ", " + attendeeList.get(i).get(j).getCompanyName() + ")");
                    else System.out.print(attendeeList.get(i).get(j).getName() + " (" + attendeeList.get(i).get(j).getTableID() + ", " + attendeeList.get(i).get(j).getTablePos() + ", " + attendeeList.get(i).get(j).getCompanyName() + "), ");
                    
                }//inner for
                System.out.println("\n");
            }//outer for
            System.out.println();
        }//outer if
    }//method closing bracket

    /*
    placeAttendees: method to iterate through attendeeList and place each
    attendee object by company into tables and seating positions without overlap of
    more than one of same company at same table;
    void return type & no args
    */
    public void placeAttendees(){
        numCompany = companyList.size();
        //initialize ArrayList attendeeList with numTables amount of ArrayLists inside attendeeList
        for(int i = 0; i < numTables; i++){
            ArrayList<Attendee> table = new ArrayList<Attendee>();
            attendeeList.add(table);
        }
        
        int companyIndex = 0;
        int employeeIndex = 0;
        Attendee blank = new Attendee("N/A", "N/A", -1, -1);
        Attendee currAttendee;

        //reversed for loop of col & row to place by col instead of row
        outer: for(int col = 0; col < numSeats; col++){
            inner: for(int row = 0; row < numTables; row++){
                //When employeeIndex tracker reaches end of employee ArrayList move to next company and its employee ArrayList
                if (companyIndex < numCompany && employeeIndex == companyList.get(companyIndex).getCompanySize()){
                    employeeIndex = 0;
                    companyIndex++;
                }

                if(companyIndex < numCompany && employeeIndex < companyList.get(companyIndex).getCompanySize()){
                    //Add same company attendees by column so tables/rows do not get same attendees 
                    attendeeList.get(row).add(companyList.get(companyIndex).getEmployee(employeeIndex));

                    //Update Attendee object's attributes with their assigned table numbers and position
                    currAttendee = attendeeList.get(row).get(attendeeList.get(row).size()-1);
                    currAttendee.setTableID(row+1); //Where first table is equal table one
                    currAttendee.setTablePos(col+1); //Where first position in table is pos one

                    employeeIndex++;
                }
                else attendeeList.get(row).add(blank);
            } //inner for loop
        } //outer for loop
    } //method closer

    /*
    findAttendee: method to iterate through sorted searchList (ArrayList) of all possible attendees placed in seating
    and find an attendee object just from its ID by using a binary search to look for object with matching ID;
    void return type & no args
    */
    public void findAttendee(){
        Scanner scan = new Scanner(System.in);
        //Prompting + Input Validation
        System.out.print("\nWould you like to search for an attendee? Enter 'y' or 'n': ");
        String input = scan.nextLine().toLowerCase();
        if (!input.equals("n") && !input.equals("no") && !input.equals("y") && !input.equals("yes")){
            while(true){
                System.out.println("Invalid input, please enter either yes or no: ");
                input = scan.nextLine().toLowerCase();
                if(input.equals("yes") || input.equals("y")) break;
                else if(input.equals("no") || input.equals("n")) break;
            }
        }
        while(input.equals("y") || input.equals("yes")){
            
            System.out.print("Enter attendee's full name (first last): ");
            String search = scan.nextLine();
            System.out.println();
            
            searchList.sort((a, b) -> {return a.getName().compareTo(b.getName());});

            //Clean through searchList to erase people who signed up for the event BUT were not placed onto tables
            //Leaves only attendees in search list after iterating through
            for(int i = searchList.size() - 1; i >= 0; i--){
                if(searchList.get(i).getTablePos() == -1) searchList.remove(i);
            }

            //Search for within attendeeList ArrayList to find given Attendee object from ID number
            int lowIndex = 0; //lower bound of possible values
            int highIndex = searchList.size()-1; //upper bound of possible values
            boolean isFound = false; //bool flag for if searching value is not in data set
            int middle, counter = 0;
            String guess;


            while(highIndex - lowIndex + 1 > 0){ //size of array is greater than zero
                counter++;
                middle = lowIndex + (highIndex - lowIndex)/2; //set middle to half of possible array plus current lower bound
                guess = searchList.get(middle).getName();

                //Verbose print commands to show processing
                System.out.println("Iteration #" + counter); //implementation of counter for search length
                System.out.print("Middle Index: " + middle + ";");
                System.out.println("  Name: " + guess);
                System.out.println("lowIndex & highIndex Range: (" + lowIndex + ", " + highIndex + ")\n");

                //check if guess is right
                if(guess.compareTo(search) == 0){
                    System.out.println("Found Match: " + guess);
                    isFound = true;
                    System.out.println("\n" + searchList.get(middle).toString());
                    break;
                }

                //guess too high then adjust upper bound
                else if(guess.compareTo(search) > 0){
                    highIndex = middle - 1;
                }

                //guess too low then adjust lower bound
                else if(guess.compareTo(search) < 0){
                    lowIndex = middle + 1;
                }
            }

            //Handling if inputted number is not in csv
            if(!isFound) System.out.println("Not Found");

            //Prompting again if they want to search for another attendee
            System.out.print("\nWould you like to search for another attendee? Enter 'y' or 'n': ");
            input = scan.nextLine().toLowerCase();
            if (!input.equals("n") && !input.equals("no") && !input.equals("y") && !input.equals("yes")){
                while(true){
                    System.out.println("Invalid input, please enter either yes or no: ");
                    input = scan.nextLine().toLowerCase();
                    if(input.equals("yes") || input.equals("y")) break;
                    else if(input.equals("no") || input.equals("n")) break;
                }
            }

        }//while loop
    }//method
}//class
