package calculator;

import syntax_analyzer.lexer.Lexeme;

import java.util.List;

public interface Calculator {
    String calculate(List<Lexeme> lexemeList);

}
