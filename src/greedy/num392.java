package greedy;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
public class num392 {
    public static void main(String[] arrs){
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(fun1(s,t));
    }

    /**
     * 执行用时 : 6 ms , 在所有 java 提交中击败了 72.36% 的用户
     * 内存消耗 : 49.4 MB , 在所有 java 提交中击败了 95.23% 的用户
     */
    public static boolean fun1(String s,String t){
        if(s.isEmpty()||s==null){
            return true;
        }else if(t.isEmpty()||t==null){
            return false;
        }
        boolean ans =false;
        int i=0;
        String str=s.substring(i,++i);
        while(i<s.length()&&t.contains(str)){
            if (t.indexOf(str)+1==t.length()){
                ans=false;
            }
            t=t.substring(t.indexOf(str)+1);
            str=s.substring(i,++i);

        }
        if (i == s.length()){
             ans=true;
        }
        if(!t.contains(str)){
            ans=false;
        }
        return ans;

    }

}
