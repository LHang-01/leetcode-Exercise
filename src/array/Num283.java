package array;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Num283 {
    /**
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 : 37.6 MB, 在所有 java 提交中击败了95.46%的用户
     * 该题等同于“将所有非 0 元素置于数组前面，保持它们的相对顺序相同”
     * 双指针：循环判断当前指针位置上是否不为0，并用pre记录不为零的个数，当不为零时，将当前的值，复制到num[pre]上.
     *         当遍历完一遍之后，已经统计完所有的非零个数pre，并且已经把非零的数字按原顺序复制到了数组前面，则只需将剩下的[pre,nums.length-1]全部填充为0，即可。
     *
     * 时间复杂度：O(n)。
     * 空间复杂度：O(1)，只使用了常量空间。
     */
    public void moveZeroes1(int[] nums) {
        int pre=0;
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

    /**
     * 优化上面的双指针方法：当遍历完一遍之后，还需将剩下的[pre,nums.length-1]全部填充为0。
     *                      其实，在一遍遍历过程中，将当前位置上的数字复制后，再将当前位置置0，这样就不用再次返工填充0.
     */
    public void moveZeroes2(int[] nums) {
        int num=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                if (i!=num){
                    nums[num]=nums[i];
                    nums[i]=0;
                }
                num++;
            }
        }
    }
}
