package assignment2;
/**
 * This class models a Patron 
 * @author DennisQiu
 */

import java.util.ArrayList;

public class Patron {

	//Patron properties
	private ArrayList<Book> myBooks = new ArrayList<>();
	private String patronID;
	private String patronName;
	private static int patronCount = 1001;
	
	//Constructor for existing library of patrons
	/**
	 * This constructor models a patron with its
	 * patron ID and patron name
	 * @param patronID the unique identifier of a patron object
	 * @param patronName the name of a patron object
	 */
	public Patron(String patronID, String patronName) {
		this.patronID = patronID;
		this.patronName = patronName;
	}
	
	//Constructor to add a new patron to existing library of patrons
	/**
	 * This constructor automatically generates a new patron ID
	 */
	public Patron() {
		patronID = "P" + patronCount;
		patronCount++;
	}
	
	/**
	 * gets the ID of a patron object
	 * @return the ID of a patron object
	 */
	public String getPatronID() {
		return patronID;
	}
	
	/**
	 * gets the name of a patron object
	 * @return the name of a patron object
	 */
	public String getPatronName() {
		return patronName;
	}
	
	/**
	 * sets to the ID of a patron object
	 * @param patronID the unique identifier of a patron object
	 */
	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	/**
	 * sets to the name of a patron object
	 * @param patronName the name of a patron object
	 */
	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}	
	
	/**
	 *sets a new value to patronCount 
	 *if new patron added, will always expand count to include new patron
	 * @param pCount counts the number of patrons in library
	 */
	public void setPatronCount(Integer pCount) {
		patronCount = pCount;
	}
	
	/**
	 * This method allows each patron to 
	 * Borrow an unlimited number of books at any given time
	 * @param b Book to be borrowed by a patron at any given time
	 */
	public void checkOut(Book b) {
		myBooks.add(b);
	}
	
	/**
	 * prints out each entry of the patron objects
	 * ID and name associated with patrons Array list text file data
	 * @return ID and name associated with a patron object
	 */
	public String toString() {
		return patronID + " - " + patronName;
	}
}
