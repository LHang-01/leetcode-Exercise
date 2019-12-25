package stringtrain;

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
