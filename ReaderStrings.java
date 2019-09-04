import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderStrings {

    private char Expression[];

    public void readerStrings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        this.Expression = str.toCharArray();
    }

    public char[] getExpression() {
        return Expression;
    }
}
