import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class ConvertorArabicRomanNum {

    private int firstNum;
    private int secondNum;

    private boolean isRoman;
    private boolean isArabic;
    private final ArrayList<String> operators;
    private final ArrayList<String> romanNum;
    private final HashMap<String, String> romanToArabicNum;
    private final HashMap<Integer, String> arabicToRomanNum;

    public ConvertorArabicRomanNum() {
        romanToArabicNum = new HashMap<>();

        romanToArabicNum.put("0", "0");
        romanToArabicNum.put("I", "1");
        romanToArabicNum.put("II", "2");
        romanToArabicNum.put("III", "3");
        romanToArabicNum.put("IV", "4");
        romanToArabicNum.put("V", "5");
        romanToArabicNum.put("VI", "6");
        romanToArabicNum.put("VII", "7");
        romanToArabicNum.put("VIII", "8");
        romanToArabicNum.put("IX", "9");
        romanToArabicNum.put("X", "10");

        arabicToRomanNum = new HashMap<>();

        arabicToRomanNum.put(1, "I");
        arabicToRomanNum.put(2, "II");
        arabicToRomanNum.put(3, "III");
        arabicToRomanNum.put(4, "IV");
        arabicToRomanNum.put(5, "V");
        arabicToRomanNum.put(6, "VI");
        arabicToRomanNum.put(7, "VII");
        arabicToRomanNum.put(8, "VIII");
        arabicToRomanNum.put(9, "IX");
        arabicToRomanNum.put(10, "X");
        arabicToRomanNum.put(40, "XL");
        arabicToRomanNum.put(50, "L");
        arabicToRomanNum.put(90, "XC");
        arabicToRomanNum.put(100, "C");

        operators = new ArrayList<>();

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        romanNum = new ArrayList<>();

        romanNum.add("I");
        romanNum.add("V");
        romanNum.add("X");

    }

    public ConvertorArabicRomanNum(String firstNum, String secondNum) throws OperandException {
        this();
        setFirstNum(firstNum);
        setSecondNum(secondNum);
    }


    public HashMap<String, String> getRomanToArabicNum() {
        return romanToArabicNum;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public HashMap<Integer, String> getArabicToRomanNum() {
        return arabicToRomanNum;
    }

    public ArrayList<String> getRomanNum() {
        return romanNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(String firstNum) throws OperandException {
        if ((firstNum == "") | (firstNum == " ")) {
            throw new OperandException("Cтрока не является математической операцией.");
        } else if ((getRomanToArabicNum().containsKey(firstNum)) | (getRomanToArabicNum().containsValue(firstNum))) {
            this.firstNum = ConvertToInt(firstNum);
        } else {
            throw new OperandException("Число слишком большое. Введите новое.");
        }
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(String secondNum) throws OperandException {
        if ((secondNum == "") | (secondNum == " ")) {
            throw new OperandException("Cтрока не является математической операцией.");
        }  else if ((getRomanToArabicNum().containsKey(secondNum)) | (getRomanToArabicNum().containsValue(secondNum))) {
            this.secondNum = ConvertToInt(secondNum);
        } else {
            throw new OperandException("Число слишком большое. Введите новое.");
        }
    }

    public boolean isRoman() {
        return isRoman;
    }

    public boolean isArabic() {
        return isArabic;
    }

    public String ConvertArabicToRoman(int Num) {
        String romanNum = "";
        int newNum = Num;

        Object[] key = getArabicToRomanNum().keySet().toArray();

        Arrays.sort(key);

        while (newNum > 0) {
            for (int i = (key.length - 1); i >= 0; i--) {
                int specKey = (int) key[i];
                if (newNum % specKey < newNum) {
                    romanNum += getArabicToRomanNum().get(specKey);
                    newNum -= specKey;
                    break;
                }
            }
        }
        return romanNum;
    }

    private int ConvertToInt(String num) {
        if (getRomanToArabicNum().containsKey(num)) {
            isRoman = true;
            return Integer.parseInt(getRomanToArabicNum().get(num));
        } else {
            isArabic = true;
            return Integer.parseInt(num);
        }
    }

}
