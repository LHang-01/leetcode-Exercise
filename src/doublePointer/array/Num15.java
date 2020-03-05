package doublePointer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [  [-1, 0, 1],
 *   [-1, -1, 2]  ]
 */
public class Num15 {
    public static void main(String[] arrs){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    /**
     * （排序+双指针）
     * 先将给定 nums 排序，复杂度为 O(NlogN).
     * 双指针法思路： 固定 3 个指针中最左（最小）数字的指针 k，
     * 双指针 i，j 分设在数组索引 (k, len(nums))两端，通过双指针交替向中间移动（与num11的算法是一样的，即如果nums[k] + nums[i] + nums[j]的值>0,左指针i。）
     * 注意：（1）因为答案中不可以包含重复的三元组，所以当k往后移动或者nums[k] + nums[i] + nums[j]=0时，此时k\i\j移动，应该直接移动到不等于原值的位置。
     *              注意当nums[k] + nums[i] + nums[j]！=0时，i\j直接移动一位，不需要判断是否等于原值，因为即使等于原值，也不出现重复组；
     *      （2）如果最小和值nums[k]>0,则和一定大于0，这里可以提前终止;
     *          如果最大的和值0，跳出循环，增大当前值。
     */
    //执行用时 :41 ms, 在所有 Java 提交中击败了53.37%的用户
    //内存消耗 :55.8 MB, 在所有 Java 提交中击败了5.01%的用户
    public static List<List<Integer>> threeSum1(int[] nums) {
        //1.排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //2.固定 3 个指针中最左（最小）数字的指针 k
        int k = 0;
        int length = nums.length;
        while(k<nums.length-2){
            //如果最小和nums[k]+nums[k+1]+nums[k+2]>0,则以后每一轮的nums[k] + nums[i] + nums[j]一定大于0，这里可以提前终止。
            if (nums[k]+nums[k+1]+nums[k+2]>0){
                break;
            }
            //如果最大和nums[k]+nums[length-1]+nums[length-2]<0,则这一轮的nums[k] + nums[i] + nums[j]一定小于0，这里可以提前结束此次循环，等下一轮增大值后再来对比。
            if (nums[k]+nums[length-1]+nums[length-2]<0){
                while (nums[k]==nums[++k]&&k<nums.length-2){}
                continue;
            }
            //3.双指针 i，j 分设在数组索引 (k, len(nums))两端，通过双指针交替向中间移动
            int i = k+1;
            int j = length-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                //3.1若和=0,存入lists
                if (sum==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                    //i往后移动一位,直接移动到不等于原值的位置。
                    while (nums[i]==nums[++i]&&i<j){ }
                    //j往前移动一位,直接移动到不等于原值的位置。
                    while (nums[j]==nums[--j]&&i<j){ }
                }else if (sum<0){
                    //若和<0,i往后移动一位
                    while (nums[i]==nums[++i]&&i<j){ }
                }else {
                    //若和>0,j往后移动一位
                    while (nums[j]==nums[--j]&&i<j){ }
                }
            }
            //k往后移动一位,直接移动到不等于原值的位置。
            while (nums[k]==nums[++k]&&k<nums.length-2){}
        }
        return lists;
    }

    //简化代码后，速度变快了
    //执行用时 :35 ms, 在所有 Java 提交中击败了75.67%的用户
    //内存消耗 :54.9 MB, 在所有 Java 提交中击败了5.01%的用户
    public static List<List<Integer>> threeSum(int[] nums) {
        //1.排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //2.固定 3 个指针中最左（最小）数字的指针 k
        int k = 0;
        int length = nums.length;
        while(k<nums.length-2){
            //如果最小值nums[k]>0,则这里可以提前终止。
            if (nums[k]>0){
                break;
            }
            //3.双指针 i，j 分设在数组索引 (k, len(nums))两端，通过双指针交替向中间移动
            int i = k+1;
            int j = length-1;
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                //3.1若和=0,存入lists
                if (sum==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                    //i往后移动一位,直接移动到不等于原值的位置。
                    while (nums[i]==nums[++i]&&i<j){ }
                    //j往前移动一位,直接移动到不等于原值的位置。
                    while (nums[j]==nums[--j]&&i<j){ }
                }else if (sum<0){
                    //若和<0,i往后移动一位
                    ++i;
                }else {
                    //若和>0,j往后移动一位
                    --j;
                }
            }
            //k往后移动一位,直接移动到不等于原值的位置。
            while (nums[k]==nums[++k]&&k<nums.length-2){}
        }
        return lists;
    }
}
