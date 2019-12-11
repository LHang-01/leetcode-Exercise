package array;

public class Num80 {
    public static void main(String[] arrs){
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 99.91%
     * 的用户
     * 内存消耗 :
     * 37.5 MB
     * , 在所有 java 提交中击败了
     * 94.07%
     * 的用户
     *
     * 双指针：start记录数据第一个位置，end记录相同数据的最后位置+1，length记录数据的返回个数
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int length = 0;
        int start = 0;
        int end ;
        while (start<nums.length){
            end =start+1;
            while (end<nums.length){
                if (nums[end]==nums[end-1]){
                    end++;
                }else {
                    break;
                }
            }
            if (end-1-start==0){
                nums[length]=nums[start];
                length+=1;
            }else {
                nums[length]=nums[start];
                nums[length+1]=nums[start];
                length+=2;
            }
            start=end;
        }
        return length;
    }
}
