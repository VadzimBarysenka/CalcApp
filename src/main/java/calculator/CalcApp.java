package calculator;

public class CalcApp {

    public static void main(String[] args) {
        //String expression = "42 - 63 * 3 * 55 / 7 + 222";
        String expression = args[0];
        System.out.println("The result: " + CalcExp.getInstance().calc(expression));
    }
}