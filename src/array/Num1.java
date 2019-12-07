package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Num1 {
    /**
     * 执行用时 :
     * 3 ms
     * , 在所有 java 提交中击败了
     * 98.19%
     * 的用户
     * 内存消耗 :
     * 37.1 MB
     * , 在所有 java 提交中击败了
     * 91.84%
     * 的用户
     *
     * 利用哈哈希表，边遍历边查询map中是否有满足要求的值。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        while (!map.containsKey(target-nums[i])){
            map.put(nums[i],i);
            i++;
        }
        ans[1]=i;
        ans[0]=map.get(target-nums[i]);
        return ans;
    }

}
