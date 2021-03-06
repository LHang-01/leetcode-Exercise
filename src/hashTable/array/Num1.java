package hashTable.array;

import java.util.HashMap;

/**
 * 标签：数组、哈希表
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
     * 执行用时 :3 ms, 在所有 java 提交中击败了98.19%的用户
     * 内存消耗 :37.1 MB, 在所有 java 提交中击败了91.84%的用户
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 利用哈哈希表，实现一遍遍历得到结果，边遍历边查询map中是否有满足要求的值。
     * 在进行迭代并将元素插入到表中的同时，还回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
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

    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
