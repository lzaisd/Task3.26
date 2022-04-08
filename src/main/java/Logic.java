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

        return recursion(0, str, str.length) == 0;
    }

    private static int recursion(int firstNum, char[] str, int count) {
        if (str.length == 1) {
            return -1;
        }

        for (int i = firstNum + 1; i < str.length; i++) {
            if (checkIfBracketsMatch(String.valueOf(str[firstNum]), str[i])) {
                count -= 2;
                str[i] = '-';
                break;
            }
        }

        firstNum += 1;

        if (firstNum != str.length - 1 && firstNum != str.length - 1) {
            count = recursion(firstNum, str, count);
        }

        return count;
    }

    private static void checkIfArrIsEmpty(char[] str) throws Exception {
        if (str.length == 0) {
            throw new Exception("Пустая строка");
        }
    }
}
