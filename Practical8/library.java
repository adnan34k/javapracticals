import java.util.Scanner;
import java.util.ArrayList;

class Book{
    private String name;
    private String author;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
}

class Library{
    static ArrayList<Book> booklist = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println("Welcome To Library");
        System.out.println("Please Select the option");
        System.out.println("1.Borrow book\n2.Return book\n3.Add new book in library\n4.Exit");

        Scanner s1 = new Scanner(System.in);
        int i;

        do {
            i = s1.nextInt();
            s1.nextLine(); // Consume newline character
            switch (i) {
                case 1:
                    borrow.borrowBook();
                    break;
                case 2:
                    User.returnBook();
                    break;
                case 3:
                    addBook.add();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select correct option");
                    break;
            }
        } while (i != 4);

        s1.close();
    }
}

class User{
    public static void returnBook(){
        // Add logic for returning book
    }
}

class borrow extends User{
    public static void borrowBook(){
        Scanner s2 = new Scanner(System.in);
        System.out.println("Search Book name");
        String name = s2.nextLine();

        if (searchBook(name)){
            System.out.println("Book is found in Library");
        } else{
            System.out.println("Book is not found in library");
        }
        System.out.println("1.Students\n2.Faculty");
        int i = s2.nextInt();
        if(i==1){
        	System.out.println("Enter Registration number");
        	String regno = s2.nextLine();
        }
        else if(i==2){
        	System.out.println("Enter name of faulty");
        	String naam = s2.nextLine();
        	System.out.println("enter branch of branch of faculty");
        	String branch = s2.nextLine();
        }
    }
    

    public static boolean searchBook(String name){
        for (Book n : Library.booklist) {
            if (name.equalsIgnoreCase(n.getName())){
                return true;
            }
        }
        return false;
    }
}

class addBook extends User{
    public static void add(){
        Scanner s3 = new Scanner(System.in);
        System.out.println("Enter the name of the book:");
        String name = s3.nextLine();
        System.out.println("Enter the author of the book:");
        String author = s3.nextLine();
        Library.booklist.add(new Book(name, author));
        System.out.println("Book added successfully!");
    }
}



/* Algorithm 
	Library Management system
	book borrowers - Student or faculty or stafff
	enter name reg no branch courxe( btech or mtech)
	email id
	
	
	notify in 15 days after borrowing
	
	ask issued by 
	
	
	
	available books name 
	check before issuing if book exists or not
	quantity of books sppecify
	name of book with author name and with publication house
	
	
	to notify in 15 days keep history of nameof the book and date of issuing 
	
	Using switch case
	*/
