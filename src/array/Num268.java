package array;

import java.util.HashSet;

/**
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class Num268 {
    /**
     * 哈希表
     * 执行用时 : 12 ms, 在所有 java 提交中击败了12.11%的用户
     * 内存消耗 :39.1 MB , 在所有 java 提交中击败了97.34%的用户
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int i =0;
        for (;i<=nums.length;i++){
            if (!set.remove(i)){
                break;
            }
        }
        return i;
    }
    /**
     * 用 高斯求和公式 求出 [0..n]的和，减去数组中所有数的和，就得到了缺失的数字。
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 94.65%
     * 的用户
     * 内存消耗 :
     * 40.4 MB
     * , 在所有 java 提交中击败了
     * 93.60%
     * 的用户
     *
     */
    public int missingNumber2(int[] nums) {
        int sum;
        if ((nums.length+1)%2==0){
            sum=(nums.length+1)/2*nums.length;
        }else {
            sum=(nums.length+1)/2*nums.length+(nums.length+1)/2;
        }
        for (int num:nums){
            sum=sum-num;
        }
        return sum;
    }
}
