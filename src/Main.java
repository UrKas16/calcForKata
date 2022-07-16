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

            ParserEquation pe = new ParserEquation();
            pe.ParseString(equation);

            String firstNum = pe.getFirstNum();
            String secondNum = pe.getSecondNum();
            String operator = pe.getOperation();

            Calculator calc = new Calculator(firstNum, secondNum, operator);

            calc.Calculate();
        }

    }

}