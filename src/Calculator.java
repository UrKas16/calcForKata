import org.jetbrains.annotations.NotNull;
class Calculator {
    private final boolean isRoman;
    private final boolean isArabic;


    public Calculator(boolean isArabic, boolean isRoman) {
        this.isArabic = isArabic;
        this.isRoman = isRoman;
    }

    public int Calculate(int firstNum, int secondNum, String operator) throws OperandException {
        if (isArabic & isRoman) {
            throw new OperandException("Операция не может быть выполнена между арабскими и рисмскими цифрами.");
        } else if (isArabic & !isRoman) {
            return CalculateArabic(firstNum, secondNum, operator);
        } else {
            return CalculateRoman(firstNum, secondNum, operator);
        }

    }

    private int CalculateArabic(int firstNum, int secondNum, @NotNull String operator) throws OperandException {
        return switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> firstNum / secondNum;
            default -> throw new OperandException("Такого оператора не существует.");
        };
    }

    private int CalculateRoman(int firstNum, int secondNum, @NotNull String operator) throws OperandException {
        switch (operator) {
            case "+":
                return firstNum + secondNum;
            case "-":
                if ((firstNum < secondNum) | (firstNum == secondNum)) {
                    throw new OperandException("Операция не возможна. В римской системе нет отрицательных чисел и НУЛЯ");
                }
                return firstNum - secondNum;
            case "*":
                return firstNum * secondNum;
            case "/":
                if (firstNum < secondNum) {
                    throw new OperandException("Операция не возможна. В римской системе нет НУЛЯ.");
                }
                return firstNum / secondNum;
            default:
                throw new OperandException("Такого оператора не существует.");
        }
    }

}
