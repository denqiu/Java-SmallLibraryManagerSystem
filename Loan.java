package assignment2;
/**
 * This class models a Loan 
 * @author DennisQiu
 */

public class Loan {

	private Book aBook;
	private Patron aPatron;
	
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
	
	/**
	 * prints out each entry of the book ID, patron ID, and due date 
	 * associated with loans Array List text file data
	 * @return the ID of the loaned book, patron ID, and due date
	 */
	public String toString() {
		return loanBookID + " | " + loanPatronID + " | " + loanDueDate;
	}
	
	/**
	 * prints out each entry of the book object, patron object, and due date
	 * associated with loans Array List text file data
	 * @return the book object, patron object, and due date
	 */
	public String toAbstract() {
		return aBook.getBookID() + " | " + aPatron.getPatronID() + " | " + loanDueDate;
	}
}
