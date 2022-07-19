import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OperatorException, OperandException {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.print("Введите ваше уравнение, которое нужно решить: ");

            String equation = scanner.nextLine();

            System.out.println(calc(equation));

        }

    }

    public static String calc(String input) throws OperandException, OperatorException {
        ParserEquation pe = new ParserEquation();
        pe.ParseString(input);

        String firstNum = pe.getFirstNum();
        String secondNum = pe.getSecondNum();
        String operator = pe.getOperation();

        Calculator calculator = new Calculator(firstNum, secondNum, operator);

        return calculator.Calculate();
    }


}