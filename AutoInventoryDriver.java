/*
 *  File name:  AutoInventoryDriver.java
 *
 *  Programmer:  Kevin Schaefer
 *  ULID:  keschae
 *
 *  Date:  October 24, 2017
 *
 *  Class:  IT 168
 *  Lecture Section:  22
 *  Lecture Instructor:  Schaefer
 *  Lab Section:
 *  Lab Instructor:
 */
package fall2017b;

import java.util.Scanner;

/**
 * Application to track automobile inventory
 *
 * This application will read from a CSV text file records
 * related to an automobile inventory of a fictitious dealer.
 * Those records in an array that stores aggregate class objects
 * of automobiles and the dealers customers.
 *
 * @author  Kevin Schaefer
 * @version 1.2
 * @since   2017-10-24
 */
public class AutoInventoryDriver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		InputOutput io = new InputOutput();
		Inventory inventory = new Inventory();
				
		int size = io.readInventory(inventory.getInventory());
		inventory.setCount(size);
		
		String choice = io.displayMenuGetChoice();
		
		// Once entered the following while loop controls the action
		// and determines what to do based on user input and
		while (!choice.equals("7"))
		{
			switch(choice)
			{
				case "1":
					io.displayAutomobileLabels();
					inventory.displayEntireInventory();
					System.out.println();
					break;
				case "2":
					System.out.print( "Display all automobile records sorted by year\n" );
					inventory.sort();
					inventory.displayEntireInventory();
					System.out.println();
					break;
				case "3":
					io.displayAutomobileLabels();
					inventory.displayAvailableInventory();
					System.out.println();
					break;
				case "4":
					System.out.print( "\nRecently Sold Automobiles\n" );
					inventory.displaySoldInventory();
					System.out.println();
					break;
				case "5":
					System.out.print( "Display mailing list of recent buyers\n" );
					inventory.displayMailListBuyers();
					System.out.println();
					break;
				case "6":
					System.out.print( "Find exact automobile by VIN number\n" );
					System.out.print( "Please enter the VIN number: " );
					String tempVin = keyboard.nextLine();
					Automobile tempAutomobile = new Automobile( 0, "", "", 0.0,
							"", 0, "", tempVin, null);
					inventory.findExactVehicle( tempAutomobile );
					break;
	
				default:
					System.out.println("Invalid choice, please try again.\n");
			}
			
			choice = io.displayMenuGetChoice();
		}

		keyboard.close();
		System.out.print( "\nQuitting application." );
		
	} // main method

} // end tester/driver class
