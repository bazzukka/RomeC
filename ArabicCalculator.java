
public class ArabicCalculator {

    private int a;
    private int b;
    char operator;

    public ArabicCalculator(int a, char operator, int b) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public double calculateResult() {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else if (operator == '/') {
            return a / b;
        } else if (operator == '*') {
            return a * b;
        }
        return 0;
    }

} 
