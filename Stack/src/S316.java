import java.util.*;

/**
 * @author zhangshu
 * @date 2022-02-22 10:27
 */
public class S316 {

    public String removeDuplicateLetters(String s) {
        Map<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> tmp = new ArrayDeque<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, null);
                stack.push(c);
            } else {
                // TODO: 2022/2/22 CHANGE 
                if (c < stack.peek()) {
                    while (stack.peek() != c) {
                        tmp.push(stack.pop());
                    }
                    stack.pop();
                    while (!tmp.isEmpty()) {
                        stack.push(tmp.pop());
                    }
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }


}
