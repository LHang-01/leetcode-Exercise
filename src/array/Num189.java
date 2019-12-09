package array;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Num189 {

    public static void main(String[] arrs){
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        rotate(nums, k);
    }
    /**
     * 方法 3：使用环状替换
     * 当旋转一圈如果j==start，则需要跳出while循环，将j=start+1,继续循环。
     * 当旋转种j！=start时，直接循环到k次，就能得到结果。
     *https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
     *执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 84.56%
     * 的用户
     * 内存消耗 :
     * 36.5 MB
     * , 在所有 java 提交中击败了
     * 95.45%
     * 的用户
     *
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums==null||nums.length==1||k%nums.length==0) return;
        k=k%nums.length;
        int i = nums.length;
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
}