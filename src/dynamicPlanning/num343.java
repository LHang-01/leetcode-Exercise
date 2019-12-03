package dynamicPlanning;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class num343 {
    public static void main(String[] arrs){
        System.out.println(integerBreak(8));
    }

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 70.65%的用户
     * 内存消耗 : 32.9 MB , 在所有 java 提交中击败了15.42%的用户
     *
     * 题目关键是：将其拆分为至少两个正整数的和
     * nums[i]记录的是i的整数的乘积最大值，因此，先把n拆分成两个数i-j,j；再比较nums[i-j]和i-j谁大谁小，
     * 若nums[i-j]更大，则就是把i-j拆分了，计算乘积时使用nums[i-j]；若i-j更大，则不拆分i-j，计算乘积时直接使用i-j。
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] nums = new int[n+1];
        nums[1]=1;
        for (int i=2;i<=n;i++){
            for (int j =1;j<=i/2;j++){
                //Math.max(nums[i-j],i-j）、Math.max(nums[j],j)是指取拆和不拆的最大值
                nums[i]=Math.max(nums[i],Math.max(nums[i-j],i-j)*Math.max(nums[j],j));
            }
        }
        return nums[n];
    }
}
