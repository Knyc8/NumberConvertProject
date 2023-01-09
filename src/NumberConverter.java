public class NumberConverter {
    int[] digits;
    int base;
    int number;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        this.number = number;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String displayAsNumber(int[] newDigits) {
        String o = "";
        for (int i = 0; i < newDigits.length; i++) {
            o = o + newDigits[i];
        }
        o = o;
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int dec = 0;
        for (int i = 0; i < digits.length; i++)
        {
            dec += ((digits[digits.length - 1 - i]) * (int)Math.pow(base, i));
        }

        String numberAsString = Integer.toString(dec);
        int[] toDec = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toDec[i] = d;
        }
        return toDec;

    }

    public int[] convertToBinary() {
        String binary = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 2) != 0)
        {
            binary = num % 2 + binary;
            num = num/2;
        }
        binary = num%2 + binary;

        String numberAsString = binary;
        int[] toBin = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toBin[i] = d;
        }
        return toBin;
    }

    public int[] convertToOctal() {
        String octal = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 8) != 0)
        {
            octal = num % 8 + octal;
            num = num/8;
        }
        octal = num%8 + octal;

        String numberAsString = octal;
        int[] toOct = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            toOct[i] = d;
        }
        return toOct;
    }
}

