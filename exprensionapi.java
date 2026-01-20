package backend;

public class ExpressionParser {

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
            } else {
                result.append(" ");
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop()).append(" ");
                stack.push(ch);
            }
        }
        while (!stack.isEmpty())
            result.append(" ").append(stack.pop());

        return result.toString();
    }

    public static double evaluatePostfix(String exp) {
        Stack<Double> stack = new Stack<>();

        for (String token : exp.split(" ")) {
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}
