import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class ArabicRomanNumAndOperators {
    private final ArrayList<String> operators;
    private final ArrayList<String> romanNum;
    private final HashMap<String, String> romanToArabicNum;
    private final HashMap<Integer, String> arabicToRomanNum;

    public ArabicRomanNumAndOperators() {
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

    public HashMap<String, String> getrRomanToArabicNumm() {
        return romanToArabicNum;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public HashMap<Integer, String> getArabicToRomanNum(){
        return arabicToRomanNum;
    }

    public ArrayList<String> getRomanNum() {
        return romanNum;
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

}
