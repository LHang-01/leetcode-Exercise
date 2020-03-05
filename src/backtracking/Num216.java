package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法：39、40、78、79、90、216
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Num216 {
    private List<List<Integer>> res = new ArrayList<>();
    //执行用时 :1 ms, 在所有 java 提交中击败了98.77%的用户
    //内存消耗 :33.5 MB, 在所有 java 提交中击败了32.13%的用户
    //回溯算法总是在dfs函数运算完成后，弹出栈顶元素（末尾元素）
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,new ArrayList<Integer>(),k,n);
        return res;
    }

    private void dfs(int start, ArrayList<Integer> list, int k, int n) {
        if (k==0){
            if (n==0) res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i<10;i++){
            list.add(i);
            dfs(i+1,list,k-1,n-i);
            list.remove(list.size()-1);
        }
    }
}
