package array;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Num283 {
    /**
     * 执行用时 :
     * 0 ms , 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 :
     * 37.6 MB, 在所有 java 提交中击败了95.46%的用户
     * 双指针
     * 该题等同于“将所有非 0 元素置于数组前面，保持它们的相对顺序相同”
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int pre=0;
        int j;
        for (int now = 0;now<nums.length;now++) {
            if (nums[now]!=0){
                nums[pre]=nums[now];
                pre++;
            }
        }
        for (;pre<nums.length;pre++){
            nums[pre]=0;
        }
    }
}
