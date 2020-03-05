package doublePointer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 * 示例：给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。满足要求的四元组集合为：
 * [ [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]]
 *
 * 和num18很类似。
 */
public class Num18 {
    public static void main(String[] arrs){
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums,-11));
    }

    /**
     * 执行用时 : 5 ms, 在所有 Java 提交中击败了83.60%的用户
     * 内存消耗 :45 MB, 在所有 Java 提交中击败了6.46%的用户
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //定义返回集合
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //当数组为null或元素小于4个时，直接返回
        if(nums==null||nums.length<4){
            return lists;
        }
        //1.排序
        Arrays.sort(nums);
        int length = nums.length;
        //2.固定最左（最小）数字的指针 k
        int k=0;
        while (k<nums.length-3){
            //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略,k++
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                while (k<nums.length-3&&nums[k]==nums[++k]){}
                continue;
            }
            int i = k+1;
            while (i<nums.length-2){
                //获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
                int min2=nums[k]+nums[i]+nums[i+1]+nums[i+2];
                if(min2>target){
                    break;
                }
                //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略,i++
                int max2=nums[k]+nums[i]+nums[length-2]+nums[length-1];
                if(max2<target){
                    while (i<nums.length-2&&nums[i]==nums[++i]){}
                    continue;
                }
                int j = i+1;
                int m = nums.length-1;
                while (j<m){
                    int sum = nums[k] + nums[i] + nums[j]+ nums[m];
                    if (sum>target){
                        while (j<m&&nums[m]==nums[--m]){}//这里可以写成 --m;
                    }else if (sum<target){
                        while (j<m&&nums[j]==nums[++j]){}//这里可以写成 ++j;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        lists.add(list);
                        while (j<m&&nums[j]==nums[++j]){}
                        while (j<m&&nums[m]==nums[--m]){}
                    }
                }
                while (i<nums.length-2&&nums[i]==nums[++i]){}
            }
            while (k<nums.length-3&&nums[k]==nums[++k]){}
        }
        return lists;
    }

}
