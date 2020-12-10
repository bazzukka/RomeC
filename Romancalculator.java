
public class RomanCalculator {

    private String a;
    private String b;
    private char operator;

    public RomanCalculator(String a, char operator, String b) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public static String convertToRoman(int num) {
        int[] nums = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < nums.length; a++) {
            while (num >= nums[a]) {
                num -= nums[a];
                sb.append(romans[a]);
            }
        }
        return sb.toString();
    }

    public String calculateResult() {
        int ans = 0;
        if (operator == '+') {
            ans = convertToInt(a) + convertToInt(b);
        } else if (operator == '-') {
            ans = convertToInt(a) - convertToInt(b);
        } else if (operator == '/') {
            ans = convertToInt(a) / convertToInt(b);
        } else if (operator == '*') {
            ans = convertToInt(a) * convertToInt(b);
        }
        return convertToRoman(ans);
    }

    public int convertToInt(String num) {
        if (num.equals("I")) {
            return 1;
        } else if (num.equals("II")) {
            return 2;
        } else if (num.equals("III")) {
            return 3;
        } else if (num.equals("IV")) {
            return 4;
        } else if (num.equals("V")) {
            return 5;
        } else if (num.equals("VI")) {
            return 6;
        } else if (num.equals("VII")) {
            return 7;
        } else if (num.equals("VIII")) {
            return 8;
        } else if (num.equals("IX")) {
            return 9;
        } else if (num.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

} 
