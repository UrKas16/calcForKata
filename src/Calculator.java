import javax.management.OperationsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Calculator {
    private String operator;
    private String firstNumStr;
    private String secondNumStr;
    private int firstNumInt;
    private int secondNumInt;
    private ArabicRomanNumAndOperators arabicRomanNumAndOperators;

    private boolean isRoman;

    private boolean isArabic;


    public Calculator(String firstNum, String secondNum, String operator) throws OperatorException, OperandException {
        arabicRomanNumAndOperators = new ArabicRomanNumAndOperators();
        setFirstNumStr(firstNum);
        setSecondNumStr(secondNum);
        setOperator(operator);


    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) throws OperatorException {
        if (operator.equals("")) {
            throw new OperatorException("Cтрока не является математической операцией.");
        }
        this.operator = operator;
    }

    public String getFirstNumStr() {
        return firstNumStr;
    }

    public void setFirstNumStr(String firstNumStr) throws OperandException {
        if (firstNumStr == null) {
            throw new OperandException("Cтрока не является математической операцией.");
        } else if ((arabicRomanNumAndOperators.getrRomanToArabicNumm().containsKey(firstNumStr)) | (arabicRomanNumAndOperators.getrRomanToArabicNumm().containsValue(firstNumStr))) {
            this.firstNumInt = ConvertToInt(firstNumStr);
        } else {
            throw new OperandException("Число слишком большое. Введите новое.");
        }
    }

    public String getSecondNumStr() {
        return secondNumStr;
    }

    public void setSecondNumStr(String secondNumStr) throws OperandException {
        if (secondNumStr == null) {
            throw new OperandException("Cтрока не является математической операцией.");
        } else if ((arabicRomanNumAndOperators.getrRomanToArabicNumm().containsKey(secondNumStr)) | (arabicRomanNumAndOperators.getrRomanToArabicNumm().containsValue(secondNumStr))) {
            this.secondNumInt = ConvertToInt(secondNumStr);
        } else {
            throw new OperandException("Число слишком большое. Введите новое.");
        }

    }

    public int getFirstNumInt() {
        return firstNumInt;
    }

    public void setFirstNumInt(int firstNumInt) {
        this.firstNumInt = firstNumInt;
    }

    public int getSecondNumInt() {
        return secondNumInt;
    }

    public void setSecondNumInt(int secondNumInt) {
        this.secondNumInt = secondNumInt;
    }

    public ArabicRomanNumAndOperators getArabicRomanNumAndOperators() {
        return arabicRomanNumAndOperators;
    }

    public void setArabicRomanNumAndOperators(ArabicRomanNumAndOperators arabicRomanNumAndOperators) {
        this.arabicRomanNumAndOperators = arabicRomanNumAndOperators;
    }

    private int ConvertToInt(String s) {
        if (arabicRomanNumAndOperators.getrRomanToArabicNumm().containsKey(s)) {
            isRoman = true;
            return Integer.parseInt(arabicRomanNumAndOperators.getrRomanToArabicNumm().get(s));
        } else {
            isArabic = true;
            return Integer.parseInt(s);
        }
    }

    public String Calculate() throws OperandException {
        if (isArabic & isRoman) {
            throw new OperandException("Операция не может быть выполнена между арабскими и рисмскими цифрами.");
        } else if (isArabic & !isRoman) {
            return String.format("Результат операции: %d", CalculateArabic());
        } else {
            return String.format("Результат операции: %s", CalculateRoman());
        }

    }

    private int CalculateArabic() {
        switch (operator) {
            case "+":
                return firstNumInt + secondNumInt;
            case "-":
                return firstNumInt - secondNumInt;
            case "*":
                return firstNumInt * secondNumInt;
            case "/":
                return firstNumInt / secondNumInt;
        }
        return 0;

    }

    private String CalculateRoman() throws OperandException {
        int result;
        switch (operator) {
            case "+":
                result = firstNumInt + secondNumInt;
                return ConvertArabicToRoman(result);
            case "-":
                if ((firstNumInt < secondNumInt) | (firstNumInt == secondNumInt)) {
                    throw new OperandException("Операция не возможна. В римской системе нет отрицательных чисел и НУЛЯ");
                }
                result = firstNumInt - secondNumInt;
                return ConvertArabicToRoman(result);
            case "*":
                result = firstNumInt * secondNumInt;
                return ConvertArabicToRoman(result);
            case "/":
                if (firstNumInt < secondNumInt) {
                    throw new OperandException("Операция не возможна. В римской системе нет НУЛЯ.");
                }
                result = firstNumInt / secondNumInt;
                return ConvertArabicToRoman(result);
        }
        return "Такого оператора не существует.";
    }

    private String ConvertArabicToRoman(int Num) {
        String romanNum = "";
        int newNum = Num;

        Object[] key = arabicRomanNumAndOperators.getArabicToRomanNum().keySet().toArray();

        Arrays.sort(key);

        while (newNum > 0) {
            for (int i = (key.length - 1); i >= 0; i--) {
                int specKey = (int) key[i];
                if (newNum % specKey < newNum) {
                    romanNum += arabicRomanNumAndOperators.getArabicToRomanNum().get(specKey);
                    newNum -= specKey;
                    break;
                }
            }

        }
        return romanNum;
    }


}
