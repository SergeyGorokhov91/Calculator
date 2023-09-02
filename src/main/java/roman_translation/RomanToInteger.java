package roman_translation;

/**
 * Это пример повтороного использования кода, ибо эту задачу я уже решал на литкоде.
 *
 * Идея в том, что сперва проверяется текущий и следующий символ на предмет
 * упрощения четырехциферной записи (метод twoDigsToInt) и если это тметод вернёт -1,
 * то после идёт суммированиепо обычной схеме (метод digitToInt)
 */
public class RomanToInteger {

    /**
     * Вики: Натуральные числа записываются при помощи повторения этих цифр.
     * При этом, если бо́льшая цифра стоит перед меньшей, то они складываются.
     * Если возможно написать число без более чем трехкратного повторения одного символа,
     * то можно просто складывать
     * @param d - принимает символ
     * @return - возвращает число
     */
    private static int digitToInt(char d) {
        return switch (d) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            default -> -1;
        };
    }


    /**
     * Этот метод проверяет две подряд идущие цифры на то, соовтествуют ли они случаю,
     * когда мы пытаемся избеждать четырехкратного повторения конкретной цифры
     * Пример: IV вместо IIII или IX, вместо VIIII
     * @param f - первый из двух последовательно идущих символов
     * @param s - второй из двух последовательно идущих символов
     * @return возвращает либо искомое число, либо -1, кторый интерпритируется как несоотвествие специфичному паттерну
     */

    private static int twoDigsToInt(char f, char s) {
        return switch (f) {
            case 'I' -> s == 'V' ? 4 : (s == 'X' ? 9 : -1);
            default -> -1;
        };
    }

    public static int parseString(String rnum) {
        if (rnum.length() == 1)
            return digitToInt(rnum.charAt(0));

        int result = 0;
        int pointer = 0;

        for (; pointer < rnum.length() - 1; pointer++) {
            char cur = rnum.charAt(pointer);
            char next = rnum.charAt(pointer + 1);

            int twoDigVal = twoDigsToInt(cur, next);
            int oneDigVal = digitToInt(cur);

            if (twoDigVal > 0){
                result += twoDigVal;
                pointer += 1;

            } else if (oneDigVal > 0) {
                result += oneDigVal;
            } else
                throw new IllegalStateException();
        }

        if (pointer == rnum.length() -1) {
            char last = rnum.charAt(pointer);
            result += digitToInt(last);
        }

        return result;
    }

}
