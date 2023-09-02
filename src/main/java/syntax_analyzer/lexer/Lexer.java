package syntax_analyzer.lexer;


import java.util.ArrayList;
import java.util.List;

public final class Lexer {

    private static int pointer = 0;

    public static List<Lexeme> createLexemeList(final String validInput) {
        return lexemeAnalysis(validInput);
    }

    private Lexer() {}

    private static List<Lexeme> lexemeAnalysis(final String validInput) {
        final List<Lexeme> lexemes = new ArrayList<>();

        while (pointer < validInput.length()) {
            char currChar = validInput.charAt(pointer);
            switch (currChar) {
                case '+' -> addLexemeToListAndIncrementPointer(lexemes,LexemeType.PLUS,"+");
                case '-' -> addLexemeToListAndIncrementPointer(lexemes,LexemeType.MINUS,"-");
                case '*' -> addLexemeToListAndIncrementPointer(lexemes,LexemeType.MUL,"*");
                case '/' -> addLexemeToListAndIncrementPointer(lexemes,LexemeType.DIV,"/");
                default -> {
                    if (isaBlankChar(currChar)) incrementPointer();
                    else if (isaArabicNumber(currChar) || isaRomanNumberLetter(currChar))
                        parseNumberAndAddToList(lexemes, validInput, currChar);
                    else throw new RuntimeException("Unreachable state.");
                }
            }
        }
        resetPointer();
        return lexemes;
    }

    private static void parseNumberAndAddToList(List<Lexeme> lexemes, String validInput, char currChar) {
        String res = parseNumber(validInput,currChar);
        Lexeme newValueLexeme = createLexeme(LexemeType.VALUE,res);
        addLexemeToList(lexemes,newValueLexeme);
    }

    private static String parseNumber(String validInput, char c) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(c);
            incrementPointer();
            if(pointer >= validInput.length()) {
                break;
            }
            c = validInput.charAt(pointer);
        }while (isaArabicNumber(c) || isaRomanNumberLetter(c));
        return sb.toString();
    }


    private static void addLexemeToListAndIncrementPointer(List<Lexeme> list, LexemeType type, String value) {
        addLexemeToList(list,createLexeme(type,value));
        incrementPointer();
    }

    private static Lexeme createLexeme(LexemeType type, String value) {
        return new Lexeme(type,value);
    }

    private static void addLexemeToList(List<Lexeme> list, Lexeme lexeme) {
        list.add(lexeme);
    }

    private static boolean isaRomanNumberLetter(char c) {
        return c == 'I' || c == 'V' || c == 'X';
    }

    private static boolean isaArabicNumber(char c) {
        return c <= '9' && c >= '0';
    }

    private static boolean isaBlankChar(char c) {
        return c == ' ';
    }



    private static void incrementPointer(){
        pointer++;
    }

    public static void resetPointer() {
        pointer = 0;
    }
}
