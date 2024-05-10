public class Calculator {
    private int arg1;
    private int arg2;
    private char sign;

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void calculate() {
        switch (sign) {
            case '+':
                System.out.println(arg1 + arg2);
                break;
            case '-':
                System.out.println(arg1 - arg2);
                break;
            case '*':
                System.out.println(arg1 * arg2);
                break;
            case '/':
                System.out.println(arg1 / arg2);
                break;
            case '%':
                System.out.println(arg1 % arg2);
                break;
            case '^':
                int result = 1;
                for (int i = 1; i <= arg2; i++) {
                    result *= arg1;
                }
                System.out.println(result);
                break;
            default:
                System.out.println("мат. операция не поддерживается");
        }
    }
}