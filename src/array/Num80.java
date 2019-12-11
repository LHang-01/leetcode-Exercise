package array;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Num80 {
    public static void main(String[] arrs){
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    /**
     * 执行用时 :
     * 1 ms, 在所有 java 提交中击败了99.91%的用户
     * 内存消耗 :
     * 37.5 MB, 在所有 java 提交中击败了94.07%的用户
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
            //如果元素的重复个数=0，即无重复元素，将下标为length的值替换为当前值，并且数组的有效个数更新
            if (end-1-start==0){
                nums[length]=nums[start];
                length+=1;
            }else {
                //如果元素的重复个数>0，有重复元素，将下标为length和length+1的值替换为当前值，并且数组的有效个数更新
                nums[length]=nums[start];
                nums[length+1]=nums[start];
                length+=2;
            }
            start=end;
        }
        return length;
    }
}
