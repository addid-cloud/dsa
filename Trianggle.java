public class Trianggle {
    public static int triangleIter(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    public static int triangleRecur(int n) {
        return n + triangleRecur(n - 1);
    }

    public static int factorialIter(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecur(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecur(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Faktorial dari " + n + " (Iterasi): " + factorialIter(n));
        System.out.println("Faktorial dari " + n + " (Rekursi): " + factorialRecur(n));
    }
}
