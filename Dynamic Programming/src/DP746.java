/**
 * @author tree
 * @date 2022/2/21 18:31
 * 746. 使用最小花费爬楼梯
 * @href https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class DP746 {

    public int minCostClimbingStairs(int[] cost) {
        int minCost0 = 0;
        int minCost1 = 0;
        int minCost = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            minCost = Math.min(minCost0 + cost[i - 2], minCost1 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }
        return minCost;
    }


    public static void main(String[] args) {
        DP746 main = new DP746();
        int res = main.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(res);
    }
}
