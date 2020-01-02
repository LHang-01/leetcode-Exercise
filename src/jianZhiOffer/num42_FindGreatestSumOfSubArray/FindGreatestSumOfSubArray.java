package jianZhiOffer.num42_FindGreatestSumOfSubArray;

/**
 * 剑指offer面试题42--连续子数组的最大和
 * 输入一个整型数组，数组里正负数都可能有，数组中的一个或者连续的多个整数组成一个子数组。求所有子数组的和的最大值，要求时间复杂度为O(n)
 */
public class FindGreatestSumOfSubArray {

    //贪心算法
    public int findGreatestSumOfSubArray(int[] array) {
        int preSum = array[0];
        for (int i=0;i<array.length;i++){
            int nowSum =array[i];
            if (nowSum>preSum){
                preSum = nowSum;
            }
            while (i+1<array.length&&nowSum>=0){
                nowSum += array[i+1];
                if (nowSum>preSum){
                    preSum=nowSum;
                }
                i++;
            }
        }
        return preSum;
    }

}
