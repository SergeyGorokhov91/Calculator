package syntax_analyzer;

import calculator.CalculatorType;

import java.util.regex.Pattern;

public final class BasicValidator {

    private static final Pattern ROMAN = Pattern.compile("^\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*([-+*/%])\\s*(I|II|III|IV|V|VI|VII|VIII|IX|X)\\s*$");
    private static final Pattern ARABIAN = Pattern.compile("^\\s*([1-9]|10)\\s*([-+*/%])\\s*([1-9]|10)\\s*$");

    public static CalculatorType validate(String input) {
        if(input.matches(ARABIAN.pattern())) return CalculatorType.ARABIAN;
        if(input.matches(ROMAN.pattern())) return CalculatorType.ROMAN;
        throw new RuntimeException();
    }
}
