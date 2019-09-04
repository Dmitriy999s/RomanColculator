import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    static String oneRomanNumber;
    static String twoRomanNumber;

    public static void main(String[] args) throws IOException, NullPointerException {
        ReaderStrings reader = new ReaderStrings();
        reader.readerStrings(); // считали выражение с клавиатуры

        char[] ch = reader.getExpression(); //конвертировали выражение в массив char
        CheckNumbers checkNumbers = new CheckNumbers();

        char operator;
        CheckOperators checkOperators = new CheckOperators();




        //Проверка данных. Подходят ли требованиям. и являются арабскими либо римскими
        if(Character.isDigit(ch[0]) && Character.getNumericValue(ch[0]) > -1
                && (Character.getNumericValue(ch[1]) == '*'
                        || Character.getNumericValue(ch[1]) == '-'
                        || Character.getNumericValue(ch[1]) == '/'
                        || Character.getNumericValue(ch[1]) == '+')) {
            checkNumbers.sortArabicNumbers(ch);

        } else if(Character.isLetter(ch[0]) ) {
            checkNumbers.sortRomanNumber(ch);
            oneRomanNumber = checkNumbers.getOneRomanNumber();//.replace("\"","");
            twoRomanNumber = checkNumbers.getTwoRomanNumber();//.replace("\"","");

        } else System.out.println("Вы ввели некорректные данные");




        // Сортируем полученные данные и выводим на экран
        if(checkNumbers.getOneArabicNumber() >= 0 && checkNumbers.getTwoArabicNumber() <=9) {
            int a = checkNumbers.getOneArabicNumber();
            int b = checkNumbers.getTwoArabicNumber();
            operator = checkNumbers.getOperator();
            try {
                int result = (checkOperators.calulater(a, b, operator));
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль невозможно");
            }
        }

          else if ( (oneRomanNumber.equals("I") ||
                oneRomanNumber.equals("II") ||
                oneRomanNumber.equals("III") ||
                oneRomanNumber.equals("IV") ||
                oneRomanNumber.equals("V") ||
                oneRomanNumber.equals("VI") ||
                oneRomanNumber.equals("VII") ||
                oneRomanNumber.equals("VIII") ||
                oneRomanNumber.equals("IX") )
               &&
                (twoRomanNumber.equals("I") ||
                        twoRomanNumber.equals("II") ||
                        twoRomanNumber.equals("III") ||
                        twoRomanNumber.equals("IV") ||
                        twoRomanNumber.equals("V") ||
                        twoRomanNumber.equals("VI") ||
                        twoRomanNumber.equals("VII") ||
                        twoRomanNumber.equals("VIII") ||
                        twoRomanNumber.equals("IX")  )  ) {
            int c = Converter.convertRomanToArabic(oneRomanNumber);
            int d = Converter.convertRomanToArabic(twoRomanNumber);
            operator = checkNumbers.getOperator();
            int f =checkOperators.calulater(c,d,operator);
            String resultRoman = Converter.convertArabicToRoman(f);
            System.out.println(resultRoman);
            System.out.println(f);
            System.out.println(c);
            System.out.println(d);
            System.out.println(oneRomanNumber);
            System.out.println(twoRomanNumber);

        } else throw new NumberFormatException("Вы ввели некорректные данные");
    }
}
