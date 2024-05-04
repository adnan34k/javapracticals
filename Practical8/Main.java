import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.InputMismatchException;

class InvalidQuantityException extends Exception{
	public InvalidQuantityException(String message){
		super(message);
	}
}

class BookNotFoundException extends Exception{
	public BookNotFoundException(String message){
		super(message);
	}
}

class UserNotFoundException extends Exception{
	public UserNotFoundException(String message){
		super(message);
	}
}
interface LibraryOperations{
	void addBook(ArrayList<Book> library);
	void borrowBook(ArrayList<Book> library);
	void returnBook(ArrayList<Book> library);
	void deleteBook(ArrayList<Book> library);
	void seeAllBooks(ArrayList<Book> library);
}
interface UserOperations{
	void EnterUserInfo();
	void displayUserInfo();
}
class Library implements LibraryOperations{
	ArrayList<Book> library = new ArrayList<>();
	Map<String,User> users = new HashMap<>();
	Scanner sc= new Scanner(System.in);
	public void addBook(ArrayList<Book> library){
	
		try{
		System.out.println("\nAdd new book enter book details");
		System.out.println("Enter Book name");
		String bookName = sc.nextLine();
		System.out.println("Enter Author name");
		String authorName = sc.nextLine();
		System.out.println("Enter Quantity");
		int quantity = sc.nextInt();
		sc.nextLine();      //consume newline
		if(quantity<=0){
			throw new InvalidQuantityException("quantity of books must be greater than 0");
		}
		
		for(int i=0;i<quantity;i++){
		Book book = new Book(bookName,authorName,quantity);
		library.add(book);//in the arraylist library adding the object of the book
		} 
		System.out.println("Books added successfully\n");
		}
		catch(InvalidQuantityException e){
			System.out.println(e.getMessage());   //if the 	quantity is less than 1;
		}
		
	}
	public void deleteBook(ArrayList<Book> library){
		
		try{
		System.out.println("\nDelete a book enter book details");
		System.out.println("Enter book name");
		String bookname = sc.nextLine();
		boolean bookFound = false;
		for(int i=0;i<library.size();i++)
		{
			if(library.get(i).bookName.equalsIgnoreCase(bookname)) //retrieves the bookName in the object and compares with provided bookname
			{
				library.remove(i);
				bookFound = true;
				System.out.println("Book deleted successfully\n");
				break;
			}
		}
		if(bookFound==false){
			throw new BookNotFoundException("book is not found in library\n");
		}
		}
		catch(BookNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	public void borrowBook(ArrayList<Book> library){
	
		try{
		System.out.println("\nEnter the name of book to be borrowed");
		String bookName = sc.nextLine();
		boolean bookFound = false;
		for(Book book: library){
			if(book.bookName.equalsIgnoreCase(bookName) && book.quantity>0){
				if(book.quantity>0){
				book.quantity--;
				
				
				System.out.println("Enter your registration number");
				String regNo = sc.nextLine();
				User user = users.get(regNo);
				if(user==null){
					user = new User();
					users.put(regNo,user);
				}
				user.borrowedBooks.add(book);
				
				bookFound = true;
				System.out.println("Book "+bookName +" borrowed successfully\n");
				return;
				
				}	
			}
			else{
				System.out.println("No copies are available of the book "+bookName);
				return;
			}
		}
		if(bookFound == false){
			throw new BookNotFoundException("Book "+bookName +" is not available\n");
		}
		}
		catch(BookNotFoundException e){
			System.out.println(e.getMessage());
		}
		
	}
	public void returnBook(ArrayList<Book> library){
		
		try{
		System.out.println("\nEnter registration number");
		String regNo = sc.nextLine();
		User user = users.get(regNo);
		if (user == null){
        		throw new UserNotFoundException("User not found.\n");
    		}
    
		System.out.println("Enter the name of book to be returned");
		String bookName = sc.nextLine();
		
		Book bookToRemove = null;
		for(Book borrowedBook: user.borrowedBooks){
			if(borrowedBook.bookName.equalsIgnoreCase(bookName)){
				bookToRemove = borrowedBook;
				break;
			}
		}
		
		if(bookToRemove == null){
			System.out.println("Book "+bookName+" is not borrowed by this user\n");
			return;
		}
		user.borrowedBooks.remove(bookToRemove);
		boolean bookFound = false;
		for(Book book: library){
			if(book.bookName.equalsIgnoreCase(bookName) && book.quantity>=0){
				book.quantity++;
				bookFound = true;
				System.out.println("Book "+bookName +" returned successfully\n");
				return;
			}
		}
		if(bookFound == false){
			throw new BookNotFoundException("Book "+bookName +" is not found in library\n");
		}
		}
		catch(BookNotFoundException | UserNotFoundException e){
			System.out.println(e.getMessage());
		}
		
	}
	public void seeAllBooks(ArrayList<Book> library){
		
		try{
		if(library.size()==0){	
			System.out.println("library is empty\n");
			return;
		}
		for(int i=0;i<library.size();i++){
			System.out.println(library.get(i).bookName);
		}
		System.out.println();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
public class Main{
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		try{
		Library lib = new Library(); 
		while(true){
		System.out.println("1.Borrow a book\n2.Return a book\n3.Add a new book to library\n4.Delete a book from library\n5.See all available books\n6.Exit\n");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1:lib.borrowBook(lib.library);
				break;
			case 2:lib.returnBook(lib.library);
				break;
			case 3:lib.addBook(lib.library);
				break;
			case 4:lib.deleteBook(lib.library);
				break;	
			case 5:lib.seeAllBooks(lib.library);
				break;
			case 6:	sc.close();
				System.exit(0);
				break;
			default:System.out.println("choose correct option\n");
				break;
		}
		}
		
	}
	
	catch(InputMismatchException e){
		System.out.println("please press the valid key");
	}
	finally{
		sc.close();
	}
	}
}
class User{
	String userRegnum;

	public void getRegno(String regNum){
		this.userRegnum = regNum;
	}
	ArrayList<Book> borrowedBooks = new ArrayList<>();
	
}
class Book{
	
	String bookName;
	String authorName;
	int quantity;
	Book(String bookName,String authorName,int quantity){
		this.bookName = bookName;
		this.authorName = authorName;
		this.quantity = quantity;
	}
	
}

