import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        if (base == 2)
        {
            System.out.println("Octal Digit Array: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
            System.out.println();
            System.out.println("Decimal Digit Array: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Decimal Number: " + nc.displayAsNumber(nc.convertToDecimal()));
        }
        if (base == 8)
        {
            System.out.println("Binary Digit Array: " + Arrays.toString(nc.convertToBinary()));
            System.out.println("Binary Number: " + nc.displayAsNumber(nc.convertToBinary()));
            System.out.println();
            System.out.println("Decimal Digit Array: " + Arrays.toString(nc.convertToDecimal()));
            System.out.println("Decimal Number: " + nc.displayAsNumber(nc.convertToDecimal()));
        }
        if (base == 10)
        {
            System.out.println("Octal Digit Array: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
            System.out.println();
            System.out.println("Octal Digit Array: " + Arrays.toString(nc.convertToOctal()));
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
        }
    }
}

