import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class ScientificCalc {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is undefined.");
            return Double.NaN; 
        }
        return a / b;
    }

    public double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0) return 0; 
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
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square Root (√x)");
            System.out.println("6. Factorial (x!)");
            System.out.println("7. Natural Log (ln(x))");
            System.out.println("8. Power (x^b)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            
            // To prevents crashes if a letter is typed or an arrow key is clicked
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next();
                continue;
            }

            if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }

            double num1, num2;
            
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + calc.add(num1, num2));
                        break;
                    case 2:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + calc.subtract(num1, num2));
                        break;
                    case 3:
                        System.out.print("Enter first number: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        num2 = scanner.nextDouble();
                        System.out.println("Result: " + calc.multiply(num1, num2));
                        break;
                    case 4:
                        System.out.print("Enter numerator: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Enter denominator: ");
                        num2 = scanner.nextDouble();
                        double divResult = calc.divide(num1, num2);
                        if (!Double.isNaN(divResult)) {
                            System.out.println("Result: " + divResult);
                        }
                        break;
                    case 5:
                        System.out.print("Enter number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + calc.squareRoot(num1));
                        break;
                    case 6:
                        System.out.print("Enter integer: ");
                        int n = scanner.nextInt();
                        System.out.println("Result: " + calc.factorial(n));
                        break;
                    case 7:
                        System.out.print("Enter number: ");
                        num1 = scanner.nextDouble();
                        System.out.println("Result: " + calc.naturalLog(num1));
                        break;
                    case 8:
                        System.out.print("Enter base: ");
                        double b = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double e = scanner.nextDouble();
                        System.out.println("Result: " + calc.power(b, e));
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a number from 1 to 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.next(); // clear the bad input
            }
        }
        scanner.close();
    }
}
// testing the webhook trigger
