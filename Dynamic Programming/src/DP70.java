/**
 * @author tree
 * @date 2022/2/21 18:18
 * 70. 爬楼梯 - Climbing Stairs
 * @href https://leetcode-cn.com/problems/climbing-stairs/
 */
public class DP70 {

    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int dp0 = 1, dp1 = 2;
        int dp2 = -1;
        for(int i = 2; i < n; i++){
            dp2 = dp1 + dp0;
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }

    public static void main(String[] args) {
        DP70 main = new DP70();
        int n;
        n = args.length > 0 ? Integer.parseInt(args[0]) : 4;
        int res = main.climbStairs(n);
        System.out.println(res);


    }


}
