import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zhangshu
 * @date 2022-02-22 10:26
 * 739. 每日温度 - Daily Temperatures
 * @href https://leetcode-cn.com/problems/daily-temperatures/
 */
public class S739 {

    // [73,74,75,71,69,72,76,73]
    // [1,1,4,2,1,1,0,0]

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int cur = stack.pop();
                res[cur] = i - cur;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = new S739().dailyTemperatures(temperatures);
        Arrays.stream(res).forEach(System.out::println);
    }

}
