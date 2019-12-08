package array;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Num88 {
    public static void main(String[] arrs){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.2 MB
     * , 在所有 java 提交中击败了
     * 84.39%
     * 的用户
     * 方法：从后面往前，从大到小排列
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        m--;
        n--;
        while (n>=0&&m>=0){
            if (nums1[m]>nums2[n]){
                nums1[i]=nums1[m];
                m--;
            }else {
                nums1[i]=nums2[n];
                n--;
            }
            i--;
        }
        if (m<0&&n>=0){
            while (n>=0){
                nums1[n]=nums2[n];
                n--;
            }
        }
    }
}
