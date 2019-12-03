package dynamicPlanning;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 */
public class num264 {
    public static void main(String[] arrs){
        int arr = 10;
        System.out.println(nthUglyNumber(arr));
    }

    /**
     * 三指针+动态规划
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     * 因此，求丑数总是求min{系数2*2，系数3*3，系数4*5}
     * 其中系数就是在之前从dp[0]到dp[i]中存储的已经求得的丑数中取出来的。
     *
     * 5 ms, 在所有 java 提交中击败了71.92%的用户
     * 内存消耗 : 34.4 MB , 在所有 java 提交中击败了 33.03%的用户
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int count2=0;
        int count3=0;
        int count5=0;
        for (int i =1;i<n;i++){
            dp[i]=Math.min(Math.min(dp[count2]*2,dp[count3]*3),dp[count5]*5);
            if (dp[i]==dp[count2]*2){
                count2++;
            }
            if (dp[i]==dp[count3]*3){
                count3++;
            }
            if (dp[i]==dp[count5]*5){
                count5++;
            }
        }
        return dp[n-1];
    }
}
