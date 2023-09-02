package syntax_analyzer.lexer;

public final class Lexeme {
    private final LexemeType type;
    private final String value;


    public Lexeme(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

    public LexemeType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
