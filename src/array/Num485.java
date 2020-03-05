package array;

/**
 * 485. 最大连续1的个数
 * 示例 1: 输入: [1,1,0,1,1,1] 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意： 输入的数组只包含0 和1。
 *        输入数组的长度是正整数，且不超过 10,000。
 */
public class Num485 {
    /**
     * 执行用时 : 2 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.1 MB , 在所有 java 提交中击败了 94.95% 的用户
     * 方法：一次遍历，当没遇到0之前，计算本次连续1的个数now；直到遇到0时，将本次连续1的个数now与历史中的最大连续1个个数比较，并把最大的又存入pre中，
     * 再判断是否遍历完，若没遍历完数组，则继续遍历。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int pre =0;
        for (int i = 0;i<nums.length;i++){
            int now=0;
            //没遇到0之前，计算本次连续1的个数now
            while (i<nums.length&&nums[i]==1){
                now++;
                i++;
            }
            //遇到0或者遍历完成时，将本次连续1的个数now与历史中的最大连续1个个数比较，并把最大的又存入pre中
            if (now>pre){
                pre=now;
            }
        }
        return pre;
    }
}
