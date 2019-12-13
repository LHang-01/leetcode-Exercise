package array;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 *
 */
public class Num209 {
    public static void main(String[] arrs){
        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        for (int i =0 ;i<nums.length;i++){
            sum+=nums[i];
        }
        if (sum<s) return 0;
        int pre = 0;
        int last = nums.length-1;
        while (pre<=last&&sum>=s){
            if (nums[pre]<nums[last]){
                sum-=nums[pre];
                pre++;
            }else {
                sum-=nums[last];
                last--;
            }
        }
        if (sum>=s){
            return last-pre+1;
        }else {
            return 0;
        }
    }
}
