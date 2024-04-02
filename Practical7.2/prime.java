public class prime{
	public static void main(String [] args){
		  
		long  []arr = new long[1000000];	//array is declared here
		long[] count2 = new long[2];
		long[] count1 = new long[2];		
		int iterator = 0;
		while(iterator<30){
			arr[iterator] = give7digits();
			iterator++;
		}
		
		int h = 0;
		long Time2 = 0;
		long Time1 = 0;
		while(h<4){   //4 times output 
		//8 statements
		
		long initialTime1 = System.nanoTime();
		
		count1 = checkPrime1(arr);
		long finalTime1 = System.nanoTime();
		Time1 = finalTime1 - initialTime1;
		
		long initialTime2 = System.nanoTime();
		
		count2 = checkPrime2(arr);
		long finalTime2 = System.nanoTime();
		Time2 = finalTime2 - initialTime2;
		System.out.println("In method 1 "+"prime numbers are " +count1[0]+"  non-prime numbers are "+count1[1] +"  time taken  "+Time1);
		System.out.println("In method 2 "+"prime numbers are " +count2[0]+"  non-prime numbers are "+count2[1] +"  time taken  "+Time2);
		
		h++;
		}
				
	}
	
	public static long give7digits(){
		int x = 0;
		StringBuilder nums = new StringBuilder(); 
		while(x<7){
		    long y = (System.nanoTime()%9)+1;
		    nums.append(y);
		    x++;
		}
		long num = Long.parseLong(nums.toString());
		return num;
	}
		
	
	public static long[] checkPrime1(long []arr){
			boolean flag = true;
			long[] counts = new long[2];
			//we have to find prime numbers in the array
			for(int i=0;i<arr.length;i++){
				flag = true;
				for(int j=2;j<=(arr[i])/2;j++){ //math. no use 
					if(arr[i]%j== 0){
						flag = 	false;
					}
					
				}
				if(flag==false){
				counts[1]++;
				}
				else{
				counts[0]++;
				}
			}
			return counts;
		}
		
		public static long[] checkPrime2(long []arr){
			boolean flag = false;
			long[] counts = new long[2];
			//we have to find prime numbers in the array
			for(int i=0;i<arr.length;i++){
				flag = false;
				for(int j=2;j<=(arr[i])/2;j++){
					if(arr[i]%j== 0){
						flag = 	true;
					}
					
				}
				if(flag!=false){
				counts[1]++;
				}
				else{
				counts[0]++;
				}
			}
			return counts;
		}
		
		
	

}
