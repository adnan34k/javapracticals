public class sample{
	public static void main(String[] args){
		String a1 = "ABCD6";
		String a2 = "defg9";
		System.out.println("1 "+a1.toLowerCase());
		System.out.println("2 "+a2.toUpperCase());
		
		System.out.println("3 "+Character.isLowerCase(a2.charAt(0)));
		System.out.println("4 "+Character.isUpperCase(a1.charAt(0)));
		
		System.out.println("5 "+Character.isLetter(a1.charAt(2)));
		System.out.println("5 "+Character.isDigit(a2.charAt(4)));
		
		System.out.println(Character.isLetterOrDigit(a1.charAt(4)));
		
		System.out.println("6 "+a1.concat(a2));
		System.out.println("7 "+a2.length());
		
		String c = "   SGGS    ";
		String d = " ";
		System.out.println("8 "+c.trim());
		
		System.out.println("9 "+d.isEmpty());
		
		System.out.println("10 "+a2.charAt(1));
		System.out.println("11 "+a2.indexOf('f'));
		
		System.out.println("12 "+a1.equals(a2));
		System.out.println("13 "+a1.replace('A','R'));
		
		}
	}
