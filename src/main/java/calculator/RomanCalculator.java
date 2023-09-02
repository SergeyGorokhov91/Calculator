package calculator;

import syntax_analyzer.lexer.Lexeme;
import syntax_analyzer.lexer.LexemeType;
import roman_translation.IntegerToRoman;
import roman_translation.RomanToInteger;

import java.util.List;

public final class RomanCalculator implements Calculator{

    @Override
    public String calculate(List<Lexeme> lexemeList) {
        LexemeType type = lexemeList.get(1).getType();
        Integer firstNumber = RomanToInteger.parseString(lexemeList.get(0).getValue());//тут я парсю с помощью своего класса
        Integer secondNumber = RomanToInteger.parseString(lexemeList.get(2).getValue());

        int result;

        switch (type) {
            case PLUS -> result = firstNumber + secondNumber;
            case MINUS -> result = firstNumber - secondNumber;
            case DIV -> result = firstNumber / secondNumber;
            case MUL -> result = firstNumber * secondNumber;
            default -> throw new RuntimeException("Ошибка во время калькуляции.");
        }

        if(result > 0) return IntegerToRoman.parseInt(result);
        else throw new RuntimeException("Результат вышел меньше или равный нулю.");
    }
}
