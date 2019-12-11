package array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 */
public class Num34 {
    public static void main(String[] arrs){
        searchRange(new int[]{5,7,7,8,8,10},8);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 43.6 MB
     * , 在所有 java 提交中击败了
     * 40.30%
     * 的用户
     *
     * 用二分查找到位置，再判断是否相等，若相等则分别向前和向后查找最边缘的相等数的位置
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while (start<=end){
            mid=(start+end)/2;
            if (nums[mid]==target){
                break;
            }else if (nums[mid]>target){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        if (nums[mid]!=target){
            return new int[]{-1,-1};
        }else {
            int[] ans = new int[2];
            int i=mid-1;
            while (i>=0&&nums[i]==target){
                i--;
            }
            ans[0]=i+1;
            i=mid+1;
            while (i<nums.length&&nums[i]==target){
                i++;
            }
            ans[1]=i-1;
            return ans;
        }
    }
}
