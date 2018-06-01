package assignment2;
/**
* This class models a library of books, patrons, and loans with the ability to use either
* Strings or Abstract coding
* @author DennisQiu
*/ 

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibManagerSmall {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Patron> patronList = new ArrayList<Patron>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	private String[] menuOptions;

	public static void main(String[] args) {
		LibManagerSmall lm = new LibManagerSmall();
		lm.execute();
	}

	public LibManagerSmall() {
		bookList = readBooks("Resources/books.txt");
		patronList = readPatrons("Resources/patrons.txt");
		loanList = readLoans("Resources/loans.txt");

		menuOptions = new String[] { "Add Book", "Add Patron", "List By Author",
				"List By Year", "Show Borrower", "Show Borrowed Books", "Return Book", "Exit" };
	}

	private void execute() {

		while (true) {
			int opt = getMenuOption();
			switch (opt) {
			case 1:
				addBook();
				break;
			case 2:
				addPatron();
				break;
			case 3:
				listByAuthor();
				break;
			case 4:
				listByYear();
				break;
			case 5:
				showBorrowers();
				break;
			case 6:
				showBorrowedBooks();
				break;
            case 7:
				returnBook();
				break;
			case 8:
				exitProgram();
				break;
			default:
				System.out.println("No such option");
			}
		}

	}

	private int getMenuOption() {

		System.out.println("Select one of the following options");
		for (int i = 0; i < menuOptions.length; i++) {
			System.out.println("\t" + (i + 1) + ". " + menuOptions[i]);
		}

		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();

		return choice;
	}

	/* MAKE NO CHANGES ABOVE THIS LINE */
	/* COMPLETE ALL THE CODE STUBS BELOW */

	/*
	B1002	;    My New Book 	;	 Dennis Qiu 	;	 2018
	B1003 	;	 My Next Book 	;	 Dennis Qiu 	;	 2020
	B1004 	;	 My Last Book 	;	 Dennis Qiu 	;	 2030
	B1005 	;	 Bored 	;	 Dennis Qiu 	;	 1500
	B1006 	;	 DQIU 	;	 Dennis Qiu 	;	 2015
	B1007 	;	 Nope 	;	 Dennis Qiu 	;	 2222
	B1008 	;	 ReNew 	;	 Dennis Qiu 	;	 5050
	 */
	/**
	 * This method reads out the data in this text file associated with books
	 * Should open this named file
	 * Read each line
	 * Parse into book ID, title, author, year
	 * Create a corresponding Book object
	 * Append to Array List
	 * @param filename the name of the text file associated with books being read
	 * @return Array List associated with books
	 */
	private ArrayList<Book> readBooks(String filename) {
        System.out.println("Reading file " + filename);     
        try {    	
      		FileReader file = new FileReader(filename);
      		Scanner scannerBook = new Scanner(file);
			
      		Book aBook = null;
			while (scannerBook.hasNext()) {
				String line = scannerBook.nextLine();
				String[] data = line.split(";");
				
				String bookID = data[0].trim();
				String title = data[1].trim();
				String author = data[2].trim();
				String year = data[3].trim();
				
				Book book = new Book(bookID, title, author, year);
				bookList.add(book);
				aBook = book;
				System.out.println(book.toString());
			}
			aBook.setBookCount(incrementNextBookID());
			scannerBook.close();
        }     
        catch (IOException e) {
        	e.printStackTrace();
        }       
        System.out.printf("%n");
		return bookList;
	}

	/*
	P1001    Qiu
	P1002    Dennis
	P1003    Dennis Qiu
	P1004    Teddy
	P1005    Laptop
	P1006    QIU
	P1007    DENNIS
	P1008    DQIU
	P1009    LAPTOP
	P1010    TEDDY
	P1011    DENNIS
	 */
	/**
	 * This method reads out the data in this text file associated with patrons
	 * Should open this named file
	 * Read each line
	 * Parse into patron ID, name
	 * Create a corresponding Patron object
	 * Append to Array List
	 * @param filename the name of the text file associated with patrons being read
	 * @return Array List associated with patrons
	 */
	private ArrayList<Patron> readPatrons(String filename) {
        System.out.println("Reading file " + filename);
        try {    	
      		FileReader file = new FileReader(filename);
      		Scanner scannerPatron = new Scanner(file);
			
      		Patron aPatron = null;
			while (scannerPatron.hasNext()) {
				String line = scannerPatron.nextLine();
				String[] data = line.split("\\s+");
				
				String patronID = data[0].trim();
				String patronName = data[1].trim();
				
				Patron patron = new Patron(patronID, patronName);
				patronList.add(patron);
				aPatron = patron;
				System.out.println(patron.toString());
			}
			aPatron.setPatronCount(incrementNextPatronID());
			scannerPatron.close();
        }     
        catch (IOException e) {
        	e.printStackTrace();
        }       
        System.out.printf("%n");
		return patronList;
	}

	/*
	B101,P102,2018-02-15
	B102,P103,2018-01-06
	B103,P11,2018-03-19
	B135,P110,2018-01-03
	*/
	/**
	 * This method reads out the data in this text file associated with loans
	 * Should open this named file
	 * Read each line
	 * Parse into loan book ID, patron ID, due date
	 * Create a corresponding Loan object
	 * Append to Array List
	 * Records which book object (identified by its ID) is currently 
	 * borrowed by which patron object (identified by its ID) and
	 * the date when the book is due
	 * @param filename the name of the text file associated with loans being read
	 * @return Array List associated with loans
	 */
	private ArrayList<Loan> readLoans(String filename) {
		System.out.println("Reading file " + filename);
		try {
			FileReader file = new FileReader(filename);
			Scanner scannerLoan = new Scanner(file);

			while (scannerLoan.hasNext()) {
				String line = scannerLoan.nextLine();
				String[] data = line.split(",");
				
				String loanBookID = data[0].trim();
				String loanPatronID = data[1].trim();
				String loanDueDate = data[2].trim();
				
				//Strings
				/*Loan loan = new Loan(loanBookID, loanPatronID, loanDueDate);
				loanList.add(loan);
				System.out.println(loan.toString());*/
				
				//Abstract
				Book loanBook = null;
				Patron loanPatron = null;
				
				for (Book book: bookList) {
					if (book.getBookID().equals(loanBookID)) {
						loanBook = book;
					}
				}			
				for (Patron patron: patronList) {
					if (patron.getPatronID().equals(loanPatronID)) {
						loanPatron = patron;
					}
				}
				Loan loan = new Loan(loanBook, loanPatron, loanDueDate);
				loanPatron.checkOut(loanBook);
				loanList.add(loan);
				System.out.println(loan.toAbstract());
			}
			scannerLoan.close();

			//Strings
			/*for (Loan loanBook: loanList) {
				String loanBookID = loanBook.getLoanBookID();
				for (Book borrowedBook: bookList) {
					if (loanBookID.equals(borrowedBook.getBookID())) {
						borrowedBook.setBorrowerID(loanBook.getLoanPatronID());
					}
				}
			}*/
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
        System.out.printf("%n");
		return loanList;
	}

	//Strings
	/**
	 * This method generates the next available new unique book ID in the library
	 */
	/*private String generateNextBookID() {
        String nextBookID;    
        String bookID;
        String arrayBookID[];
        Integer lastBookID = 0;
        
        for (Book book: bookList) {
        	    bookID = book.getBookID();
        	    arrayBookID = bookID.split("B"); //B101: ["B", "101"]-->["", "101"]
        	    if ( Integer.valueOf(arrayBookID[1]) > lastBookID ) {
        	    	lastBookID = Integer.valueOf(arrayBookID[1]);
        	    }
        }
        nextBookID = "B" + String.valueOf(lastBookID + 1);
        System.out.println("Next available book ID is " + nextBookID);
        return nextBookID;      
	}*/
	
	// Abstract
	/**
	 * Finds the largest book ID and increments 
	 * This allows library to always expand 
	 * to include new books being added at any time whatsoever, even after saving
	 */
	private Integer incrementNextBookID() {
		String bookID;
		String arrayBookID[];
		Integer lastBookID = 0;
		for (Book book : bookList) {
			bookID = book.getBookID();
			arrayBookID = bookID.split("B"); // B101: ["B", "101"]-->["", "101"]
			if (Integer.valueOf(arrayBookID[1]) > lastBookID) {
				lastBookID = Integer.valueOf(arrayBookID[1]);
			}
		}
		return lastBookID + 1;
	}
	
	/**
	 * This method should prompt for author, title and year of publication of the book
	 * Adds a new book to the library's list of books 
	 * Book ID is automatically generated by Book constructor
	 */
	private void addBook() {
        System.out.println("Executing addBook");      
        Scanner scanner = new Scanner(System.in);        
        
        System.out.println("Enter the title of new book: ");
        String addTitle = scanner.nextLine();  
        
        System.out.println("Enter the author of new book: ");   
        String addAuthor = scanner.nextLine();  	

        System.out.println("Enter the year of publication of new book: ");     
        String addYear = scanner.nextLine();	    
        
        //Strings
       /* String generateNewBookID = generateNextBookID();  
        Book addNewBook = new Book(generateNewBookID, addTitle, addAuthor, addYear);*/
        
        //Abstract
        Book generateNewBookID = new Book();
        Book addNewBook = new Book(generateNewBookID.getBookID(), addTitle, addAuthor, addYear);
        bookList.add(addNewBook);
       
		System.out.println("New Book added: " + addNewBook.toString());
        System.out.printf("%n");
	}
	
	//Strings
	/**
	 * This method generates the next available new unique patron ID
	 */
	/*private String generateNextPatronID() {
        String nextPatronID;    
        String patronID;
        String arrayPatronID[];
        Integer lastPatronID = 0;
        
        for (Patron patron: patronList) {
        	    patronID = patron.getPatronID();
        	    arrayPatronID = patronID.split("P"); //P101: ["P", "101"]-->["", "101"]
        	    if ( Integer.valueOf(arrayPatronID[1]) > lastPatronID ) {
        	    	    lastPatronID = Integer.valueOf(arrayPatronID[1]);
        	    }
        }
        nextPatronID = "P" + String.valueOf(lastPatronID + 1);
        System.out.println("Next available patron ID is " + nextPatronID);
        return nextPatronID;      
	}*/
	
	// Abstract
	/**
	 * Finds the largest patron ID and increments 
	 * This allows library to always expand 
	 * to include new patrons being added at any time whatsoever, even after saving
	 */
	private Integer incrementNextPatronID() {
		String patronID;
		String arrayPatronID[];
		Integer lastPatronID = 0;
		for (Patron patron : patronList) {
			patronID = patron.getPatronID();
			arrayPatronID = patronID.split("P"); // P101: ["P", "101"]-->["", "101"]
			if (Integer.valueOf(arrayPatronID[1]) > lastPatronID) {
				lastPatronID = Integer.valueOf(arrayPatronID[1]);
			}
		}
		return lastPatronID + 1;
	}
    
	/**
	 * This method should prompt for the name of the patron
	 * Adds a new patron to the library's list of patrons
     * Patron ID is automatically generated by Patron constructor
	 */
	private void addPatron() {
        System.out.println("Executing addPatron");     
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of new Patron: ");
        String addPatron = scanner.nextLine();
        
        //Strings
        /*String generateNewPatronID = generateNextPatronID();  
        Patron addNewPatron = new Patron(generateNewPatronID, addPatron);*/
        
        //Abstract
        Patron generateNewPatronID = new Patron();
        Patron addNewPatron = new Patron(generateNewPatronID.getPatronID(), addPatron);
        patronList.add(addNewPatron);
        
		System.out.println("New Patron added: " + addNewPatron.toString());
		System.out.printf("%n");
	}
	
	/**
	 * This method should prompt for author name 
	 * List book ID, title, publication year of all books in the library 
	 * written by that author
	 */
	private void listByAuthor() {
        System.out.println("Executing listByAuthor");    
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an author's name: " );
        String authorName = scanner.nextLine();

        System.out.printf("%n");
        System.out.println("Books written by " + authorName + ":");
        
        for (Book book: bookList) {
        	if (book.getAuthor().equals(authorName)) {
        		System.out.println(book.printListByAuthor());
        	}
        } 
        System.out.printf("%n");
  	}
	
	/**
	 * This method should prompt for minimum year and maximum year
	 * List book ID, title, author for all books in the library 
	 * published during that period
	 */
	private void listByYear() {
		System.out.println("Executing listByYear");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter minimum year: ");
		String minYear = scanner.nextLine();

		System.out.println("Enter maximum year: ");
		String maxYear = scanner.nextLine();

		System.out.printf("%n");
		System.out.println("Books published between year " + minYear 
				+ " to year " + maxYear + ":");
		
		for (Book book: bookList) {
			String publishedYear = book.getYear();
			if ((Integer.valueOf(publishedYear) >= Integer.valueOf(minYear)
					&& Integer.valueOf(publishedYear) <= Integer.valueOf(maxYear))) {
				System.out.println(book.printListByYear());
			}
		}
		System.out.printf("%n");
	}

	/**
	 * This method locates the book borrowed by its patron
	 * @param bookID is the unique identifier of each book
	 * @return true if successful, false if action fails
	 */
	private boolean locateBook(String bookID) {
        System.out.println("Locating book with ID = " + bookID);
        
        for (Book loanBookID: bookList) {
        	if (loanBookID.getBookID().equals(bookID)) {
        		return true;
        	}
        }
        return false;
	}
	
	/**
	 * This method should prompt for a book ID
	 * If the book is currently checked out,
	 * Show the name of the patron who currently has the book
	 */
	private void showBorrowers() {
        System.out.println("Executing showBorrowers");       
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter book ID: ");
        String bookID = scanner.nextLine();
        
		System.out.printf("%n");
        if (!locateBook(bookID)) {
        	System.out.println("No book found with ID " + bookID);
        	System.out.printf("%n");
        	return;
        }   
        
        //Strings
		/*for (Book book: bookList) {
			if (book.getBookID().equals(bookID)) {
				String borrowerID = book.getBorrowerID();
				if (borrowerID.equals("")) {
					System.out.println("This book with ID " + bookID 
							+ " is currently not checked out");
				} 
				else {
					for (Patron patron: patronList) {
						if (patron.getPatronID().equals(borrowerID)) {
							System.out.println(patron.getPatronName() 
									+ " currently owns this borrowed book with its given ID " 
									+ bookID);
						}
					}
				}
			}
		}*/
        
        //Abstract
		String patron = "";
		for (Loan loan : loanList) {
			if (loan.getABook().getBookID().equals(bookID)) {
				
				System.out.printf("%n");
				System.out.println("Found loan entry matching the bookID " + bookID);
				patron = loan.getAPatron().getPatronName();
				System.out.println(patron + " currently owns this borrowed book with its given ID " 
				+ bookID);
			}
		}
		if (patron == "") {
			System.out.println("This book is currently not checked out");
		}
    	System.out.printf("%n");
	}
	
	/**
	 * This method locates the patron who has the borrowed book
	 * @param patronID is the unique identifier of each patron
	 * @return true if successful, false if action fails
	 */
	private boolean locatePatron(String patronID) {
        System.out.println("Locating patron with ID = "+ patronID);
        for (Patron loanPatronID: patronList) {
        	if (loanPatronID.getPatronID().equals(patronID)) {
        		return true;
        	}
        }
        return false;
	}
	
	/**
	 * This method should prompt for a patron ID
	 * List bookID, title, author, publication year for all the books 
     * currently borrowed by that patron
	 */
	private void showBorrowedBooks() {
        System.out.println("Executing showBorrowedBooks");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter patron ID: ");
        String patronID = scanner.nextLine();
       
		System.out.printf("%n");
        if (!locatePatron(patronID)) {
        	System.out.println("No patron found with ID " + patronID);
        	System.out.printf("%n");
        	return;
        }       
    	System.out.printf("%n");
		System.out.println("This patron with given ID " + patronID
				+ " currently owns these borrowed books:");

		//Strings
        /*for (Loan loan: loanList) {
			if (loan.getLoanPatronID().equals(patronID)) {
				String borrowedBookID = loan.getLoanBookID();
				for (Book book: bookList) {
					if (book.getBookID().equals(borrowedBookID)) {
						System.out.println(book.toString());
					}
				}
			}
		}*/
		
		//Abstract
		Patron patronObject = null;
		for (Patron patron: patronList) {
			if (patron.getPatronID().equals(patronID)) {
				patronObject = patron;
			}
		}
		for (Loan loan: loanList) {
			if (loan.getAPatron().equals(patronObject)) {
				System.out.println(loan.getABook().toString());
			}
		}
		System.out.printf("%n");
	}

	/**
	 * This method should allow a book that is currently checked out 
	 * to be returned in the manner described below:
     * Prompt for book ID
     * Use this book ID to find the book that the patron wishes to return
     * If the book is checked out, return the book
     * The book should no longer be shown as being checked out to the borrower
	 */
    private void returnBook() {
		System.out.println("Executing returnBook");		
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter book ID: ");
        String bookID = scanner.nextLine();
        
        System.out.printf("%n");
		if (!locateBook(bookID)) {
			System.out.println("No book found with ID " + bookID);
        	System.out.printf("%n");
			return;
		}
		
		//Strings
		/*for (Book book : bookList) {
			if (book.getBookID().equals(bookID)) {
				String borrower = book.getBorrowerID();
				if (borrower.equals("")) {
					System.out.println("This book with ID " + bookID 
							+ " is currently not checked out");
					return;
				} 
				else {
					book.setBorrowerID("");
					System.out.println("This book with ID " + bookID + " is now returned");
				}
			}
		}
		System.out.printf("%n");

		Loan removeLoanEntry = null;
		for (Loan loan: loanList) {
			if (loan.getLoanBookID().equals(bookID)) {
				removeLoanEntry = loan;
			}
		}
		loanList.remove(removeLoanEntry);*/
		
		//Abstract
		Loan removeLoanEntry = null;
		for (Book book: bookList) {
			if (book.getBookID().equals(bookID)) {
				for (Loan loan: loanList) {
					if (loan.getABook().equals(book)) {
						removeLoanEntry = loan;					
					}
				}
			}
		}
		if (removeLoanEntry != null) {
			loanList.remove(removeLoanEntry);
			System.out.print("Book with ID " + bookID + " is now returned");
			System.out.printf("%n");
		} 
		else {
			System.out.print("Book with ID " + bookID + " is currently not checked out");
			System.out.printf("%n");
		}
		System.out.printf("%n");
	}

    /**
     * This method saves the books to the text file associated with books
     * @param filename the name of the text file associated with books being written to
     */
	private void saveBooks(String filename) {
		System.out.println("Saving books to file " + filename);
		try {
			FileWriter file = new FileWriter(filename);
			System.out.println("Total book objects: " + bookList.size());
			System.out.printf("%n");
			
			for (Book book : bookList) {
				String line = book.toString().replaceAll("[|]", "	;	");
				file.write(line + "\n");
			}
			file.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method saves the patrons to the text file associated with patrons
	 * @param filename the name of the text file associated with patrons being written to
	 */
	private void savePatrons(String filename) {
		System.out.println("Saving patrons to file " + filename);
		try {
			FileWriter file = new FileWriter(filename);
			System.out.println("Total patron objects: " + patronList.size());
			System.out.printf("%n");

			for (Patron patron: patronList) {
				String line = patron.toString().replaceAll("[-]", "  ");
				file.write(line + "\n");
			}
			file.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method saves the loans to the text file associated with loans
	 * @param filename the name of the text file associated with loans being written to
	 */
	private void saveLoans(String filename) {
		System.out.println("Saving loans to file " + filename);
		try {
			FileWriter file = new FileWriter(filename);
			System.out.println("Total loan objects: " + loanList.size());
			System.out.printf("%n");

			for (Loan loan : loanList) {
				String line = loan.toAbstract().replaceAll("[|]", ",");
				file.write(line + "\n");
			}
			file.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method calls the save methods above 
	 * Should save each collection to each corresponding text file, i.e.
	 * Saved books to books.txt, Saved patrons to patrons.txt, Saved loans to loans.txt
	 */
	private void saveLibrary() {
		saveBooks("Resources/books.txt");
		savePatrons("Resources/patrons.txt");
		saveLoans("Resources/loans.txt");
		
		System.out.println("Saved library of books to books.txt");
		System.out.println("Saved library of patrons to patrons.txt");
		System.out.println("Saved library of loans to loans.txt");
	}
	
	/**
	 * Exit the system 
	 * Saves the current state of the library, i.e. patrons, books, and loans, 
	 * to the corresponding files: books.txt, patrons.txt, and loans.txt
	 */
	private void exitProgram() {
		System.out.println("Saving data before exiting...");
		System.out.printf("%n");
		
		saveLibrary();
    	System.out.printf("%n");

		System.out.println("Exiting...");
		System.exit(0);
	}
}