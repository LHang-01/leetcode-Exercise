package stringtrain;

import java.util.ArrayList;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Num6 {
    /**
     * 从左往右迭代字符串形成N字型后，再把字符串连接上就行了
     *
     * 执行用时 :9 ms, 在所有 java 提交中击败了67.33%的用户
     * 内存消耗 :38.9 MB, 在所有 java 提交中击败了94.57%的用户
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i =0;i<Math.min(s.length(),numRows);i++){
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c:s.toCharArray()){
            list.get(curRow).append(c);
            //当在第一行或者最后一行时，运动方向就改变为反方向
            if (curRow==numRows-1||curRow==0){
                goingDown=!goingDown;
            }
            curRow+=goingDown?1:-1;
        }
        //把字符串连接
        StringBuilder builder = new StringBuilder();
        for (StringBuilder str:list){
            builder.append(str);
        }
        return builder.toString();
    }


}
