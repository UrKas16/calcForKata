import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OperatorException, OperandException {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println();
            System.out.print("Введите ваше уравнение, которое нужно решить: ");

            String equation = scanner.nextLine();

            System.out.printf("Ваш результат: %s", calc(equation));

        }

    }

    public static String calc(String input) throws OperandException, OperatorException {
        ParserEquation pe = new ParserEquation();
        pe.ParseString(input);

        ConvertorArabicRomanNum convertor = new ConvertorArabicRomanNum(pe.getFirstNum(), pe.getSecondNum());

        boolean isRoman = convertor.isRoman();
        boolean isArabic = convertor.isArabic();
        int firstNum = convertor.getFirstNum();
        int secondNum = convertor.getSecondNum();

        String operator = pe.getOperation();

        Calculator calculator = new Calculator(isArabic, isRoman);

        int result = calculator.Calculate(firstNum, secondNum, operator);

        if (isRoman){
           return convertor.ConvertArabicToRoman(result);
        } else{
            return Integer.toString(result);
        }
    }

}