package greedy;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 */
public class num455 {
    public static void main(String[] arrs){
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{1,2,3};
        System.out.println(fun1(arr1,arr2));
    }

    private static int fun1(int[] arr1, int[] arr2) {
        //先将数组排好序
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans =0;
        int j=0;
        int i;
        for (i =0;i<arr1.length;i++){
            while(j<arr2.length&&arr2[j]<arr1[i]){
                j++;
            }
            if(j==arr2.length) {
                ans = i;
                break;
            }

            j++;
        }
        if(i==arr1.length){
            ans = arr1.length;
        }

        return ans;
    }


}
