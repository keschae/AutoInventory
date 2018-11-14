/*
 *  File name:  Customer.java
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
 * Customer data
 * 
 * Stores information about a single customer.
 */
public class Customer 
{

	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phone;
	
	/**  
	 * Default Constructor
	 */
	public Customer() { }

	/**  
	 * Constructor with all attributes
	 * 
	 * @param firstName First name
	 * @param lastName Last name
	 * @param streetAddress Address
	 * @param city City
	 * @param state State
	 * @param zip Zip
  	 * @param email Email address
	 * @param phone Phone number
	 */
	public Customer(String firstName, String lastName, String streetAddress, 
			String city, String state, String zip, String email, String phone) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
	}
	
	/** 
	 * Outputs in a format convenient for a mailing label
	 */
	@Override
	public String toString() 
	{
		return "\nName: " + this.firstName + " " + this.lastName 
				+ "\nAddress: " + this.streetAddress 
				+ "\nCity/State/Zip: " + this.city + ", " + this.state + " " + this.zip
				+ "\nEmail: " + this.email 
				+ "\nPhone: (" + this.phone.substring(0, 3) + ") " 
					+ this.phone.substring(3, 6) + "-" + this.phone.substring(6) + "\n";
	}

	// various getters and setters
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
