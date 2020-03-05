package binarySearch.array;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 示例 1: 输入: [3,4,5,1,2] 输出: 1
 * 示例 2: 输入: [4,5,6,7,0,1,2] 输出: 0
 */
public class Num153 {
    public static void main(String [] arrs){
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
    /**
     * 二分法
     * 三种情况：数组正序、数组逆序、数组确实旋转了
     * 对数组确实旋转：根据nums[start] < nums[mid]，判断最小值在mid右边；
     *                根据nums[start] > nums[mid]，判断最小值在mid左边；
     *                根据nums[start]=nums[mid]，判断最小值在start和end之间，此时跳出循环；
     * 返回Math.min(Math.min(nums[start],nums[end]),Math.min(nums[0],nums[nums.length-1]))
     *
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.4 MB , 在所有 java 提交中击败了 40.66% 的用户
     */
    public static int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while (start<end){
            mid=(start+end)/2;
            if (nums[start]==nums[mid]){
                break;
            }else if (nums[start]<nums[mid]){
                start=mid;
            }else {
                end=mid;
            }
        }
        return Math.min(Math.min(nums[start],nums[end]),Math.min(nums[0],nums[nums.length-1]));
    }
}
