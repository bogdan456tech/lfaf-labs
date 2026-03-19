# Lexer & Scanner Implementation

**Course:** Formal Languages & Finite Automata
**Author:** Bogdan Arama

---

## Theory

This project demonstrates the implementation of a **lexer** (also called a scanner or tokenizer) in Java. A lexer performs lexical analysis, which is the process of converting a string of characters into a sequence of tokens. Tokens represent the meaningful elements of a language, such as numbers, identifiers, keywords, operators, or functions. Each token may carry metadata, such as the numeric value of a number or the name of an identifier. The lexer is one of the first steps in processing source code for interpreters or compilers, allowing subsequent components like parsers to work with a structured input.

In this implementation, the lexer can handle integers and floating-point numbers, identifiers, keywords like `def` and `extern`, operators such as `+`, `-`, `*`, `/`, parentheses, and trigonometric functions `sin` and `cos`. Comments starting with `#` and whitespace are ignored. The lexer produces a stream of `Token` objects, each with a type and relevant value or text.

---

## Objectives

The main objectives of this project are to implement a lexer that can read a source string, correctly tokenize all valid lexemes, and provide metadata for numbers and identifiers. The lexer should be able to handle more complex inputs than a simple calculator, including functions, floating-point numbers, nested parentheses, and arithmetic expressions. The project also aims to illustrate the concept of lexical analysis and the structure of a lexer in Java. The tokens produced by the lexer should be clearly distinguishable and ready to be used by a parser for further processing.

---

## Implementation Description

### 1. TokenType Enum

The `TokenType` enum represents the different categories of tokens the lexer can produce. Each token returned by the lexer has a type corresponding to one of these values. Token types include `EOF` for the end of input, `DEF` and `EXTERN` for language keywords, `IDENTIFIER` for variable or function names, `NUMBER` for numeric literals, `OPERATOR` for symbols like `+`, `-`, `*`, `/`, and `FUNCTION` for recognized functions such as `sin` or `cos`.

---

### 2. Token Class

The `Token` class represents a single lexeme in the input. Each token has a type, and depending on the type, it may store a numeric value (for numbers) or a text string (for identifiers, operators, or function names). The class provides a `toString()` method that formats the token for easy debugging and visualization. This structure allows the lexer to produce a clean and structured output, suitable for further parsing.

---

### 3. Lexer Class

The `Lexer` class is responsible for reading characters from a source string and converting them into tokens. It uses a `Reader` object to process input one character at a time. The lexer skips whitespace, ignores comments, and recognizes the following elements: numbers (integers and floats), identifiers, keywords, operators, parentheses, and trigonometric functions. Each token is returned as a `Token` object. The lexer maintains state for the last character read and ensures that multi-character lexemes are fully captured before returning a token. This implementation is flexible and can be extended to support more complex language features.

---

### 4. Main Class

The `Main` class demonstrates the lexer in action. It provides a sample input string containing function definitions, arithmetic expressions, numbers, identifiers, keywords, and trigonometric functions. The lexer is used to tokenize this input, and the program prints each token in order. This demonstration shows that the lexer correctly identifies all tokens, ignores whitespace and comments, and handles nested expressions with parentheses and operators.

---

## Conclusions

The project demonstrates the process of lexical analysis using a Java lexer. It shows how source code or input text can be transformed into a structured sequence of tokens, which is a critical first step in compiling or interpreting a language. The lexer successfully handles numbers, identifiers, keywords, operators, parentheses, and functions, making it more sophisticated than a simple calculator lexer. This project improves understanding of language processing, tokenization, and object-oriented design in Java. The lexer can be extended further to handle more advanced constructs, multi-character operators, scientific notation, and additional language-specific rules.

