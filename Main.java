/** 
 * Main.java File for creating Party object and running its methods
 * @author Mikael Choi 
 * @since 2/20/2025
 * Preconditions: Party Class/Object
 * Postconditions: runs entire Party Planner program through instance from main method
 * Purpose: Consolidate all the code being ran into one spot, particularly in the main method.
 * Makes it extremely easy to just create an instance of party and run the entire program from Main
 **/

import java.util.Scanner; //import Scanner classs

/*
Main Class: Tester to run Party
*/
public class Main{
    //Main Method where all the magic happens
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\nWelcome to Party Planner, a reusable program which organizes seating arrangements for professional events based on an inputted amount of tables and seats.\n");
        System.out.print("Please enter the number of tables: ");
        int numTables;
        //Input Validation for proper integer using try catch in a while loop to continue prompting user
        while (true){
            try {
                numTables = Integer.parseInt(scan.nextLine());
                if(numTables > 0) break;
                else System.out.print("\nInvalid input, please enter an integer greater than zero: ");
                
            } 
            catch (NumberFormatException e) {
                System.out.print("\nInvalid input, please enter a positive integer: ");
            }
        }
        System.out.print("\nPlease enter the amount of seats in each table: ");
        int numSeats;
        
        //Input Validation for proper integer using try catch in a while loop to continue prompting user
        while (true){
            try {
                numSeats = Integer.parseInt(scan.nextLine());
                if(numSeats > 0) break;
                else System.out.print("\nInvalid input, please enter an integer greater than zero: ");
                
            } 
            catch (NumberFormatException e) {
                System.out.print("\nInvalid input, please enter a positive integer: ");
            }
        }
        System.out.println();
    
        //Create instance of party with args of numSeats and numTables, respectively
        Party p = new Party(numSeats, numTables);
        //run instance method to run ENTIRE Party Planner program
        p.runPartyPlanner();
    }
}
