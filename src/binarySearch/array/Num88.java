package binarySearch.array;

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
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36 MB, 在所有 java 提交中击败了85.89%的用户
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m-1;
        int end2 = n-1;
        int k = nums1.length-1;
        while (k>-1){
            //num1数组已经移动完毕
            if (end1<0){
                nums1[k--]=nums2[end2--];
            }else if (end2<0){
                //num2数组已经移动完毕
                return;
            }else if (nums1[end1]<nums2[end2]){
                nums1[k--]=nums2[end2--];
            }else {
                nums1[k--]=nums1[end1--];
            }
        }
    }
}