package calculator;

public final class CalculatorFabric {
    public static Calculator createCalculator(CalculatorType type) {
        switch (type) {
            case ARABIAN -> {return new ArabianCalculator();}
            case ROMAN -> {return new RomanCalculator();}
            default -> throw new RuntimeException("Unreachable state");
        }
    }
}
