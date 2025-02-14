public class CodeValidator {

    public static boolean checkBrackets(String code) {
        DsalStack<Character> stack = new DsalStack<>();
        for (char c : code.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char current = stack.pop();
                switch (current) {
                    case '(':
                        if (c != ')') {
                            return false;
                        }
                        break;
                    case '{':
                        if (c != '}') {
                            return false;
                        }
                        break;
                    case '[':
                        if (c != ']') {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }
}
