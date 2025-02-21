/** 
 * Main.java File for creating Party object and running its methods
 * @author Mikael Choi 
 * @since 2/20/2025
 * Preconditions: Party Class/Object
 * Postconditions: runs entire Party Planner program through instance from main method
 * Purpose: Consolidate all the code being ran into one spot, particularly in the main method.
 * Makes it extremely easy to just create an instance of party and run the entire program from Main
 **/

/*
Main Class: Tester to run Party
*/
public class Main{
    //Main Method where all the magic happens
    public static void main(String[] args){
        //Create instance of party with args of numSeats = 10 and numTables = 10, respectively
        Party p = new Party(10, 10);
        //run instance method to run ENTIRE Party Planner program
        p.runPartyPlanner();
    }
}
