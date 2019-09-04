public class CheckOperators {

    public int calulater(int oneNumder, int twoNumber, char operator) {
        int result = 0;
        switch(operator) {
            case '+': result = oneNumder + twoNumber; break;
            case '-': result = oneNumder - twoNumber; break;
            case '*': result = oneNumder * twoNumber; break;
            case '/': result = oneNumder / twoNumber; break;
            default: throw new IllegalArgumentException("Не корректные данные");
        }
        return result;
    }
}
