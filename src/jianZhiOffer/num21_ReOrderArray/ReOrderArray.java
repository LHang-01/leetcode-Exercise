package jianZhiOffer.num21_ReOrderArray;

import java.util.Arrays;

/**
 * 剑指offer面试题21--调整数组的顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    //方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
    public void reOrderArray1(int [] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        // 左往右扫描的指针
        int p = 0;
        // 复制数组
        int[] temp = nums.clone();
        // 左往右扫描，只存入奇数
        int count = 0;
        for (int i = 0; i < len; i++) {
            if ((temp[i]&1)==1){
                nums[count++] = temp[i];
            }
        }
        // 再次扫描，只存入偶数
        for (int i = 0; i < len; i++) {
            if (!((temp[i]&1)==1)){
                nums[count++] = temp[i];
            }
        }
    }
    //方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N^2)，空间复杂度 O(1)，时间换空间。
    public void reOrderArray2(int[] nums) {
        //记录已经比较的个数，作为跳出循环的指标
        int count = 0;
        for (int j = 0; j < nums.length&&count<nums.length;) {
            if (isEven(nums[j])) {
                //偶数换到最后一位
                swap(nums,j);
                count++;
                continue;
            }
            j++;
            count++;
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int j) {
        int temp = nums[j];
        for (;j<nums.length-1;j++){
            nums[j]=nums[j+1];
        }
        nums[nums.length-1]=temp;
    }


    //如果将题目条件放宽，所有奇数在偶数之前就可以了，不要求保持原来的相对位置。
    public void reOrderArray3(int[] nums) {
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            //pBegin指针不断右移，直到遇到某个偶数为止；同样的，pEnd不断左移，直到遇到某个奇数为止。
            while (right>=0&&nums[right]%2!=1){
                right--;
            }
            while (left<nums.length&&nums[left]%2==1){
                left++;
            }
            if (left>=nums.length||right<0){
                return;
            }
            // 交换两个奇数和偶数，奇数被换到了前面，偶数换到了后面
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }
        }

    }

    public static void main(String[] args) {
        ReOrderArray reOrder = new ReOrderArray();
        int[] a = {3, 2, 1, 9, 8, 7, 4, 5, 6};
        new ReOrderArray().reOrderArray3(a);
        System.out.println(Arrays.toString(a));
    }
}
