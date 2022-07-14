class ParserEquation {
    // private String equation;
    private String firstNum;
    private String secondNum;
    private String operation;
    private final ArabicRomanNumAndOperators arabicRomanNumAndOperators;


    public ParserEquation() {
        this.arabicRomanNumAndOperators = new ArabicRomanNumAndOperators();
        firstNum = "";
        secondNum = "";
        operation = "";
    }

    //  public void setEquation(String equation) {
    //      this.equation = equation.trim();
    //   }

    public String getFirstNum() {
        return this.firstNum;
    }

    public void setFirstNum(String firstNum) {
        this.firstNum = firstNum;
    }

    public String getSecondNum() {
        return this.secondNum;
    }

    public void setSecondNum(String secondNum) {
        this.secondNum = secondNum;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void ParseString(String s) {
        for (int i = 0; i < s.length(); i++) {
            String operand = Character.toString(s.charAt(i));
            if (operand.equals(" ")){
                continue;
            }

            if (arabicRomanNumAndOperators.getOperators().contains(operand)) {
                setOperation(operand);
                continue;
            }

            if (operation.equals("")) {
                firstNum += operand;
            } else {
                secondNum += operand;

            }
        }

    }


}

