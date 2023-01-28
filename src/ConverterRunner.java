import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10") && !choice.equals("16"))
        {
            System.out.print("Enter 2, 8, 10, or 16: ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if (base <= 10)
        {
            while (isNum(number) == false)
            {
                System.out.print("Enter an appropriate number according to your base: ");
                number = s.nextLine();
            }
            int[] numDigits = numAsDig(number);
            boolean correct = true;
            for (int digit : numDigits) {
                if (digit >= base) {
                    correct = false;
                }
            }
            while (correct == false) {
                System.out.print("Enter an appropriate number according to your base: ");
                number = s.nextLine();
                numDigits = numAsDig(number);
                int correctCounter = 0;
                for (int digit : numDigits) {
                    if (digit < base) {
                        correctCounter++;
                    }
                }
                if (correctCounter == numDigits.length)
                {
                    correct = true;
                }
            }
        }
        else if (base == 16)
        {
            String[] digits = stringAsDig(number);
            boolean correct = true;
            for (int i = 0; i < digits.length; i++)
            {
                if (NumberConverter.letterToNum(digits[i]) >= 16)
                {
                    correct = false;
                }
            }
            while (correct == false) {
                System.out.print("Enter an appropriate number according to your base: ");
                number = s.nextLine();
                digits = stringAsDig(number);
                int correctCounter = 0;
                for (String digit : digits) {
                    if (NumberConverter.letterToNum(digit) < 16) {
                        correctCounter++;
                    }
                }
                if (correctCounter == digits.length)
                {
                    correct = true;
                }
            }
        }

        s.close();

        NumberConverter nc = new NumberConverter(number, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        if (base == 2)
        {
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
            System.out.println("Decimal Number: " + nc.displayAsNumber(nc.convertToDecimal()));
            System.out.println("Hexadecimal Number: " + nc.displayAsNumber(nc.convertToHexadec()));
        }
        if (base == 8)
        {
            System.out.println("Binary Number: " + nc.displayAsNumber(nc.convertToBinary()));
            System.out.println("Decimal Number: " + nc.displayAsNumber(nc.convertToDecimal()));
            System.out.println("Hexadecimal Number: " + nc.displayAsNumber(nc.convertToHexadec()));
        }
        if (base == 10)
        {
            System.out.println("Binary Number: " + nc.displayAsNumber(nc.convertToBinary()));
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
            System.out.println("Hexadecimal Number: " + nc.displayAsNumber(nc.convertToHexadec()));
        }
        if (base == 16)
        {
            System.out.println("Binary Number: " + nc.displayAsNumber(nc.convertToBinary()));
            System.out.println("Octal Number: " + nc.displayAsNumber(nc.convertToOctal()));
            System.out.println("Decimal Number: " + nc.displayAsNumber(nc.convertToDecimal()));
        }
    }

    private static boolean isNum(String num)
    {
        try
        {
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException ex)
        {
            return false;
        }
    }

    private static int[] numAsDig(String num)
    {
        int[] numDigits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            int d = Integer.parseInt(single);
            numDigits[i] = d;
        }
        return numDigits;
    }

    private static String[] stringAsDig(String num)
    {
        String[] numDigits = new String[num.length()];
        for (int i = 0; i < num.length(); i++) {
            String single = num.substring(i,i+1);
            String d = single;
            numDigits[i] = d;
        }
        return numDigits;
    }
}

