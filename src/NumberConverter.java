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

    public String displayAsNumber(String[] newDigits) {
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

    public String[] convertToHexadec() {
        String hex = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / 16) != 0)
        {
            if (num%16 > 9)
            {
                hex = numGreater9(num%16) + hex;
            }
            else {
                hex = num % 16 + hex;
            }
            num = num/16;
        }
        if (num%16 > 9)
        {
            hex = numGreater9(num%16) + hex;
        }
        else {
            hex = num % 16 + hex;
        }

        String numberAsString = hex;
        String[] toHex = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            String d = single;
            toHex[i] = d;
        }
        return toHex;
    }

    public String[] convertToAnyBase(int newBase) {
        String anyBase = "";
        String display = displayAsNumber(convertToDecimal());
        int num = Integer.parseInt(display);
        while ((num / newBase) != 0)
        {
            if (num%newBase > 9)
            {
                anyBase = numGreater9(num%newBase) + anyBase;
            }
            else {
                anyBase = num % newBase + anyBase;
            }
            num = num/newBase;
        }
        if (num%newBase > 9)
        {
            anyBase = numGreater9(num%newBase) + anyBase;
        }
        else {
            anyBase = num % newBase + anyBase;
        }

        String numberAsString = anyBase;
        String[] toAB = new String[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            String d = single;
            toAB[i] = d;
        }
        return toAB;
    }

    private String numGreater9(int num)
    {
        if (num == 10) {
            return "A";
        }
        if (num == 11) {
            return "B";
        }
        if (num == 12) {
            return "C";
        }
        if (num == 13) {
            return "D";
        }
        if (num == 14) {
            return "E";
        }
        if (num == 15) {
            return "f";
        }
        return "X";
    }
}

