package array;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *
 * 示例 1: 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4]
 * 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2: 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100]
 * 解释: 向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明: 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *       要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Num189 {

    public static void main(String[] arrs){
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        rotate(nums, k);
    }
    /**
     * 方法 3：使用环状替换
     *
     * 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temp里面。
     * 然后，我们将被替换数字（temp）放到它正确的位置，并继续这个过程n次，n是数组的长度。这是因为我们需要将数组里所有的元素都移动。
     * 但是，这种方法可能会有个问题，如果n%k==0，其中k=k%n。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
     *
     * 当旋转一圈后，若j==start，则需要跳出while循环，将j=start+1,继续循环。
     * 当旋转后j!=start时，直接循环到k次，就能得到结果。
     * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/

     * 执行用时 : 1 ms , 在所有 java 提交中击败了 84.56% 的用户
     * 内存消耗 : 36.5 MB , 在所有 java 提交中击败了 95.45% 的用户
     *
     * 时间复杂度：O(n)O(n) 。只遍历了每个元素一次。
     * 空间复杂度：O(1)O(1) 。使用了常数个额外空间。
     */
    public static void rotate(int[] nums, int k) {
        //当数组为空、数组只有一个元素、或者旋转后顺序不变的情况下，不改变原数组，直接返回。
        if (nums==null||nums.length==1||k%nums.length==0) return;
        int i = nums.length;
        k=k%i;
        int temp1;
        int temp2;
        for (int start = 0; start < k; start++) {
            int j=start;
            temp1=nums[start];
            do {
                j = (j+k)%nums.length;
                temp2=nums[j];
                nums[j]=temp1;
                temp1=temp2;
                i--;
            }while (j!=start&&i>0);
            if (i==0) return;
        }
    }

    /**
     * 方法4：使用反转
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     * 假设 n=7n=7 且 k=3k=3 。
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     *
     * 时间复杂度：O(n)O(n) 。 nn 个元素被反转了总共 3 次。
     * 空间复杂度：O(1)O(1) 。 没有使用额外的空间。
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
