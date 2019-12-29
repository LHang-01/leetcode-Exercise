package jianZhiOffer.num19_ReMatch;

/**
 * 剑指offer面试题19--正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 分两种情况：
 * 1）第二个字符不是*号。这种情况很简单，第二个字符要么是.要么是一个具体的字符。此时如果第一个字符匹配成功了，只需将模式和文本指针都前进一位。
 *    比如ab和ac以及ab和.b，分别对应着字符一样、模式字符为.的情况。第一个字符匹配失败了，直接就可以得出结论——匹配失败。
 * 2) 第二个字符是*。有几种情况：
 * 1、匹配0次，比如a*ab和ab匹配，此时需要将模式指针前移2位，文本指针保持不动；
 * 2、匹配了1次，比如a*b和ab匹配，此时需要将模式指针前移2位，文本指针前移1位；
 * 3、匹配了多次，比如a*b和aaab匹配，此时需要将模式保持不动，文本指针前移1位；
 * 总结2）：先匹配0次，如果匹配不了，就匹配1次，然后匹配2次，直到匹配到末尾还不能完全匹配，就返回false。
 */

public class ReMatch {
    public static void main(String [] arrs){
        System.out.println(new ReMatch().match(new char[]{'a'},new char[]{'.'}));
    }
    public boolean match(char[] str, char[] pattern){
        if ((str==null||str.length==0)&&(pattern==null||pattern.length==0)) return true;
        if ((str!=null&&str.length!=0)&&(pattern==null||pattern.length==0)) return false;
        if ((str==null||str.length==0)&&(pattern!=null||pattern.length!=0)){
            if (pattern.length==2&&pattern[1]=='*'){
                return true;
            }
            return false;
        }
        return rematch(str,pattern,0,0);
    }

    private boolean rematch(char[] str, char[] pattern, int i, int j) {
        if (i>=str.length&&j<pattern.length) return false;
        if (j>=pattern.length&&i>=str.length) return true;
        if (j==pattern.length-1&&i==str.length-1){
            if (pattern[j]=='.') return true;
            return pattern[j]==str[i];
        } else if (j==pattern.length-1&&i<str.length-1) {
            return false;
        }
        if (pattern[j+1]!='*'){
            if (pattern[j]!='.'&&pattern[j]!=str[i]) return false;
            return rematch(str,pattern,i+1,j+1);
        }else {
            if (pattern[j]=='.'){
                //匹配0次、匹配1次
                return rematch(str,pattern,i+1,j)||rematch(str,pattern,i+1,j+2)||
                        rematch(str,pattern,i+1,j);
            }else {
                //匹配0次、匹配1次、匹配2次
                return rematch(str,pattern,i,j+2)||(pattern[j]==str[i]&&rematch(str,pattern,i+1,j+2))||
                        (pattern[j]==str[i]&&rematch(str,pattern,i+1,j));
            }
        }
    }
}
