package jianZhiOffer.Num5_ReplaceSpaces;

/**
 * 剑指offer面试题5--替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class replaceSpace {
    public String replaceSpace1(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c:str.toCharArray()){
            if (c==' '){
                builder.append("%20");
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
    public static void main(String [] arrs){
        replaceSpace replaceSpace = new replaceSpace();
        System.out.println((replaceSpace.replaceSpace1("We Are Happy ")));
        replaceSpace.mergeArray(new int[]{},new int[]{});
    }

    //相关题目：leetcode88. 合并两个有序数组
    //有两个有序的数组A1和A2，A1末尾有足够空间容纳A2。实现一个函数将A2的所有数字插入到A1中，并且所有数字是有序的。
    private void mergeArray(int[] nums1, int[] nums2) {
        // 统计nums1数组中有值元素的个数
        int len = 0;
        for (int i = 0;i < nums1.length;i++) {
            if (nums1[i] !=0) {
                len++;
            }
        }
        int end1 = len-1;
        int end2 = nums2.length-1;
        int k = nums1.length-1;
        while (k>-1){
            if (end1<0){
                //num1数组已经移动完毕，将num2的值全部依次移动到num1中
                nums1[k--]=nums2[end2--];
            }else if (end2<0){
                //num2数组已经移动完毕,，直接返回
                return;
            }else if (nums1[end1]<nums2[end2]){
                nums1[k--]=nums2[end2--];
            }else {
                nums1[k--]=nums1[end1--];
            }
        }

    }


}
