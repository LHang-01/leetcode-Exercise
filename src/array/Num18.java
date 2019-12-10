package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class Num18 {
    public static void main(String[] arrs){
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums,0));
    }

    /**
     * 超出时间限制
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int k=-1;
        while (k<nums.length-3){
            //防止重复d的nums[i]
            k++;
            //防止重复d的nums[i]
            while (nums[k]==nums[++k]&&k<nums.length-3){}
            if (k<nums.length-3){
                k--;
            }else {
                break;
            }
            int i=k;
            while (i<nums.length-2){
                i++;
                int j=i+1;
                int m=nums.length-1;
                while (j<m){
                    int sum = nums[k]+nums[i]+nums[j]+nums[m];
                    if (sum>target){
                        m--;
                    }else if (sum<target){
                        j++;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        lists.add(list);
                        while (nums[m]==nums[--m]&&j<m){}
                        while (nums[j]==nums[++j]&&j<m){}
                    }
                }
            }
        }
        return lists;
    }
    /**
     *
     */

}
