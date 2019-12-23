package stringtrain;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Num22 {
    //1.回溯法思路和算法:只有在我们知道序列仍然保持有效时才添加 '(' or ')'
    //执行用时 :1 ms, 在所有 java 提交中击败了99.38%的用户
    //内存消耗 :36.2 MB, 在所有 java 提交中击败了99.00%的用户
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        function(ans, "", 0, 0, n);
        return ans;
    }

    private void function(ArrayList<String> ans, String str, int open, int close, int n) {
        if (str.length()==2*n){
            ans.add(str);
            return;
        }else {
            if (open<n) function(ans,str+"(",open+1,close,n);
            if (close<open) function(ans,str+")",open,close+1,n);
        }
    }
}
