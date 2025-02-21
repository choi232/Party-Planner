# Party-Planner

AP-CS A Project to create a table seating planner for a conference. Every company will send a set amount of people to the conference and the goal is to create a seating arrangement for the amount of tables and seats available so that every person at a table is from a different company.

Process: Overall, I created two main object types called Attendee and Company to store the data from companies.txt and partyguests.txt. The Attendee object stores attributes such as name, companyID, companyName, tablePos, tableID and attendeeID as well as getter and setter methods for each attribute. In addition, the Company object stores attributes such as companyID, companyName and employees along with its own getter and setter methods. These objects are created and used in the party class which creates a blueprint of the Party Planner program. Party takes on program logic such as placing attendees, registering new attendees, searching for an attendee based on name using a binary search and printing company and table rosters. The Main class creates an instance of party and runs the entire program from the main method.

Screenshot of Binary Search Algorithm Finding User:

![image](https://github.com/user-attachments/assets/94e96cee-8cd0-4862-b6b0-e3fd32fd25d0)

