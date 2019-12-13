package stringtrain;


/**
 *  分类：字符串
 *  难度：简单
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class num14 {
    public static void main(String[] arrs){
    String[] str = new String[]{"acc","aaa","aaba"};
    System.out.println(longestCommonPrefix2(str));

    }

    /**
     * 执行用时 :2 ms, 在所有 java 提交中击败了46.92%的用户
     * 内存消耗 :37.3 MB, 在所有 java 提交中击败了79.14%的用户
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length==0||strs==null){
            return "";
        }
        int min =strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }

        int index = 0;
        out:while(index<min){
            for(int j=1;j<strs.length;j++){
                if(!strs[0].substring(index,index+1).equals(strs[j].substring(index,index+1))){
                    break out;
                }
            }
            index++;
        }
        return  strs[0].substring(0,index);
    }

    /**
     *执行用时 :
     * 3 ms, 在所有 java 提交中击败了25.23%的用户
     * 内存消耗 :
     * 37.6 MB, 在所有 java 提交中击败了74.11%的用户
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length==0||strs==null){
            return "";
        }
        int min =strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }
        String same = strs[0].substring(0,min);
        for(int i=1;i<strs.length;i++){
            for(int j=0;j<same.length();j++){
                if(!same.substring(j,j+1).equals(strs[i].substring(j,j+1))){
                    if (j != 0) {
                        same=same.substring(0,j);
                        break;
                    }else {
                        return "";
                    }
                }
            }
        }
        return same;
    }

}
