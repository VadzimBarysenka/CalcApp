package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalcAppTest {
    public static final String EXPRESSION = "42 - 63 * 3 * 55 / 7 + 222";
    public static final int EXPRESSION_RESULT = -1221;

    @Test
    void calcExpression() {
        assertEquals(EXPRESSION_RESULT,CalcExp.calc(EXPRESSION));
    }
}
