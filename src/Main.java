import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String validation = "vdwvd(sdfgf{shdj}sds[sdsd])";
        System.out.println(isValid(validation));
    }

    public static boolean isValid(String validation) {
        Stack<Character> validationStack = new Stack<>();
        for (int i = 0; i < validation.length(); i++) {
            char symbol = validation.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                validationStack.push(symbol);
            }
            if (validationStack.isEmpty() && (symbol == ')' || symbol == '}' || symbol == ']')) {
                return false;
            }

            switch (symbol) {
                case ')':
                    if (validationStack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (validationStack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (validationStack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return validationStack.isEmpty();
    }
}