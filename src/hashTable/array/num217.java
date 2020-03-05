package hashTable.array;

import java.util.HashSet;

/**
 * 217.给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1: 输入: [1,2,3,1] 输出: true
 */
public class num217 {

    public static void main(String[] arrs){
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        int j =0;
        while (j<nums.length){
            if (set.contains(nums[j])){
                return true;
            }
            set.add(nums[j]);
            j++;
        }
        return false;

    }
}
