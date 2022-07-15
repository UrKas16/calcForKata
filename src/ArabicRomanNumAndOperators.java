import java.util.ArrayList;
import java.util.HashMap;

class ArabicRomanNumAndOperators {
    private final ArrayList<String> operators;
    private final ArrayList<String> romanNum;
    private final HashMap<String, String> arabicRomanNum;

    public ArabicRomanNumAndOperators(){
        arabicRomanNum = new HashMap<>();

        arabicRomanNum.put("0", "0");
        arabicRomanNum.put("I", "1");
        arabicRomanNum.put("II", "2");
        arabicRomanNum.put("III", "3");
        arabicRomanNum.put("IV", "4");
        arabicRomanNum.put("V", "5");
        arabicRomanNum.put("VI", "6");
        arabicRomanNum.put("VII", "7");
        arabicRomanNum.put("VIII", "8");
        arabicRomanNum.put("IX", "9");
        arabicRomanNum.put("X", "10");
       // arabicRomanNum.put("L", "50");
      //  arabicRomanNum.put("C", "100");

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

    public HashMap<String, String> getArabicRomanNum(){
        return arabicRomanNum;
    }

    public ArrayList<String> getOperators(){
        return operators;
    }

    public ArrayList<String> getRomanNum() {
        return romanNum;
    }
}
