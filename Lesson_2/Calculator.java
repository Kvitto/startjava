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
        int result = 0;
        switch (sign) {
            case '+' -> result = arg1 + arg2;
            case '-' -> result = arg1 - arg2;
            case '/' -> {
                System.out.println((double) arg1 / arg2);
                return;
            }
            case '*' -> result = arg1 * arg2;
            case '%' -> result = arg1 % arg2;
            case '^' -> {
                result = 1;
                for (int i = 1; i <= arg2; i++) {
                    result *= arg1;
                }
            }
            default -> {
                System.out.println("мат. операция не поддерживается");
                return;
            }
        }
        System.out.println(result);
    }
}