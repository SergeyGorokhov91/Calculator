import calculator.Calculator;
import calculator.CalculatorFabric;
import calculator.CalculatorType;
import syntax_analyzer.BasicValidator;
import syntax_analyzer.lexer.Lexeme;
import syntax_analyzer.lexer.Lexer;

import java.util.List;

public class Main {
    public static String calc(String input) {
        CalculatorType type = BasicValidator.validate(input);
        Calculator calculator = CalculatorFabric.createCalculator(type);
        List<Lexeme> lexemes  = Lexer.createLexemeList(input);
        return calculator.calculate(lexemes);
    }
}
