package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Num118 {
    public static void main(String[] arrs){
        generate(5);
    }

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 98.26% 的用户
     * 内存消耗 : 34 MB , 在所有 java 提交中击败了 26.10% 的用户
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if(numRows==0) return lists;
        lists.add(new ArrayList<>(1));
        lists.get(0).add(1);
        for (int i = 1;i<numRows;i++){
            List<Integer> list = new ArrayList<>(i+1);
            list.add(1);
            for (int j=1;j<i;j++){
                list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
