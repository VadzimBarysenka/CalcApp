import java.util.*;


public class CalcApp {
    private static final List<String> MATH = Arrays.asList("*", "/", "-", "+");

    public static void main(String[] args) {
        //String expression = "42 - 63 * 3 * 55 / 5 + 22";
        String expression = args[0];
        System.out.println("The result: " + calc(expression));
    }

    public static int calc(String expression) {

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, expression.trim().split(" "));

        while (stringList.size() != 0) {
            int result = 0;

            if (stringList.contains("*")) {
                int index = stringList.indexOf("*");
                result = Integer.parseInt(stringList.get(index - 1)) * Integer.parseInt(stringList.get(index + 1));
                stringList.add(index - 1, String.valueOf(result));
                stringList.remove(index + 2);
                stringList.remove(index + 1);
                stringList.remove(index);
            } else if (stringList.contains("/")) {
                int index = stringList.indexOf("/");
                result = Integer.parseInt(stringList.get(index - 1)) / Integer.parseInt(stringList.get(index + 1));
                stringList.add(index - 1, String.valueOf(result));
                stringList.remove(index + 2);
                stringList.remove(index + 1);
                stringList.remove(index);
            } else if (stringList.contains("-")) {
                int index = stringList.indexOf("-");
                result = Integer.parseInt(stringList.get(index - 1)) - Integer.parseInt(stringList.get(index + 1));
                stringList.add(index - 1, String.valueOf(result));
                stringList.remove(index + 2);
                stringList.remove(index + 1);
                stringList.remove(index);
            } else if (stringList.contains("+")) {
                int index = stringList.indexOf("+");
                result = Integer.parseInt(stringList.get(index - 1)) + Integer.parseInt(stringList.get(index + 1));
                stringList.add(index - 1, String.valueOf(result));
                stringList.remove(index + 2);
                stringList.remove(index + 1);
                stringList.remove(index);
            }
            if (stringList.stream().noneMatch(MATH::contains)) {
                return result;
            }
        }
        return Integer.parseInt(stringList.toString());
    }
}