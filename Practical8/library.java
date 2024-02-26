import java.util.Scanner;
import java.util.ArrayList;
class Library{
	static ArrayList<String> booklist = new ArrayList<String>(); 
	public static void main(String[] args){
		
		System.out.println("Welcome To Library");
		System.out.println("Please Select the option");
		System.out.println("1.Borrow book\n2.Return book\n3.Add new book in library\n4.Exit");
		int i;
		Scanner s1 = new Scanner(System.in);
		do{
		
		i = s1.nextInt();
		switch(i){
		case 1:User.borrow();
			break;
		case 2:User.returnbook();
			break;
		case 3:addbook.add();
			break;
		case 4: System.exit(1);
			break;
		default:System.out.println("please select correct option");
			break;	
			
		}
		}while(i!=4);
		s1.close();
		
}
		
}
class User {
    	public static void borrow() {
        	System.out.println("write book name");
        	Scanner s2 = new Scanner(System.in);
        	String j = s2.nextLine();
        	
        	if(addbook.searchbook(j)){
        		System.out.println("book is  available");
        	}
        	else{
        		System.out.println("book is not available");
        	}
		s2.close();
        	// Add logic for borrowing book
        		
    		}
    		

    		public static void returnbook() {
        	// Add logic for returning book
        	
    		}
}
class addbook extends User{
    		public static void add() {
        	Library.booklist.add("java");
        	Library.booklist.add("Probability and Statistics");
        	System.out.println("Books added successfully");
    		}
    		
    		public static boolean searchbook(String name){
    			boolean flag = false;
    			int i=0;
    			for(String book: Library.booklist){
    				if(name.equals(book)){
    					return true;
    				}
    				i++;
    			}
    			return false;
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
