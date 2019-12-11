package array;

/**
 * 31. 下一个排列
 *
 */
public class Num33 {
    public static void main(String[] arrs){
        search(new int[]{4, 5, 6, 7, 0, 1, 2},0);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 86.83%
     * 的用户
     * 内存消耗 :
     * 36.8 MB
     * , 在所有 java 提交中击败了
     * 83.21%
     * 的用户
     *
     * 用二分法：分成四种情况讨论
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start=0;
        int end=nums.length-1;
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序的长度更长
            if (nums[start] <= nums[mid]) {
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
        return -1;
    }
}
