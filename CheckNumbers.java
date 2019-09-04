import static java.lang.Character.getNumericValue;

public class CheckNumbers {
     private int oneArabicNumber = 10;
     private int twoArabicNumber = 10;

     private char operator = ' ';

     private String oneRomanNumber = "";
     private String twoRomanNumber = "";

    public int getOneArabicNumber() {
        return oneArabicNumber;
    }

    public int getTwoArabicNumber() {
        return twoArabicNumber;
    }

    public char getOperator() {
        return operator;
    }

    public String getOneRomanNumber() {
        return oneRomanNumber;
    }

    public String getTwoRomanNumber() {
        return twoRomanNumber;
    }




    public void sortArabicNumbers(char[] ch) { //метод проверят - является ли char числом или буквой
                                                    // и конвертирует char  в int (арабские цифры)
           for(int i = 0; i < ch.length; i++) {
               if ( Character.isDigit(ch[i])
                       && Character.getNumericValue(ch[i]) > -1
                       && Character.getNumericValue(ch[i]) <= 9 ) {
                   oneArabicNumber = Character.getNumericValue(ch[i]);         //определили,что первое число ябляется арабским
                                                                                // и переводим это число из char в int
               } else if(   (ch[i]=='*' || ch[i]=='/' || ch[i]=='-' || ch[i]=='+')
                       && ((Character.isDigit(ch[i+1])
                       && Character.getNumericValue(ch[i+1]) >= 0
                       && Character.getNumericValue(ch[i+1]) <= 9))   ) {
                   operator = ch[i];                             // если нашли математический символ,то присвоили его переменной operator
                   twoArabicNumber = Character.getNumericValue(ch[i+1]);  //определили,что второе число ябляется арабским
                   break;                                             // и переводим это число из char в int
               }


           }
       }

        public void sortRomanNumber(char ch[]) {  //метод конвертирует char в string (римские цифры)

            for(int i = 0; i < ch.length; i++) {

                if(Character.isSpaceChar(operator) && Character.isLetter(ch[i])) {
                    oneRomanNumber += String.valueOf(ch[i]);
                }

                else  if( (ch[i]=='*' || ch[i]=='/' || ch[i]=='-' || ch[i]=='+') && Character.isLetter(ch[i+1]) ) {
                    operator = ch[i];

                    for(int j = i+1; j < ch.length+1; j++){
                        if(Character.isLetter(ch[j-1])) {
                            twoRomanNumber += String.valueOf(ch[j-1]);

                    }

                    }
                }

            }

        }

}






