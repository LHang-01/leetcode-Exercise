package array;

import java.util.ArrayList;
import java.util.List;

public class Num119 {
    public static void  main(String[] arrs){
        getRow(4);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 68.83%
     * 的用户
     * 内存消耗 :
     * 33.9 MB
     * , 在所有 java 提交中击败了
     * 22.20%
     * 的用户
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex+1);
        list.add(1);
        if (rowIndex==0) return list;
        list.add(1);
        if (rowIndex==1) return list;
        for (int i=2;i<=rowIndex;i++){
            list.add(0);
        }
        for (int i = 2;i<=rowIndex;i++){
            int j;
            int temp1=-1;;
            int temp2=-1;
            int temp3=list.get(0);
            for (j = 1;j<=i;j+=2){
                temp1=temp3;
                temp2 = list.get(j);
                list.set(j,temp1+temp2);
                if (j+1<=rowIndex){
                    temp3 =list.get(j+1);
                    list.set(j+1,temp2+temp3);
                }else {
                    return list;
                }

            }
        }
        return list;
    }
}
