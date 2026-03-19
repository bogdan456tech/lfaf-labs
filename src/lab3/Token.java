package lab3;

public class Token {
    public TokenType type;
    public String text;   // Identifier name or operator
    public double value;  // Number value if NUMBER type

    public Token(TokenType type) {
        this.type = type;
    }

    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
    }

    public Token(TokenType type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        switch (type) {
            case NUMBER: return "NUMBER(" + value + ")";
            case IDENTIFIER: return "IDENTIFIER(" + text + ")";
            case DEF: return "DEF";
            case EXTERN: return "EXTERN";
            case OPERATOR: return "OPERATOR(" + text + ")";
            case EOF: return "EOF";
            default: return "UNKNOWN(" + text + ")";
        }
    }
}