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
    String[] str = new String[]{"apple","abc","an"};
    System.out.println(longestCommonPrefix1(str));

    }

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

}
