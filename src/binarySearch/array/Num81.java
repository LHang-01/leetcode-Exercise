package binarySearch.array;

/**
 *81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 示例 1：输入: nums = [2,5,6,0,0,1,2], target = 0 输出: true
 * 示例 2: 输入: nums = [2,5,6,0,0,1,2], target = 3 输出: false
 */
public class Num81 {
    /**
     * 本题是需要使用二分查找，怎么分是关键，举个例子：
     * 第一类
     * 1011110111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
     * 第二类
     * 22 33 44 55 66 77 11 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
     * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
     * 第三类
     * 66 77 11 22 33 44 55 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
     * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了99.71%的用户
     * 内存消耗 :38.6 MB, 在所有 java 提交中击败了32.44%的用户
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start=0;
        int end=nums.length-1;
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start]==nums[mid]){
                //无法判断哪部分更长，只能排除start、mid位置
                start++;
                mid++;
            }else if (nums[start] < nums[mid]){
                //前半部分有序的长度更长
                if (target>=nums[start]&&target<nums[mid]){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            }else {
                //后半部分有序的长度更长
                if (target>nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return false;
    }
}
