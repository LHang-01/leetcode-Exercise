package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法：39、40、78、79、90
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Num90 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    //执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
    //内存消耗 :37.4 MB, 在所有 java 提交中击败了79.85%的用户
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        dfs(0,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start;i<nums.length;i++){
            //防止重复的集合出现
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            dfs(i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
