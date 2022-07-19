import org.jetbrains.annotations.NotNull;

class ParserEquation {
    // private String equation;
    private String firstNum;
    private String secondNum;
    private String operation;
    private final ConvertorArabicRomanNum convertorArabicRomanNum;

    public ParserEquation() {
        this.convertorArabicRomanNum = new ConvertorArabicRomanNum();
        firstNum = "";
        secondNum = "";
        operation = "";
    }

    public String getFirstNum() {
        return this.firstNum;
    }

    public String getSecondNum() {
        return this.secondNum;
    }

    public String getOperation() {
        return this.operation;
    }

    private void setOperation(String value) throws OperatorException{
        if (!operation.equals("")) {
            throw  new OperatorException("Формат математической операции не удовлетворяет заданию.");
        }
        operation = value;
    }

    public void ParseString(@NotNull String s) throws OperatorException {
        for (int i = 0; i < s.length(); i++) {
            String operand = Character.toString(s.charAt(i));
            if (operand.equals(" ")) {
                continue;
            }
            if (convertorArabicRomanNum.getOperators().contains(operand)) {
                setOperation(operand);
                continue;
            }
            if (operation.equals("")) {
                firstNum += operand;
            } else {
                secondNum += operand;
            }
        }

        if (operation.equals("")) {
            throw new OperatorException("Строка не является арифметическим выражением.");
        }

    }
}

