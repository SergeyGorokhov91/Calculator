package calculator;

import syntax_analyzer.lexer.Lexeme;
import syntax_analyzer.lexer.LexemeType;

import java.util.List;

public final class ArabianCalculator implements Calculator{

    @Override
    public String calculate(List<Lexeme> lexemeList) {
        LexemeType type = lexemeList.get(1).getType();
        Integer firstNumber = Integer.parseInt(lexemeList.get(0).getValue());//тут я парсю с помощью встроенных средств
        Integer secondNumber = Integer.parseInt(lexemeList.get(2).getValue());

        return switch (type) {
            case PLUS -> String.valueOf(firstNumber + secondNumber);
            case MINUS -> String.valueOf(firstNumber - secondNumber);
            case DIV -> String.valueOf(firstNumber / secondNumber);
            case MUL -> String.valueOf(firstNumber * secondNumber);
            default -> throw new RuntimeException("Ошибка во время калькуляции.");
        };
    }
}
