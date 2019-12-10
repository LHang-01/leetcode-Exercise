package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Num15 {
    public static void main(String[] arrs){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
    /**
     * （排序+双指针）
     *  先将给定 nums 排序，复杂度为 O(NlogN)O(NlogN)。
     * 双指针法思路： 固定 3 个指针中最左（最小）数字的指针 k，
     * 双指针 i，j 分设在数组索引 (k, len(nums))两端，通过双指针交替向中间移动，
     * 记录对于每个固定指针 k 的所有满足 nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     *
     * 注意：在k\i\j移动时，应该直接移动到不等于原值的位置。
     * 执行用时 :
     * 40 ms
     * , 在所有 java 提交中击败了
     * 68.28%
     * 的用户
     * 内存消耗 :
     * 47.4 MB
     * , 在所有 java 提交中击败了
     * 94.53%
     * 的用户
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int k=0;
        while (k<nums.length-2){
            if (nums[k]>0){
                break;
            }
            int i =k+1;
            int j=nums.length-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if (sum>0){
                    while (j>i&&nums[j]==nums[--j]){}
                }else if (sum<0){
                    while (i<j&&nums[i]==nums[++i]){}
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                    while (j>i&&nums[j]==nums[--j]){}
                    while (i<j&&nums[i]==nums[++i]){}
                }
            }
            while (k<nums.length-2&&nums[k]==nums[++k]){}
        }
        return lists;
    }
}
