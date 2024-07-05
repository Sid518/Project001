package Calculator;

import java.util.Scanner;

public class Calculator {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }

    public static double sin(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.sin(angleRadians);
    }

    public static double cos(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.cos(angleRadians);
    }

    public static double tan(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.tan(angleRadians);
    }

    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CLI Calculator!");
        System.out.println("Available operations: add, subtract, multiply, divide, sin, cos, tan, factorial");

        while (true) {
            System.out.print("Enter an operation: ");
            String operation = scanner.nextLine().trim();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            switch (operation.toLowerCase()) {
                case "add":
                    performBinaryOperation("add", scanner);
                    break;
                case "subtract":
                    performBinaryOperation("subtract", scanner);
                    break;
                case "multiply":
                    performBinaryOperation("multiply", scanner);
                    break;
                case "divide":
                    performBinaryOperation("divide", scanner);
                    break;
                case "sin":
                    performUnaryOperation("sin", scanner);
                    break;
                case "cos":
                    performUnaryOperation("cos", scanner);
                    break;
                case "tan":
                    performUnaryOperation("tan", scanner);
                    break;
                case "factorial":
                    performFactorialOperation(scanner);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }

        scanner.close();
    }

    private static void performBinaryOperation(String operation, Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        switch (operation) {
            case "add":
                System.out.println("Result: " + add(num1, num2));
                break;
            case "subtract":
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case "multiply":
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case "divide":
                try {
                    System.out.println("Result: " + divide(num1, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
        scanner.nextLine(); // Consume newline left-over
    }

    private static void performUnaryOperation(String operation, Scanner scanner) {
        System.out.print("Enter number (for " + operation + "): ");
        double num = scanner.nextDouble();

        switch (operation) {
            case "sin":
                System.out.println("Result: " + sin(num));
                break;
            case "cos":
                System.out.println("Result: " + cos(num));
                break;
            case "tan":
                System.out.println("Result: " + tan(num));
                break;
            default:
                System.out.println("Invalid operation.");
                break;
        }
        scanner.nextLine(); // Consume newline left-over
    }

    private static void performFactorialOperation(Scanner scanner) {
        System.out.print("Enter number (for factorial): ");
        int num = scanner.nextInt();

        try {
            System.out.println("Result: " + factorial(num));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.nextLine(); // Consume newline left-over
    }
}