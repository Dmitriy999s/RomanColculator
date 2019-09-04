public class Converter {

     static  int[] arabicNumbers = {1, 4, 5, 9, 10, 50, 100, 1000};
     static  String[] romanNumbers = {"I","IV","V","IX","X","L","C","D","M"};

    public static int convertRomanToArabic (String romanNamber) {

        int value = 0;

        for(int i = 0; i < romanNamber.length(); i++) {
            char ch = romanNamber.charAt(i);
            int number = letterToNumber(ch);

            if (number == -1) {
                throw new NumberFormatException("Вы ввели некорректные данные");
            }
            if(value == 0) {
                value += number;
            }else if(value < number){
                value = number-value;
            }else {
                value += number;
            }
        }
        return value;
    }

    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    public static String convertArabicToRoman(int arabicNumber) {

        String value = "";

        int n = arabicNumber;
        while (n > 0) {
            for(int i = 0; i < arabicNumbers.length; i++) {
                if (n < arabicNumbers[i]) {
                    n -= arabicNumbers[i-1];
                    value += romanNumbers[i-1];
                    break;
                }
            }
        }
        return value;
    }
}
