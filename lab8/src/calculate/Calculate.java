package calculate;

import java.util.Stack;

public class Calculate {

    public static int checkPriority(char operationSign){
        switch(operationSign) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                throw new IllegalStateException("Podano niepoprawna wartosc: " + operationSign);
        }
    }

    public static String shuntingYardAlgorithm(String input){
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i<input.length(); i++){
            char sign = input.charAt(i);

            if (Character.isDigit(sign) || sign == '.')
                result += sign;
            else if (sign =='(')
                stack.push(sign);
            else if (sign == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += " " + stack.pop();
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && checkPriority(sign) <= checkPriority(stack.peek())) {
                    result += " " + stack.pop();
                }
                result += " ";
                stack.push(sign);

        }
    }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Niewłaściwa pozycja (";
            result += " " + stack.pop();
        }

        return result;
    }

    public static double computeOperation(char operationSign, double a, double b){
        switch(operationSign){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                throw new IllegalStateException("Niepoprawna wartosc: " + operationSign);
        }
    }

    public static double calculation (String input) {
        String a,b, temp = "";
        double result;
        Stack<String> stack = new Stack<>();

        for(int i = 0;i<input.length();i++){
            Character ch = input.charAt(i);
            if(ch == ' '){
                stack.push(temp);
                temp = "";
            }
            else if(Character.isDigit(ch) || ch == '.')
                temp += ch;
            else{
                b = stack.pop();
                a = stack.pop();
                result = computeOperation(ch, Double.valueOf(a), Double.valueOf(b));
                stack.push(String.valueOf(result));
                i++;
            }
        }
        return Double.valueOf(stack.pop());
        }
}
