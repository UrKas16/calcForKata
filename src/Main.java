import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OperatorException, OperandException {

        //   HashMap<Integer, String> arabicRomanNum = new HashMap<>(new ArabicRomanNum().getArabicRomanNum());

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше уравнение, которое нужно решить: ");

        String equation = scanner.nextLine();

        ParserEquation pe = new ParserEquation();
        pe.ParseString(equation);


        String a = pe.getFirstNum();
        String b = pe.getSecondNum();
        String c = pe.getOperation();

        Calculator calc = new Calculator(a, b, c);


        System.out.println();

        scanner.next();
    }

}