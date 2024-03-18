class Main{
	public static void main(String[] args){
		double a = 3;
		double b = 2;
		long c = 10;
		System.out.println(add(a,b));
		System.out.println(sub(a,b));
		System.out.println(mul(a,b));
		System.out.println(div(a,b));
		System.out.println(mod(a,b));
		System.out.println(power(a,b));
		System.out.println(log(10,10));
		System.out.println(findNthRoot(9,2));
		int n=3,r=3;
		System.out.println(factorial(n));
		System.out.println(nCr(n,r));
		System.out.println(nPr(n,r));
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
		if(b!=0){
		return a/b;
		}
		else{
			System.out.println("invalid");
		}
		return 0;
	}
	public static double mod(double a , double b){
		return a%b;
	}
	public static double power(double base , double exponent){
		double result = 1;
		for(int i=0;i<exponent;i++){
		result= result*base;
		}
		return result;
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

        // If the number is negative and n is even, nth root is undefined
        if (number < 0 && n % 2 == 0) {
            return Float.NaN;
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
    	public static int factorial(int n)
    	{
    		if(n<0){
    			System.err.println("error factorial of negative numbers is not defined");
    			return -1;
    		}
    		else if(n==0 || n==1)
    		{
    			return 1;
    		}
    		else{
    		 return factorial(n-1)*n;
    		}
    	}
    	public static double nCr(int n, int r)
    	{	if(r>n) return -1;
    		if(n==r ||r==0) return 1;
    		else{
    			return nCr(n-1 , r-1)+nCr(n-1,r); //using Recursion
    		}
    	}
    	public static double nPr(int n, int r)
    	{	if(r>n) return -1;
    		if(n==r ||r==0) return 1;
    		int t1 = factorial(n);
    		int t2 = factorial(r);
    		return t1/t2;
    	}
    	
}
