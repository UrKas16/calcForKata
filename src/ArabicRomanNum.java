import java.util.HashMap;

class ArabicRomanNum {
    private HashMap<Integer, String> arabicRomanNum;

    public ArabicRomanNum(){
        arabicRomanNum = new HashMap<>();

        arabicRomanNum.put(1, "I");
        arabicRomanNum.put(2, "II");
        arabicRomanNum.put(3, "III");
        arabicRomanNum.put(4, "IV");
        arabicRomanNum.put(5, "V");
        arabicRomanNum.put(6, "VI");
        arabicRomanNum.put(7, "VII");
        arabicRomanNum.put(8, "VIII");
        arabicRomanNum.put(9, "IX");
        arabicRomanNum.put(10, "X");
    }

    public HashMap<Integer,String> getArabicRomanNum(){
        return arabicRomanNum;
    }




}
