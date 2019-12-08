package array;

/**
 * 27. 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Num27 {
    /**
     * 执行用时 :
     * 0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 36 MB, 在所有 java 提交中击败了84.18%的用户
     *
     * 跟Num26题目很像
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int i =0;i<nums.length;i++){
            while (i!=nums.length&&nums[i]==val){
                i++;
            }
            if (i==nums.length){
                return ans;
            }else {
                nums[ans]=nums[i];
                ans++;
            }
        }
        return ans;
    }
}
