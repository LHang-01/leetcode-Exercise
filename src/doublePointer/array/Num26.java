package doublePointer.array;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Num26 {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.98%的用户
     * 内存消耗 :49.2 MB, 在所有 Java 提交中击败了5.05%的用户
     *
     * 在遍历nums[i]值是否等于当前值nums[now]时，若相等先不交换，继续判断nums[i=i+1]值是否等于当前值nums[now]，
     * 一直循环下去直到i超过了数组长度（此时已经遍历完整个数组，因此此处返回ans）
     * 或者nums[i]不等于nums[now]时，记录非重复数值的个数ans自增一，nums[now+1]=nums[i],i和now向后移动一位，然后继续遍历数组。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int now = 0;now<nums.length;){
            int next = now+1;
            //如果下一个值=当前值，则next后移一位，直到遍历完数组或者下一个值!=当前值
            while (next<nums.length&&nums[now]==nums[next]){
                next++;
            }
            //则将最后一个等于原值的值nums[next-1]复制到index的位置。
            nums[index]=nums[next-1];
            index++;
            //判断是否遍历完，如遍历完，则提前结束
            if (next==nums.length){
                return index;
            }else {
                //若没有遍历完,now=不等于原值的第一个位置
                now=next;
            }
        }
        return index;
    }
}
