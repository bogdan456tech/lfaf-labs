package lab3;

import java.io.StringReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String code = """
            def fib(x)
                if x < 3 then
                    1
                else
                    fib(x-1) + fib(x-2)
            extern sin
            3.14 + 2 * cos(0.5)
            """;

        Lexer lexer = new Lexer(new StringReader(code));
        Token token;
        do {
            token = lexer.getNextToken();
            System.out.println(token);
        } while (token.type != TokenType.EOF);
    }
}