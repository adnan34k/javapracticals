import java.util.Random;

class checkSequence{
           public static void main(String [] args){
           
           //2022bit055 ,2022bcs432,2022bch123,2022bme321 valid formats
           //years from 2000 to 2024 are valid
           String registrationNumber;
           double []timeRequired1 = new double[10];
           double []timeRequired2 = new double[10];
           double []timeRequired3 = new double[10];
             
		String[] s = new String[20000];
		//Generating registration numbers
		for(int i=0;i<20000;i++){
			registrationNumber = generateRegistrationNumber();
			s[i] = registrationNumber;
		}
		
		int j=0;
		while(j<10){
		double startTime = System.nanoTime();
           
           	int final_result = getValidRegistrationsCount1(s);
          	 timeRequired1[j] = System.nanoTime() - startTime;
         	//  System.out.println("time taken "+ timeRequired);
         	// System.out.println("count of valid registration numbers "+final_result);
           	//currentTimeMillis();
          	 j++;
           	}
           
           	j=0;
		while(j<10){
		double startTime = System.nanoTime();
           	int final_result = getValidRegistrationsCount2(s);
           	timeRequired2[j] = System.nanoTime() - startTime;
         	j++;
           	}
           
           	j=0;
		while(j<10){
		double startTime = System.nanoTime();
           	int final_result = getValidRegistrationsCount3(s);
           	timeRequired3[j] = System.nanoTime() - startTime;
           	j++;
           	}
           	
           double Time1 = avgTime(timeRequired1);
           double Time2 = avgTime(timeRequired2);
           double Time3 = avgTime(timeRequired3);
           System.out.println("time for method1 "+Time1);
           System.out.println("time for method2 "+Time2);
           System.out.println("time for method3 "+Time3);
           
}
           public static double avgTime(double []Time)
           {
           	int size = Time.length;
           	long sum = 0;
           	for(int i=0;i<size;i++)
           	{
           		sum +=Time[i];
           	}
           	double avgtime = sum/size;
           	return avgtime;
           }
           
           public static int getValidRegistrationsCount1(String s[]){
           		int count = 0;
           
           		for(int i=0;i<s.length;i++){
           			if(s[i].length() > 0 &&s[i].length()<=11){
           			
           
           					if(isvalidSequence1(s[i])){
           					count++;
           					}
           				
           			}
           		}
           			return count;
           } 
           public static int getValidRegistrationsCount2(String s[]){
           		int count = 0;
           
           		for(int i=0;i<s.length;i++){
           			if(s[i].length() > 0 &&s[i].length()<=11){
           			
           				
           					if(isvalidSequence2(s[i])){
           					count++;
           					}
           				
           			}
           		}
           			return count;
           }
           public static int getValidRegistrationsCount3(String s[]){
           		int count = 0;
           
           		for(int i=0;i<s.length;i++){
           			if(s[i].length() > 0 &&s[i].length()<=11){
           			
           				
           					if(isvalidSequence3(s[i])){
           					count++;
           					}
           				
           			}
           		}
           			return count;
           }
           
           //method 1
          public static boolean isvalidSequence1(String G){              
    		int b = Integer.parseInt(G.substring(7, 10));
    		
    		return (b > 0 && b <= 50);
		}
	   
	   // method 2	
	   public static boolean isvalidSequence2(String G){
    		int b = (G.charAt(7) - '0') * 100 + (G.charAt(8) - '0') * 10 + (G.charAt(9) - '0');
    		return (b > 0 && b <= 50);
	   } 
	
	//method 3
	   public static boolean isvalidSequence3(String G) {
   		 int b = 0;
   		 for (int i = 7; i <= 9; i++) {
    		 char digit = G.charAt(i);
	        if (digit < '0' || digit > '9') {
	            // If the character is not a digit, the sequence is invalid
	            return false;
 	       }
	        b = b * 10 + (digit - '0');
		    }
		    return (b >= 0 && b <= 50);
		} 

	
	
           //check if the branch name is valid
            
            //GENERATING REGISTRATION NUMBER
            private static final Random random = new Random();

    public static String generateRegistrationNumber(){
        // Generate random year between 2000 and 2024
        int year = random.nextInt(25) + 2000;
        
        // Generate random letters
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            letters.append(letter);
        }
        
        // Generate random digits
        int digits = random.nextInt(1000);
        
        // Format the registration number
        return String.format("%04d%s%03d", year, letters.toString(), digits);
        
    }
      }
      

           
           
           
           
