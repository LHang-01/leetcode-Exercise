package doublePointer.array;

/**
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 示例 1: 输入: [3, 2, 1] 输出: 1 解释: 第三大的数是 1.
 * 示例 2: 输入: [1, 2] 输出: 2 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3: 输入: [2, 2, 3, 1] 输出: 1 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。 存在两个值为2的数，它们都排第二。
 */
public class Num414 {
    /**
     * 三指针:
     * 分别用max1、max2、max3记录第一大、第二大、第三大的数；遍历中，用当前数与max1、max2、max3比较，若大，则依次替换。
     * 但是注意此处max1、max2、max3只能用Long.MIN_VALUE初始化，不能用Integer.MIN_VALUE。
     * 因为若第三大的数恰好等于-2147483648，就会判断出错返回最大数，因此用Long.MIN_VALUE代替Integer.MIN_VALUE
     *
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 99.64%的用户
     * 内存消耗 : 37.8 MB , 在所有 java 提交中击败了73.48%的用户
     *
     */
    public int thirdMax(int[] nums) {
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=max1&&nums[i]!=max2&&nums[i]!=max2){
                if (nums[i]>max1){
                    max3=max2;
                    max2=max1;
                    max1=nums[i];
                }else if (nums[i]>max2){
                    max3=max2;
                    max2=nums[i];
                }else if (nums[i]>max3){
                    max3=nums[i];
                }
            }
        }
        if (max3==Long.MIN_VALUE){
            return (int) max1;
        }else {
            return (int)max3;
        }
    }
}
