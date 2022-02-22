import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author zhangshu
 * @date 2022-02-22 10:06
 * 84. 柱状图中最大的矩形 - Largest Rectangle in Histogram
 * @href https://leetcode-cn.com/problems/largest-rectangle-in-histogram/\
 */
public class S84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        // 2 1 5 6 2 3
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];

                while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                    stack.pop();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peek() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                stack.pop();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peek() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    /**
     * 带哨兵优化代码
     * TODO 未学习
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
