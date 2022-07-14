import javax.management.OperationsException;

class Calculator {
    private String operator;
    private String firstNumStr;
    private String secondNumStr;
    private int firstNumInt;
    private int secondNumInt;
    private ArabicRomanNumAndOperators arabicRomanNumAndOperators;


    public Calculator(String firstNum, String secondNum, String operator) throws OperatorException, OperandException {
        arabicRomanNumAndOperators = new ArabicRomanNumAndOperators();
        setFirstNumStr(firstNum);
        setOperator(operator);


    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) throws OperatorException{
        if (operator.equals("")){
           throw new OperatorException("Cтрока не является математической операцией.");
        }
        this.operator = operator;
    }

    public String getFirstNumStr() {
        return firstNumStr;
    }

    public void setFirstNumStr(String firstNumStr) throws OperandException {
        if ((arabicRomanNumAndOperators.getArabicRomanNum().containsKey(firstNumStr)) | (arabicRomanNumAndOperators.getArabicRomanNum().containsValue(firstNumStr))){
           this.firstNumInt = ConvertToInt(firstNumStr);
           if (this.firstNumInt > 10){
               throw new OperandException("lkjl");
           }
        }
        this.firstNumStr = firstNumStr;
    }

    public String getSecondNumStr() {
        return secondNumStr;
    }

    public void setSecondNumStr(String secondNumStr) {
        this.secondNumStr = secondNumStr;
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

    private int ConvertToInt(String s){
        if (arabicRomanNumAndOperators.getArabicRomanNum().containsKey(s)){
            return Integer.parseInt(arabicRomanNumAndOperators.getArabicRomanNum().getOrDefault(s, null));
        } else {
            return Integer.parseInt(s);
        }
    }
}
