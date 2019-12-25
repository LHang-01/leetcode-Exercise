package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 回溯算法
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明:
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Num40 {
    public static void main(String[] arrs){
        combinationSum2(new int[]{10,1,2,7,6,1,5},7);
    }

    //执行用时 :4 ms, 在所有 java 提交中击败了80.39%的用户
    //内存消耗 :37.8 MB, 在所有 java 提交中击败了87.57%的用户
    //回溯算法+剪枝
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length==0) return lists;
        Arrays.sort(candidates);
        if (candidates[0]>target) return lists;
        function2(candidates,target,0,lists,new Stack<Integer>());
        return lists;
    }

    private static void function2(int[] candidates, int target, int start, List<List<Integer>> lists, Stack<Integer> stack) {
        if (target==0){
            lists.add(new ArrayList<>(stack));
            return;
        }else{
            //target-candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
            for (int i = start;i<candidates.length&&target-candidates[i]>=0;i++){
                //防止重复的集合出现
                if (i > start && candidates[i] == candidates[i - 1]){
                    continue;
                }
                stack.push(candidates[i]);
                function2(candidates,target - candidates[i],i+1,lists, stack);
                stack.pop();
            }
        }
    }
}
