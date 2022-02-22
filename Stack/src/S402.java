import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangshu
 * @date 2022-02-22 10:27
 */
public class S402 {

    public String removeKdigits(String num, int k) {
        char[] nums = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && k > 0) {
                while (!stack.isEmpty() && nums[i] < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                if (nums[i] != '0') {
                    stack.push(nums[i]);
                }
            } else {
                stack.push(nums[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString().length() == 0 ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        new S402().removeKdigits("1432219", 3);
    }
}
