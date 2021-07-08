package calculator;

import java.util.*;


public class CalcExp {
    private static final List<String> MATH = Arrays.asList("*", "/", "-", "+");

    public static int calc(String expression) {
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, expression.trim().split(" "));

        while (stringList.stream().anyMatch(MATH::contains)) {
            int index = -1;
            int result = 0;
            try {
                if (stringList.contains("*")) {
                    index = stringList.indexOf("*");
                    result = Integer.parseInt(stringList.get(index - 1)) * Integer.parseInt(stringList.get(index + 1));
                } else if (stringList.contains("/")) {
                    try {
                        index = stringList.indexOf("/");
                        result = Integer.parseInt(stringList.get(index - 1)) / Integer.parseInt(stringList.get(index + 1));
                    } catch (ArithmeticException e) {
                        throw new ArithmeticException("You can't divide by zero");
                    }
                } else if (stringList.contains("-")) {
                    index = stringList.indexOf("-");
                    result = Integer.parseInt(stringList.get(index - 1)) - Integer.parseInt(stringList.get(index + 1));
                } else if (stringList.contains("+")) {
                    index = stringList.indexOf("+");
                    result = Integer.parseInt(stringList.get(index - 1)) + Integer.parseInt(stringList.get(index + 1));
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("You can work only with integers");
            }
            stringList.add(index - 1, String.valueOf(result));
            stringList.remove(index + 2);
            stringList.remove(index + 1);
            stringList.remove(index);
        }
        return Integer.parseInt(stringList.get(0));
    }
}
