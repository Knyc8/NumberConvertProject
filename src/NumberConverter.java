public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
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
        o = o + "\n";
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
        int num = 0;
        for (int i = digits.length-1; i >= 0; i--)
        {
            num += digits[i] * Math.pow(10, digits.length-1-i);
        }

        while ((num / base) != 0)
        {
            binary = num % base +  binary;
            num -= num % base;
        }

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
        return null;
    }
}

