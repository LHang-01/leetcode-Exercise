package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Num39 {
    public static void main(String[] arrs){
        combinationSum(new int[]{2,3,6,7},7);
    }
    //执行用时 :5 ms, 在所有 java 提交中击败了70.40%的用户
    //内存消耗 :38.8 MB, 在所有 java 提交中击败了89.19%的用户
    //回溯算法+剪枝
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length==0) return lists;
        Arrays.sort(candidates);
        if (candidates[0]>target) return lists;
        function(candidates,target,0,lists,new Stack<Integer>());
        return lists;
    }

    private static void function(int[] candidates, int target,int start, List<List<Integer>> lists, Stack<Integer> stack) {
        if (target==0){
            lists.add(new ArrayList<>(stack));
            return;
        }else{
            //target-candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
            for (int i = start;i<candidates.length&&target-candidates[i]>=0;i++){
                stack.push(candidates[i]);
                function(candidates,target - candidates[i],i,lists, stack);
                stack.pop();
            }
        }
    }


}
