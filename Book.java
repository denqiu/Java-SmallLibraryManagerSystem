package assignment2;
/**
 * This class models a Book
 * @author DennisQiu
 */

public class Book {
	
	//Book properties
	private String bookID;
	private String title;
	private String author;
	private String year;
	private String borrowerID;
	private static int bookCount = 1002;

	
	//Constructor for existing library of books
	/**
	 * This constructor models a book with its
	 * book ID, title, author, and year of publication
	 * @param bookID the unique identifier of a book
	 * @param title the title, or name, of a book
	 * @param author the name of the person who wrote this book
	 * @param year the publication year of this book
	 */
	public Book(String bookID, String title, String author, String year) {
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.year = year;
		this.borrowerID = "";
	}
	
	//Constructor for adding a new book to existing library of books
	/**
	 * This constructor automatically generates a new book ID
	 */
	public Book() {
		bookID = "B" + bookCount;
		bookCount++;
	}
	
	/**
	 * gets the ID of a book
	 * @return the ID of a book
	 */
	public String getBookID() {
		return bookID;
	}
	
	/**
	 * gets the title of a book
	 * @return the title of a book
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * gets the author of a book
	 * @return the author of a book
	 */
	public String getAuthor() {
		return author;
 	}
	
	/**
	 * gets the publication year of a book
	 * @return the publication year of a book
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * gets the ID of whoever borrowed a book
	 * @return the ID of whoever borrowed a book
	 */
	public String getBorrowerID() {
		return borrowerID;
	}
	
	/**
	 * sets to the ID of a book
	 * @param bookID the unique identifier of a book
	 */
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	
	/**
	 * sets to the title of a book
	 * @param title the title, or name of a book
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * sets to the author of a book
	 * @param author the name of the person who wrote this book
	 */
	public void setAuthor(String author) {
			this.author = author;
	}
	
	/**
	 * sets to the year of publication of a book
	 * @param year the year of publication of this book
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * sets to the ID of the borrower
	 * @param patronID the unique identifier of a patron
	 */
	public void setBorrowerID(String patronID) {
		this.borrowerID = patronID;
	}
	
	/**
	 * sets a new value to bookCount
	 * if new book added, will always expand count to include new book
	 * @param bCount counts the number of books in library
	 */
	public void setBookCount(Integer bCount) {
		bookCount = bCount;
	}
	
	/**
	 * prints out each entry of the book ID, title name, author name, and year of publication
	 * @return ID, title, author, and year associated with books Array List text file data
	 */
	public String toString() {
		return bookID + " | " + title + " | " + author + " | " + year;
	}
	
	/**
	 * prints out each entry of the book ID, title name, and year of publication written by an author
	 * @return ID, title, author, and year associated with books written by an author
	 */
	public String printListByAuthor() {
		return bookID + " | " + title + " | " + year;
	}
	
	/**
	 * prints out each entry of the book ID, title name, and author during a time period
	 * @return ID, title, and author associated with books during a time period
	 */
	public String printListByYear() {
		return bookID + " | " + title + " | " + author; 
	}
}
