package assignment2;
/**
 * This class models a Loan with the ability to use either
 * Strings or Abstract coding
 * @author DennisQiu
 */

public class Loan {

	//Loan properties
	//Strings
	private String loanBookID;
	private String loanPatronID;
	private String loanDueDate;
	//Abstract 
	private Book aBook;
	private Patron aPatron;
	
	//Constructor for Strings
	/**
	 * This constructor models a loan with its
	 * loaned book ID, loaned patron ID, and the due date of the loaned book
	 * @param loanBookID the unique identifier of the loaned book
	 * @param loanPatronID the unique identifier of the patron who has the loaned book
	 * @param loanDueDate the date that the loaned book is due
	 */
	public Loan(String loanBookID, String loanPatronID, String loanDueDate) {
		this.loanBookID = loanBookID;
		this.loanPatronID = loanPatronID;
		this.loanDueDate = loanDueDate;
	}
	
	//Constructor for Abstract 
	/**
	 * This constructor models a loan with its
	 * book object, patron object, and the due date of the loaned book
	 * @param aBook a book object
	 * @param aPatron a patron object
	 * @param loanDueDate the date that the loaned book is due
	 */
	public Loan(Book aBook, Patron aPatron, String loanDueDate) {
		this.aBook = aBook;
		this.aPatron = aPatron;
		this.loanDueDate = loanDueDate;
	}
	
	//getters
	//Strings
	/**
	 * gets the ID of the loaned book
	 * @return the ID of the loaned book
	 */
	public String getLoanBookID() {
		return loanBookID;
	}
	
	/**
	 * gets the ID of the patron who owns the loaned book
	 * @return the ID of the patron who owns the loaned book
	 */
	public String getLoanPatronID() {
		return loanPatronID;
	}
	
	/**
	 * gets the due date of the loaned book
	 * @return the due date of the loaned book
	 */
	public String getLoanDueDate() {
		return loanDueDate;
	}
	
	//Abstract 
	/**
	 * gets a book object
	 * @return a book object
	 */
	public Book getABook() {
		return aBook;
	}
	
	/**
	 * gets a patron object
	 * @return a patron object
	 */
	public Patron getAPatron() {
		return aPatron;
	}
	
	//setters
	//Strings
	/**
	 * sets to the ID of the loaned book
	 * @param loanBookID the unique identifier of the loaned book
	 */
	public void setLoanBookID(String loanBookID) {
		this.loanBookID = loanBookID;
	}
	
	/**
	 * sets to the ID of the patron who owns the loaned book
	 * @param loanPatronID the unique identifier of the patron who owns the loaned book
	 */
	public void setLoanPatronID(String loanPatronID) {
		this.loanPatronID = loanPatronID;
	}
	
	/**
	 * sets to the due date of the loaned book
	 * @param loanDueDate the due date of the loaned book
	 */
	public void setLoanDueDate(String loanDueDate) {
		this.loanDueDate = loanDueDate;
	}
	
	//Abstract
	/**
	 * sets to the ID of the book object
	 * @param bookID the unique identifier of a book object
	 */
	public void setABook(Book bookID) {
		this.aBook = bookID;
	}
	
	/**
	 * sets to the ID of the patron object
	 * @param patronID the unique identifier of a patron object
	 */
	public void setAPatron(Patron patronID) {
		this.aPatron = patronID;
	}
	
	//String prints
	//Strings
	/**
	 * prints out each entry of the book ID, patron ID, and due date 
	 * associated with loans Array List text file data
	 * @return the ID of the loaned book, patron ID, and due date
	 */
	public String toString() {
		return loanBookID + " | " + loanPatronID + " | " + loanDueDate;
	}
	
	//Abstract 
	/*
	NOTE that returning aBook and aPatron returns the full Book and Patron objects
	Meaning Book with its bookID, title, author, year and Patron with its patronID and patronName
	ONLY want bookID and patronID, NOT the full objects
	*/		
	/**
	 * prints out each entry of the book object, patron object, and due date
	 * associated with loans Array List text file data
	 * @return the book object, patron object, and due date
	 */
	public String toAbstract() {
		return aBook.getBookID() + " | " + aPatron.getPatronID() + " | " + loanDueDate;
	}
}
