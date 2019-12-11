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
        if(nums==null||nums.length==0) return 0;
        int sum =nums[0];
        int pre = nums.length;
        int ans = 0;
        int j;
        for (int i =0 ;i<nums.length;i++){
            j=i;
            if (sum>=s){
                ans--;
                pre = Math.min(ans,pre);
            }
            while (sum<s&&j<nums.length){
                sum+=nums[j];
                j++;
                ans++;
            }
            if (sum>=s){
                pre = Math.min(ans,pre);
            }else {
                continue;
            }
            sum=sum-nums[i];
        }
        return pre;
    }
}
