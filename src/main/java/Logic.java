import java.util.Stack;

public class Logic {
    public static boolean checkIfStructureIsCorrectSimpleStack(char[] str) throws Exception {
        SimpleLinkedListStack<String> openingBrackets = new SimpleLinkedListStack<>();
        checkIfArrIsEmpty(str);

        for (char c : str) {
            if (c == '(' || c == '{' || c == '[') {
                openingBrackets.push(String.valueOf(c));
            }
            if (c == ')' || c == '}' || c == ']') {
                if (openingBrackets.empty()) {
                    return false;
                } else {
                    if (!checkIfBracketsMatch(openingBrackets.peek(), c)) {
                        return false;
                    }
                    openingBrackets.pop();
                }
            }
        }

        return openingBrackets.empty();
    }

    public static boolean checkIfStructureIsCorrectStack(char[] str) throws Exception {
        Stack<String> openingBrackets = new Stack<>();
        checkIfArrIsEmpty(str);

        for (char c : str) {
            if (c == '(' || c == '{' || c == '[') {
                openingBrackets.push(String.valueOf(c));
            }
            if (c == ')' || c == '}' || c == ']') {
                if (openingBrackets.empty()) {
                    return false;
                } else {
                    if (!checkIfBracketsMatch(openingBrackets.peek(), c)) {
                        return false;
                    }
                    openingBrackets.pop();
                }
            }
        }

        return openingBrackets.empty();
    }

    private static boolean checkIfBracketsMatch (String bracketOpen, char bracketClose) {
        if (bracketOpen.equals("(") && bracketClose == ')') {
            return true;
        }
        if (bracketOpen.equals("{") && bracketClose == '}') {
            return true;
        }
        if (bracketOpen.equals("[") && bracketClose == ']') {
            return true;
        }
        return false;
    }


    public static boolean checkIfStructureIsCorrectRecursion(char[] str) throws Exception {
        checkIfArrIsEmpty(str);

        return recursion(String.valueOf(str), 0) == str.length;
    }

    private static int recursion(String sequence, int position) {
        if (position >= sequence.length()) {
            return position;
        }

        char bracket = sequence.charAt(position);

        if (bracket == '(' || bracket == '[' || bracket == '{') {
            int closeBracketPos = recursion(sequence, position + 1);
            if (closeBracketPos == -1) {
                return -1;
            }

            if (!checkIfBracketsMatch(String.valueOf(bracket), sequence.charAt(closeBracketPos))) {
                return -1;
            }
            else {
                return recursion(sequence, closeBracketPos + 1);
            }
        } else if (bracket == ')' || bracket == ']' || bracket == '}') {
            return position;
        } else {
            return -1;
        }
    }

    private static void checkIfArrIsEmpty(char[] str) throws Exception {
        if (str.length == 0) {
            throw new Exception("Пустая строка");
        }
    }
}
