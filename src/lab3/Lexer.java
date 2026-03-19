package lab3;

import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private Reader reader;
    private int lastChar = ' ';

    public Lexer(Reader reader) {
        this.reader = reader;
    }

    private int readChar() throws IOException {
        return reader.read();
    }

    public Token getNextToken() throws IOException {
        // Skip whitespace
        while (Character.isWhitespace(lastChar)) {
            lastChar = readChar();
        }

        // End of file
        if (lastChar == -1) {
            return new Token(TokenType.EOF);
        }

        // Identifier: [a-zA-Z][a-zA-Z0-9]*
        if (Character.isLetter(lastChar)) {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) lastChar);
                lastChar = readChar();
            } while (Character.isLetterOrDigit(lastChar));

            String ident = sb.toString();
            if (ident.equals("def")) return new Token(TokenType.DEF);
            if (ident.equals("extern")) return new Token(TokenType.EXTERN);
            if (ident.equals("sin") || ident.equals("cos")) return new Token(TokenType.IDENTIFIER, ident);
            return new Token(TokenType.IDENTIFIER, ident);
        }

        // Number: [0-9.]+
        if (Character.isDigit(lastChar) || lastChar == '.') {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) lastChar);
                lastChar = readChar();
            } while (Character.isDigit(lastChar) || lastChar == '.');

            double num = Double.parseDouble(sb.toString());
            return new Token(TokenType.NUMBER, num);
        }

        // Comment handling: skip lines starting with '#'
        if (lastChar == '#') {
            do {
                lastChar = readChar();
            } while (lastChar != -1 && lastChar != '\n' && lastChar != '\r');
            return getNextToken();
        }

        // Operators or other single characters
        char thisChar = (char) lastChar;
        lastChar = readChar();
        return new Token(TokenType.OPERATOR, String.valueOf(thisChar));
    }
}