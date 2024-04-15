import java.util.InputMismatchException;
class Main{
	public static void main(String[] args){
		
		double a = 3;
		double b = 2;
		long c = 10;
		//System.out.println(add(a,b));
		//System.out.println(sub(a,b));
		//System.out.println(mul(a,b));
		//System.out.println(div(a,b));
		//System.out.println(mod(a,b));
		//System.out.println(power(2,3));
		//System.out.println(log(10,10));
		//System.out.println(findNthRoot(9,2));
		int n=3,r=3;
		//System.out.println(factorial(n));
		System.out.println(nCr(n,r));
		System.out.println(nPr(n,r));
		
		//System.out.println(exponentOfTen(-1));
		//complexNumber num1 = new complexNumber(5,7); 
		//num1.show();
		//omplexNumber num2 = new complexNumber(3,14);
		//num2.show();
		//complexNumber ans = num1.add2(num2);
		//ans.show();
	}
	public static double add(double a , double b){
		return a+b;
	}
	public static double sub(double a , double b){
		return a-b;
	}
	public static double mul(double a , double b){
		return a*b;
	}
	public static double div(double a , double b){
		try{if(b!=0){
		return a/b;
		}
		else{
			throw new ArithmeticException("division by zero");
		}
		}
		catch(ArithmeticException e){
			return Double.NaN;
		}
		
	}
	public static double mod(double a , double b){
	try{
		if(b!=0){
		return a%b;
		}
		else{
			throw new ArithmeticException("division by zero");
		}
		}
		catch(ArithmeticException e){
			System.out.println("Error: "+e.getMessage());
			return Double.NaN;
		}
		
	}
	public static double power(double base , long exponent){
		try{
		if(base==0 && exponent==0){
			throw new ArithmeticException("0^0");
		}
		if(exponent==0)return 1;
		if(exponent<0) return (1/power(base,-1*exponent));
		double temp = power(base,exponent/2);
		if(exponent%2!=0) return temp*temp*base;
		return temp*temp;
		}
		catch(ArithmeticException e){
		System.out.println("Error: " + e.getMessage());
        	return Double.NaN; 
		}
	}
	public static double log(double base ,long exponent){
		double result = 0;
		double curvalue= base;
		while(curvalue<=exponent)
		{
			curvalue *= base;
			result++; 
		}
		return result;
	}
	 public static float findNthRoot(float number, int n) {
        	float start = 0;
        	float end = number;

        	// Define precision to control the accuracy of the result
        	double precision = 0.000001; 
		try{
        		// If the number is negative and n is even, nth root is undefined
        		if (number < 0 && n % 2 == 0) {
            			throw new ArithmeticException("number cannot be negative");
        		}

        		float mid;
        		while (true) {
           			mid = (start + end) / 2;

            		// If the difference between the current midpoint and the actual result
            		// is within the desired precision, return the result
            		if (Math.abs(Math.pow(mid, n) - number) < precision) {
                		return mid;
            		}

            		// If the nth power of the midpoint is greater than the number, adjust end
            		// Otherwise, adjust start
            		if (Math.pow(mid, n) > number) {
                		end = mid;
            		} else {
                		start = mid;
            		}
            		}
        	}
        	catch(ArithmeticException e){
        		System.out.println("Error: "+e.getMessage());
        		return Float.NaN;
        	}
    }
    	public static int factorial(int n)
    	{	
    		try{
    		if(n<0){
    			throw new ArithmeticException("number cannot be negative");
    		}
    		else if(n==0 || n==1)
    		{
    			return 1;
    		}
    		else{
    		 return factorial(n-1)*n;
    		}
    		}
    		catch(ArithmeticException e){
    			System.out.println("error: "+e.getMessage());
    			return -1;
    		}
    	}
    	public static double nCr(int n, int r)
    	{	try{
    		if(r>n){
    			throw new ArithmeticException("selected elements cannot be more than total elements");
    		}
    		if(n==r ||r==0) return 1;
    		else{
    			return nCr(n-1 , r-1)+nCr(n-1,r); //using Recursion
    		}
    		}
    		catch(ArithmeticException e){
    			System.out.println("error: "+e.getMessage());
    			return -1;
    		}
    	}
    	public static double nPr(int n, int r)
    	{	try{
    		if(r>n){
    			throw new ArithmeticException("selected elements cannot be more than total elements");
    		}
    		if(n==r ||r==0) return 1;
    		int t1 = factorial(n);
    		int t2 = factorial(r);
    		return t1/t2;
    		}
    		catch(ArithmeticException e){
    			System.out.println("error: "+e.getMessage());
    			return -1;
    		}
    	}
    	public static double exponentOfTen(int n)
    	{	
  		if(n==0) return 1;
    		double result = 1;
    		int i = 1;
    		if(n>0){
    		while(i<=n)
    		{
    			result = result*10;
    			i++;
    		}
    		return result;
    		}
    		if(n<0){
    		i = -1;
    			while(i>=n)
    			{
    			result = result/10;
    			i--;
    			}	
    			return result;
    		}
    		return 0;
    	}
    	
}
class complexNumber{
	private int real;
	private int imag;
	
	complexNumber(int real, int imag)
	{
		this.real = real;
		this.imag = imag;
	}
	public void show()
	{
		System.out.println(this.real+"+i"+this.imag);
	}
	public complexNumber add2(complexNumber n2)
	{
		complexNumber res = new complexNumber(0,0);
		res.real = this.real+n2.real;
		res.imag = this.imag+n2.imag;
		return res;
	}
}
