import javax.management.OperationsException;

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
        if ((arabicRomanNumAndOperators.getArabicRomanNum().containsKey(firstNumStr)) | (arabicRomanNumAndOperators.getArabicRomanNum().containsValue(firstNumStr))) {
            this.firstNumInt = ConvertToInt(firstNumStr);
        } else {
            throw new OperandException("Число слишком большое. Введите новое.");
        }
    }

    public String getSecondNumStr() {
        return secondNumStr;
    }

    public void setSecondNumStr(String secondNumStr) throws OperandException {
        if ((arabicRomanNumAndOperators.getArabicRomanNum().containsKey(secondNumStr)) | (arabicRomanNumAndOperators.getArabicRomanNum().containsValue(secondNumStr))) {
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
        if (arabicRomanNumAndOperators.getArabicRomanNum().containsKey(s)) {
            isRoman = true;
            return Integer.parseInt(arabicRomanNumAndOperators.getArabicRomanNum().get(s));
        } else {
            isArabic = true;
            return Integer.parseInt(s);
        }
    }

    public int Calculate() throws OperandException{
        if (isArabic & isRoman) {
            throw new OperandException("Операция не может быть выполнена между арабскими и рисмскими цифрами.");
        }

        switch (operator) {
            case ("+"):
                return 0;


        }
        return 0;
    }
}
