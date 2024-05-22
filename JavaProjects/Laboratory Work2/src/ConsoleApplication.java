import java.util.Scanner;

public class NumberConverterAndArithmeticjava {
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    public static String decimalToHexadecimal(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    public static int hexadecimalToDecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    public static String performBinaryArithmetic(String num1, String num2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = binaryToDecimal(num1) + binaryToDecimal(num2);
                break;
            case '/':
                result = binaryToDecimal(num1) / binaryToDecimal(num2);
                break;
            default:
                return "Invalid operation.";
        }

        return decimalToBinary(result);
    }

    public static String performOctalArithmetic(String num1, String num2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = octalToDecimal(num1) + octalToDecimal(num2);
                break;
            case '/':
                result = octalToDecimal(num1) / octalToDecimal(num2);
                break;
            default:
                return "Invalid operation.";
        }

        return decimalToOctal(result);
    }

    public static String performHexadecimalArithmetic(String num1, String num2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = hexadecimalToDecimal(num1) + hexadecimalToDecimal(num2);
                break;
            case '/':
                result = hexadecimalToDecimal(num1) / hexadecimalToDecimal(num2);
                break;
            default:
                return "Invalid operation.";
        }

        return decimalToHexadecimal(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Decimal to Binary and vice versa");
            System.out.println("2. Decimal to Octal and vice versa");
            System.out.println("3. Decimal to Hexadecimal and vice versa");
            System.out.println("4. Perform Binary Arithmetic (+, /)");
            System.out.println("5. Perform Octal Arithmetic (+, /)");
            System.out.println("6. Perform Hexadecimal Arithmetic (+, /)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a decimal number: ");
                    int decimalInput = scanner.nextInt();
                    System.out.println("Binary: " + decimalToBinary(decimalInput));
                    break;
                case 2:
                    System.out.print("Enter a decimal number: ");
                    int decimalInput2 = scanner.nextInt();
                    System.out.println("Octal: " + decimalToOctal(decimalInput2));
                    break;
                case 3:
                    System.out.print("Enter a decimal number: ");
                    int decimalInput3 = scanner.nextInt();
                    System.out.println("Hexadecimal: " + decimalToHexadecimal(decimalInput3));
                    break;
                case 4:
                    System.out.print("Enter the first binary number: ");
                    String binaryNum1 = scanner.next();
                    System.out.print("Enter the operation (+, /): ");
                    char operation = scanner.next().charAt(0);
                    System.out.print("Enter the second binary number: ");
                    String binaryNum2 = scanner.next();
                    System.out.println("Result: " + performBinaryArithmetic(binaryNum1, binaryNum2, operation));
                    break;
                case 5:
                    System.out.print("Enter the first octal number: ");
                    String octalNum1 = scanner.next();
                    System.out.print("Enter the operation (+, /): ");
                    char operation2 = scanner.next().charAt(0);
                    System.out.print("Enter the second octal number: ");
                    String octalNum2 = scanner.next();
                    System.out.println("Result: " + performOctalArithmetic(octalNum1, octalNum2, operation2));
                    break;
                case 6:
                    System.out.print("Enter the first hexadecimal number: ");
                    String hexadecimalNum1 = scanner.next();
                    System.out.print("Enter the operation (+, /): ");
                    char operation3 = scanner.next().charAt(0);
                    System.out.print("Enter the second hexadecimal number: ");
                    String hexadecimalNum2 = scanner.next();
                    System.out.println("Result: " + performHexadecimalArithmetic(hexadecimalNum1, hexadecimalNum2, operation3));
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);

        scanner.close();
    }
}


