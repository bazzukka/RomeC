
import java.util.Scanner;

public class Main {
    public static String num1lol;
    public static String num2lol;
    public static String oper = "";

    public static void ClearAll(String All){
        String numdublol = "";
        String numdublol2 = "";

        for( int i = 0 ; i < All.length(); i++){
 
            char k  =  All.charAt(i);
            if (k == '+' || k == '-' || k  == '/' || k == '*'){ 
 
                int pop = 0;
                int pep = All.length() - 1;
                while(pop < i){               
                    numdublol2 += new StringBuilder().append(All.charAt(pop)).toString();
                    pop++;
                }
                while(pep <= i != true){       
                    numdublol += new StringBuilder().append(All.charAt(pep)).toString();
                    pep--;
                }
                oper = new StringBuilder().append(All.charAt(i)).toString();  
                break;
            }
        }
       numdublol2 = numdublol2.replaceAll("\\s+","");                      
       numdublol = new StringBuffer(numdublol).reverse().toString();
       numdublol = numdublol.replaceAll("\\s+","");
       num1lol = numdublol2;                                         
       num2lol = numdublol;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RomanCalculator roman;
        ArabicCalculator arabic;
        
        System.out.println("Input: ");
        String input = in.nextLine();
        double output = 0;
        String All = input;
        ClearAll(All);
        char lol1 = num1lol.charAt(0);
        char lol2 = num2lol.charAt(0);
        String[] tokens = input.split(" ");
        if(tokens.length <= 3){
            try {
                if (Character.isDigit(lol1) && Character.isDigit(lol2)) {
                    int a = convertToInt(tokens[0]);
                    int b = convertToInt(tokens[2]);
                    char op = tokens[1].charAt(0);
                    if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
                        if (op == '+' || op == '*' || op == '/' || op == '-') {
                            arabic = new ArabicCalculator(a, op, b);
                            output = arabic.calculateResult();
                            System.out.println("Output: ");
                            System.out.println(output);
                        } else {
                            System.out.println("Invalid Operator!");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("a & b you can use only 1 - 10");
                        System.exit(0);
                    }
                }
                else if (!(Character.isDigit(lol1) && Character.isDigit(lol2))) {
                    if(validateRoman(tokens[0]) && validateRoman(tokens[2])){
                        String a = tokens[0];
                        char op = tokens[1].charAt(0);
                        String b = tokens[2];
                        if (op == '+' || op == '*' || op == '/' || op == '-') {
                            roman = new RomanCalculator(a, op, b);
                            String out = roman.calculateResult();
                            System.out.println("Output: ");
                            System.out.println(out);
                        } else {
                            System.out.println("Invalid Operator!");
                            System.exit(0);
                        }
                    }
                    else{
                        System.out.println("a & b you can use only I - X");
                        System.exit(0);
                    }
                }
                else{
                    System.out.println("Invalid Input Values!");
                    System.exit(0);
                }
            }   catch (Exception ex) {
                System.out.println("Invalid Input Format!");
                System.exit(0);
            }

        }

        else {
            System.out.println("To match operations");
            System.exit(0);
        }
    }

    public static int convertToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception ex) {
            System.out.println("Invalid Input Format! X + X");
            System.exit(0);
        }
        return 0;
    }

    public static boolean validateRoman(String str) {
        if(str.equals("I") || str.equals("II") || str.equals("III") || str.equals("IV") || str.equals("V") ||
                str.equals("VI") || str.equals("VII") || str.equals("VIII") || str.equals("IX") ||
                str.equals("X")){
            return true;
        }
        return false;
    }
}
