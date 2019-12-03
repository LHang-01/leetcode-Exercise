package dynamicPlanning;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class num120 {
    public static void main(String[] arrs){
        ArrayList<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        lists.add(list);
        list.clear();
        list.add(3);
        list.add(4);
        lists.add(list);
        list.clear();
        list.add(5);
        list.add(6);
        list.add(7);
        lists.add(list);
        list.clear();
        System.out.println(minimumTotal(lists));

    }

    /**
     * 自底向上, DP 【AC】
     * 先求最底层n到第n-1层的最小路径和；
     * 再求n-1到n-2的最小路径和，以此类推，最后求第2层到第1层的最小路径和，即累加。
     * 注意，当求最底层n的时候,nums[j]=Math.min(nums[j],nums[j+1])+triangle.get(i).get(j)也成立，可以看成N+1层（假想出来的）的每个值都为0。但为了防止越界，在创建数组大小=triangle.size()+1。
     *       并且最后答案在最高层0。
     * 执行用时 :3 ms, 在所有 java 提交中击败了88.38%的用户
     * 内存消耗 :37.7 MB, 在所有 java 提交中击败了61.07%的用户
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] nums = new int[triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            for (int j=0;j<=i;j++){
                nums[j]=Math.min(nums[j],nums[j+1])+triangle.get(i).get(j);
            }
        }
        return nums[0];
    }
}
