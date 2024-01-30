public class calculator{
    public static void main(String[] args){
        
        double a = 90;
        double b = 45;
	double result;

        result = add(a, b);
        System.out.println("addition " + result);

        result = subtract(a, b);
        System.out.println("subtraction " + result);

        result = multiply(a, b);
        System.out.println("multiplication " + result);

        result = divide(a, b);
        System.out.println("division " + result);

        result = modulus(a, b);
        System.out.println("modulus " + result);

        result = squareroot(a);
        System.out.println("square root of a " + result);

        result = power(a, b);
        System.out.println("power " + result);

        int num = 5;
        result = factorial(num);
        System.out.println("factorial of " + num + "is " + result);
    }

    public static double add(double num1, double num2){
        return num1 + num2;
    }

    public static double subtract(double num1, double num2){
        return num1 - num2;
    }

    public static double multiply(double num1, double num2){
        return num1 * num2;
    }

    public static double divide(double num1, double num2){
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("cannot divide by zero.");
            return 0;
        }
    }

    public static double modulus(double num1, double num2){
        if (num2 != 0) {
            return num1 % num2;
        } else {
            System.out.println("Cannot calculate modulus with zero divisor.");
            return 0;
        }
    }

    public static double squareroot(double num){
        if (num >= 0) {
            return Math.sqrt(num);
        } else {
            System.out.println("Cannot calculate square root of a negative number.");
            return 0;
        }
    }

    public static double power(double base, double exponent){
        return Math.pow(base, exponent);
    }

    public static double factorial(int n){
          if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return 0;
            }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

