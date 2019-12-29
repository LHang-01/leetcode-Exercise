package jianZhiOffer.num3_DuplicateNumbersInArray;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指offer面试题3--数组中的重复数字（leetcode287）
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
 */
public class Solution3 {
    //1.哈希表
    //时间复杂度为O(n)、空间复杂度为O(n)
    //可以不修改原数组就能找到重复值
    public static int function1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
    //2.思路：因为所有数字都在0到n-1的范围内，即num[i]的值在0到n-1的范围内；因此遍历数组中每一个数num[i]，并将nums[i]%n作为下标，将num[nums[i]%n]的值加上n，
    //因为存在重复数字，则重复数字指向的位置上的值必定加了两次n，而不重复的数字指向的位置只加了一次n，因此，只要num[nums[i]%n]的值>=2*n，就找到了重复的数字nums[i]%n。
    //时间复杂度为O(n)、空间复杂度为O(1)(不需要额外的空间，但是需要修改原数组)
    public static int function2(int[] nums){
        int n=nums.length;
        for (int i =0;i<n;i++){
            nums[nums[i]%n]+=n;
            if (nums[nums[i]%n]>=2*n){
                return nums[i]%n;
            }
        }
        return -1;
    }
    //3.排序（剑指offer的方法）
    //排好序后的数组中若存在重复数字一定是相邻的。
    //时间复杂度为O(nlogn)、空间复杂度为O(1)、但是修改了原数组
    public int function3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //4.快慢指针1
    //当快指针（走两步）和慢指针（走一步）第一次相遇时，慢指针不变，快指针归零重新出发，并且快指针也变为慢指针，当两指针再一次相遇时的值就是重复的值，这与链表中找循环链表的入口是一种道理
    //时间复杂度为XX、空间复杂度为O(1)、且不会修改原数组
    public int function4(int[] nums) {
        int slow = 0;
        int fast = 0;
        //1.第一次相遇
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        //2.相遇后，快指针归零，重新出发，并且快指针也变为慢指针；
        //当两指针再一次相遇时的值就是重复的值
        //注意:当初始是0时，这里应该先走，再判断是否相等
        fast=0;
        do {
            fast=nums[fast];
            slow=nums[slow];
        }while (fast!=slow);
        return fast;
    }
    //5.快慢指针2
    public int function5(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //1.第一次相遇
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        //2.相遇后，快指针归零，重新出发，并且快指针也变为慢指针；
        //注意:当初始是nums[0]时，这里应该先判断是否相等，不等再走
        fast=nums[0];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
    //6.遍历数组（剑指offer的方法）：duplication[0]用于返回值
    // 1）如果值i在正确的位置（满足numbers[i] ==i），则什么都不做；
    // 2）如果值i没有在正确的位置（满足numbers[i] == i），通过交换两个元素，将值i放到正确的位置。这个过程可以看成是排序。
    // （交换过程：令j=numbers[i],判断j==numbers[j]是否相等，若相等，则说明在与i不同的位置j找到重复元素；不等则交换numbers[j]和numbers[i]，继续重复这一步。
    //时间复杂度为O(n)、空间复杂度为O(1)、但是修改了原数组
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||numbers.length==0){
            return false;
        }
        for (int i = 0;i<numbers.length;i++){
            // 1）如果值i在正确的位置（满足numbers[i] ==i），则说什么都不做；
            if (numbers[i]!=i){
                // 2）如果值i没有在正确的位置，通过交换两个元素，将值i放到正确的位置。
                int j = numbers[i];
                while (j!=numbers[j]){
                    numbers[i]=numbers[j];
                    numbers[j]=j;
                    j=numbers[i];
                }
                //当j=numbers[j]且与i不同的位置j找到的才是重复元素。
                if (j==numbers[j]&&j!=i) {
                    duplication[0]=j;
                    return true;
                }
            }
        }
        duplication[0]=-1;
        return false;
    }

    //7.思路：类似于二分查找
    //把从中间的数字m分成两部分，前面一半为1-m，后面一半为m+1-n。如果1-m的数字超过m，那么这一班区间里面一定包含重复数字；
    // 否则另一半一定包含重复数字。然后继续一分为二，直到找到重复的数字。
    //例如：{2,3，5,4,3,2,6,7}，m=4，两段：1-4,5-7；然后统计在1-4这一区间内的个数，若大于4这重复数字在此区间内；反之在另一区间内。
    //时间复杂度为O(nlogn)、空间复杂度为O(1)、不修改原数组
    public int function7(int[] nums) {
        int start = 1;
        int end = nums.length;
        int mid = 0;
        while (start<end){
            mid=(start+end)/2;
            //统计1-m的个数
            int count =0;
            for (int num:nums){
                if (num<=mid) count++;
            }
            if (count>mid){
                //如果1-m的数字超过m，那么这一半区间里面一定包含重复数字；
                end = mid;
            }else {
                //否则另一半区间一定包含重复数字
                start = mid+1;
            }
        }
        return start;
    }

}
