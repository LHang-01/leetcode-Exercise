package array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案.
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Num16 {
    public static void main(String[] arrs){
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

    /**
     * 执行用时 :
     * 5 ms
     * , 在所有 java 提交中击败了
     * 94.43%
     * 的用户
     * 内存消耗 :
     * 35.8 MB
     * , 在所有 java 提交中击败了
     * 85.17%
     * 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int preSum=nums[0] + nums[1] + nums[2];
        int sum = 0;
        int minCha = Math.abs(preSum-target);
        int k=0;
        while (k<nums.length-2){
            int i =k+1;
            int j=nums.length-1;
            while (i<j){
                sum = nums[k] + nums[i] + nums[j];
                if (Math.abs(sum-target)<minCha){
                    preSum=sum;
                    minCha=Math.abs(sum-target);
                }
                if (sum>target){
                    j--;
                }else if (sum<target){
                    i++;
                }else {
                    return sum;
                }
            }
            k++;
        }
        return preSum;
    }
}
