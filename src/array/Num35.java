package array;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class Num35 {
    /**
     * 方法：二分查找
     *
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.7 MB
     * , 在所有 java 提交中击败了
     * 60.17%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        if (target<=nums[0]) return 0;
        if (target>nums[nums.length-1]) return nums.length;
        if (target == nums[nums.length-1]) return nums.length-1;
        int min = 0;
        int max = nums.length-1;
        int mid ;
        while (min<=max){
            mid=(min+max)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                max = mid-1;
            }else {
                min = mid+1;
            }
        }
        return min;
    }
}
