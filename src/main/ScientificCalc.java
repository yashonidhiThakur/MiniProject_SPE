import java.util.Scanner;
import java.lang.Math;

public class ScientificCalc {

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0) return 0; // Error case
        if (x == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    public double naturalLog(double x) {
        return Math.log(x);
    }

    public double power(double x, double b) {
        return Math.pow(x, b);
    }

    public static void main(String[] args) {
        ScientificCalc calc = new ScientificCalc();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Java Scientific Calculator ---");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Log (ln(x))");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            double num, result;
            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    System.out.println("Result: " + calc.squareRoot(num));
                    break;
                case 2:
                    System.out.print("Enter integer: ");
                    int n = scanner.nextInt();
                    System.out.println("Result: " + calc.factorial(n));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    num = scanner.nextDouble();
                    System.out.println("Result: " + calc.naturalLog(num));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double b = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double e = scanner.nextDouble();
                    System.out.println("Result: " + calc.power(b, e));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}