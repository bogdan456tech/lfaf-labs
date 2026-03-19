package lab3;

public enum TokenType {
    EOF,            // End of file/input
    DEF,            // 'def' keyword
    EXTERN,         // 'extern' keyword
    IDENTIFIER,     // Names (variables or functions)
    NUMBER,         // Numeric literal
    OPERATOR,       // Operator like +, -, *, /, etc.
    UNKNOWN         // Any unknown character
}