/*
 *  File name:  InputOutput.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Handles input for the automobile inventory application
 *
 * @author Schaefer
 *
 */
public class InputOutput
{
	private Scanner keyboard = new Scanner(System.in);

	/**
	 * Reads the lines from the inventory.csv file
	 * parses them and creates objects
	 * 
	 * @param inventory This is an array of Automobile objects
	 * @return size This is the number of elements in the Automobile array that have been filled
	 */
	public int readInventory(Automobile[] inventory)
	{
		final String FILENAME = "inventory.csv";
		int size = 0;

		Scanner input = null;
		try
		{
			input = new Scanner(new File(FILENAME));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to open file " + FILENAME + ".");
		}

		// read header line and discard first line
		String line = input.nextLine();
		
		// create vars
		int year = 0;
		String make = "";
		String model = "";
		double price = 0.0;
		String condition = "";
		int rating = 0;
		String status = "";
		String vin = "";
		
		// Customer vars
		String firstName = "";
		String lastName = "";
		String streetAddress = "";
		String city = "";
		String state = "";
		String zip = "";
		String email = "";
		String phone = "";

		while (input.hasNext() && size < inventory.length)
		{
			line = input.nextLine();
			String[] record = line.split(",");

			year = Integer.parseInt(record[0]);
			make = record[1];
			model = record[2];

			// If use this version, comment out the following if statements

			if (!(record[3].equals("")))
			{
				price = Double.parseDouble(record[3]);
			}
			else
			{
				price = 0;
			}

			condition = record[4];

			if (!(record[5].equals("")))
			{
				rating = Integer.parseInt(record[5]);
			}
			else
			{
				rating = 0;
			}

			status = record[6];
			vin = record[7];
			
			// this is where the records differ
			// they either don't have buyer information or some do
			
			if (record.length > 8) 
			{
				if (!(record[8].equals("")))
					firstName = record[8];
				else
					firstName = "";
				
				if (!(record[9].equals("")))
					lastName = record[9];
				else
					lastName = "";
				
				if (!(record[10].equals("")))
					streetAddress = record[10];
				else
					streetAddress = "";
				
				if (!(record[11].equals("")))
					city = record[11];
				else
					city = "";
				
				if (!(record[12].equals("")))
					state = record[12];
				else
					state = "";
				
				if (!(record[13].equals("")))	
					zip = record[13];
				else
					zip = "";
				
				if (!(record[14].equals("")))
					email = record[14];
				else
					email = "";
				
				if (!(record[15].equals("")))
					phone = record[15];
				else
					phone = "";
				
			}
			
			Customer tempCustomer = new Customer( firstName, lastName, streetAddress, 
					city, state, zip, email, phone );
			
			Automobile tempAutomobile = new Automobile( year, make, model, price, 
					condition, rating, status, vin, tempCustomer );

			inventory[size] = tempAutomobile;
			size++;
			
		} // end of while loop

		input.close();

		return size;
	}

	/**
	 * Display the menu of choices
	 * 
	 * Gets called from the main method in the driver class.
	 * @return choice Options 1 through 7 stored as a String
	 */
	public String displayMenuGetChoice()
	{					
        System.out.println("Specialty Auto\n");
        System.out.println("(1) Display the entire automobile inventory list");
        System.out.println("(2) Display the entire automobile inventory sorted by year");      
        System.out.println("(3) Display automobiles available for sale");
        System.out.println("(4) Display list of recently sold automobiles");
        System.out.println("(5) Output a mailing list of recent buyers");
        System.out.println("(6) Find automobile by VIN number");
        System.out.println("(7) Quit\n");
        System.out.print("Enter your choice (1-7): ");
		
        String choice = this.keyboard.nextLine();
        return choice;
	}
	
	/**
	 * Display labels for automobile report 
	 */
	public void displayAutomobileLabels() 
	{
		 System.out.printf("\n%-5s %-12s %-12s %10s %-10s %4s %-11s %8s \n", 
		    		"Year", "Make", "Model", "Price", "Condition", "Rating", "Status", "VIN" );
	}
	
}
