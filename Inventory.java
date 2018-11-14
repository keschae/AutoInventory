/*
 *  File name:  Inventory.java
 *
 *  Programmer:  Kevin Schaefer
 *  ULID:  keschae
 *
 *  Date:  October 24, 2017
 *
 *  Class:  IT 168
 *  Lecture Section:  13
 *  Lecture Instructor:  Schaefer
 *  Lab Section:
 *  Lab Instructor:
 */
package fall2017b;

/**
* Array of Aggregate Automobile Objects
* 
* Represents an inventory of Automobile objects and related methods.
* The methods do various sorting and searching of the array and then
* display results to the screen.
*
* @author  Kevin Schaefer
* @version 1.2
* @since   2017-10-24
*/
public class Inventory
{
	private final static int ARRAY_SIZE = 100;
	private Automobile[] inventory;
	private int size;
	
	/**
	 * Constructor - creates the inventory array.
	 * Initializes the inventory array to be able to hold 100 automobile objects.
	 */
	public Inventory()
	{
		inventory = new Automobile[ARRAY_SIZE];
	}

    /**
     * This method loops through the array of Automobile objects and
     * outputs them to the display utilizing the Automobile toString method.
     * Does not require any parameters to be passed and does not return data.
     */
	public void displayEntireInventory()
	{
		for( int index = 0; index < size; index++)
		{
			System.out.print( inventory[index] );
		}

	}
	
	/**  
	 * Performs a Selection Sort on an Automobile objects.
	 * It requires no parameters to be passed because it operates
	 * on instance variables. Also returns no data because
	 * it modifies the original array.
	 */
	public void sort()
	{
		// could deep copy array or change original
		
		Automobile temp; 		// temporary location for swap
		int maxIndex;  			// index of maximum value in subarray
		int filled = this.size;

		for ( int i = 0; i < filled - 1; i++ )
		{
			// find index of largest value in subarray
			maxIndex = indexOfLargestElement( this.inventory, filled - i );

			// swap array[max] and array[array.length - i - 1]
			temp = this.inventory[maxIndex];
			this.inventory[maxIndex] = this.inventory[filled - i - 1];
			this.inventory[filled - i - 1] = temp;
		}
	}

	/**  
	 * Finds index of the array object that has largest year.
	 * Gets called by the selection sort method. The array
	 * being searched strengths each time this method is called.
	 * @param populated array of Automobile objects, could use instance variable
	 * @param size of current subarray to search for largest element
	 * @return the index of the largest element in the subarray
	 */
	private int indexOfLargestElement( Automobile[] array, int subArrSize )
	{
		int index = 0;
		for( int i = 1; i < subArrSize; i++ )
		{
			if ( array[i].getYear() > array[index].getYear() )
				index = i;
		}
		return index;
	}

	/**
	 * Searches the array of Automobile objects for records with the status attribute set to
	 * "Available". After finding one it outputs that record to the display utilizing the
	 * Customer toString method. It doesn't require any parameters to be passed and
	 * doesn't return any data because it outputs to the display.
	 */
	public void displayAvailableInventory()
	{
		for( int index = 0; index < size; index++)
		{
			if( inventory[index].getStatus().equalsIgnoreCase("Available") )
			{
				System.out.print( inventory[index] );
			}
		}
	}

	/**
	 * Searches the array of automobile objects for records with the status attribute set to "Sold".
	 * After finding one it retrieves the year, make and model using getter methods from the
	 * Automobile class and outputs that data to the display. it doesn't have any parameters
	 * because it uses instance variables and doesn't return any data but does output to the display.
	 */
	public void displaySoldInventory()
	{
		for( int index = 0; index < size; index++)
		{
			if( inventory[index].getStatus().equalsIgnoreCase("Sold") )
			{
				System.out.println( inventory[index].getYear() + " " 
						+ inventory[index].getMake() + " " 
						+ inventory[index].getModel() );
			}
		}
	}

	/**
	 * Searches the array of Automobile objects for records with the status attribute set to "Sold".
	 * After finding one it gets the Customer object and prints it by implicitly calling the 
	 * Customer object toString method. It searches the instance variable array of Automobile 
	 * objects and doesn't return any data because its purpose is to output to the display.
	 */
	public void displayMailListBuyers()
	{
		for( int index = 0; index < size; index++)
		{
			if( inventory[index].getStatus().equalsIgnoreCase("Sold") )
			{
				System.out.print( inventory[index].getCustomer() );
			}
		}
	}

	/**
	 * Searches the array of Automobile objects for a matching VIN number.
	 * When matches found it outputs information to the display.
	 * @param tempAuto An Automobile object to search for
	 */
	public void findExactVehicle( Automobile tempAuto )
	{
		boolean found = false;

		for( int index = 0; index < size; index++)
		{
			if( inventory[index].equals( tempAuto ) )
			{
				found = true;
				System.out.print( "\nWe have find this vehicle: \n" );
				System.out.print( inventory[index] );
			}
		}
		if(found == false)
			System.out.println( "We cannot find this auto in our inventory.");
	}

	/**
	 * @return Automobile[] Array of Automobile objects
	 */
	public Automobile[] getInventory()
	{
		return inventory;
	}

	/**
	 * @param inventory Array of Automobile objects
	 */
	public void setTable(Automobile[] inventory)
	{
		this.inventory = inventory;
	}

	/**
	 * @return size The number of filled elements in the array
	 */
	public int getCount()
	{
		return size;
	}

	/**
	 * @param count The number of array elements filled
	 */
	public void setCount(int count)
	{
		this.size = count;
	}

}
