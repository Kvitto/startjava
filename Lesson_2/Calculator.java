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
        String result;
        switch (sign) {
            case '+' -> result = String.valueOf(arg1 + arg2);
            case '-' -> result = String.valueOf(arg1 - arg2);
            case '*' -> result = String.valueOf(arg1 * arg2);
            case '/' -> result = String.valueOf(arg1 / arg2);
            case '%' -> result = String.valueOf(arg1 % arg2);
            case '^' -> {
                int caretResult = 1;
                for (int i = 1; i <= arg2; i++) {
                    caretResult *= arg1;
                }
                result = String.valueOf(caretResult);
            }
            default -> result = "мат. операция не поддерживается";
        }
        System.out.println(result);
    }
}