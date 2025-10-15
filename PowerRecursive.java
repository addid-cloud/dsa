public class PowerRecursive {

    public static int power(int base, int exponent) {
        if (exponent == 0) { 
            return 1; 
        } else if (exponent % 2 == 0) { 
            return power(base * base, exponent / 2);
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 5;

        int result = power(base, exponent);
        System.out.println(base + "^" + exponent + " = " + result);

        System.out.println("3^4 = " + power(3, 4));
        System.out.println("5^0 = " + power(5, 0));
        System.out.println("7^2 = " + power(7, 2));
    }
}
