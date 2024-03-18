class Main{
	public static void main(String[] args){
		double a = 3;
		double b = 2;
		long c = 10;
		//add(a,b);
		//sub(a,b);
		//mul(a,b);
		div(a,b);
		mod(a,b);
		power(a,b);
		log(10,10);
		findNthRoot(9,3);
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
		for(int i=1;i<=exponent;i++){
		base= base*base;
		}
		return base;
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
	 public static double findNthRoot(double number, int n) {
        double start = 0;
        double end = number;

        // Define precision to control the accuracy of the result
        double precision = 0.000001; 

        // If the number is negative and n is even, nth root is undefined
        if (number < 0 && n % 2 == 0) {
            return Double.NaN;
        }

        double mid;
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
}
