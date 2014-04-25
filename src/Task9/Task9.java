package Task9;

import java.util.Stack;

/**
 * 9.Задана строка, содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * Использовать стек.
 * Created by vipmax on 15.04.2014.
 */
public class Task9 {


    public Task9() {
        new Task9Form(this);
    }

    private boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }

    /**
     * Проверить правильность расстановки скобок.
     * @param input текст
     * @return правильность расстановки скобок в тексте
     */
    public boolean validate(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
