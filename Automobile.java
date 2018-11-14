
/*
 *  File name:  Automobile.java
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

/**
* Automobile data
* 
* Represents Automobile objects which have various attributes
* stored in the instance variables. The attributes are items that
* an automobile dealer may use.
*
* @author  Kevin Schaefer
* @version 1.2
* @since   2017-10-24
*/
public class Automobile
{	
	private int year = 0;
	private String make = "";
	private String model = "";
	private double price = 0.0;
	private String condition = "";
	private int rating = 0;
	private String status = "";
	private String vin = "";
	private Customer customer = null;
	
	/**  
	 * Constructor with all except customer attribute
	 * 
	 * @param year Year this automobile was produced.
	 * @param make Brand manufacturer of this automobile.
	 * @param model Model of this automobile.
	 * @param price Price of this automobile.
	 * @param condition Options are excellent, very good, like new, fair.
	 * @param rating Rating created by customers online.
	 * @param status Options are available, hold or sold.
	 * @param vin Manufacturer unique identifier for this automobile.
	 */
	public Automobile(int year, String make, String model, double price, 
			String condition, int rating, String status, String vin) 
	{
		super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
		this.condition = condition;
		this.rating = rating;
		this.status = status;
		this.vin = vin;
	}

	/**  
	 * Constructor with all attributes
	 * 
	 * @param year Year this automobile was produced.
	 * @param make Brand manufacturer of this automobile.
	 * @param model Model of this automobile.
	 * @param price Price of this automobile.
	 * @param condition Options are excellent, very good, like new, fair.
	 * @param rating Rating created by customers online.
	 * @param status Options are available, hold or sold.
	 * @param vin Manufacturer unique identifier for this automobile.
	 * @param customer Customer object associated with this automobile.
	 */
	public Automobile(int year, String make, String model, double price, 
			String condition, int rating, String status, String vin, Customer customer) 
	{
		super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
		this.condition = condition;
		this.rating = rating;
		this.status = status;
		this.vin = vin;
		this.customer = customer;
	}
	
	/**  
	 * Default Constructor
	 */
	public Automobile() 
	{
		super();
	}	

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getStatus() {
		return status;
	}

	public Customer getCustomer() {
		return customer;
	}

	/**  
	 * toString method 
	 * 
	 * Creates a text format that is convenient for 
	 * the reports needed for the dealer.
	 */
	@Override
	public String toString() {
	    return String.format("%-5s %-12s %-12s %10.2f %-10s %6d %-11s %8s \n", 
	    		year, make, model, price, condition, rating, status, vin );
	}	
	
	/**  
	 * Equals method
	 * 
	 * This method compares Automobile objects based on their vin number being equal.
	 * @param other An Automobile object to be compared to the calling object.
	 * @return A Boolean value true or false if vehicles are found to be equal based on vin.
	 */
	public boolean equals(Automobile other)
	{
		boolean areEqual = false;
		if( this.vin.equals( other.vin ))
			areEqual = true;
		return areEqual;
	}
	
}
