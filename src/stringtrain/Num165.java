package stringtrain;

/**
 * 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 */
public class Num165 {
    //执行用时 :2 ms, 在所有 java 提交中击败了86.27%的用户
    //内存消耗 :34.4 MB, 在所有 java 提交中击败了31.70%的用户
    //方法：先用split（“\\.”）函数分割成数组，再将字符串转换为数字比较大小
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i<arr1.length||j<arr2.length){
            String temp1 = (i>=arr1.length)?"0":arr1[i];
            String temp2 = (j>=arr2.length)?"0":arr2[i];
            if (Integer.parseInt(temp1)>Integer.parseInt(temp2)){
                return 1;
            }else if (Integer.parseInt(temp1)<Integer.parseInt(temp2)){
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
