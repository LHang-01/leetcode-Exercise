package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Num78 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    public static void main(String[] arrs){
        Num78 num78 = new Num78();
        num78.subsets(new int[]{1,2,3});
    }
    //执行用时 :1 ms, 在所有 java 提交中击败了99.25%的用户
    //内存消耗 :36.8 MB, 在所有 java 提交中击败了46.11%的用户
    //回溯，{}、{1}、{1,2}、{1,2,3}、{1,3}、{2}、{2,3}、{3}
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        dfs(0,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start;i<nums.length;i++){
            tmp.add(nums[i]);
            dfs(i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
