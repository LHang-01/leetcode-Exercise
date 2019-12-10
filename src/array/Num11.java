package array;

public class Num11 {
    /**
     * 暴力法求解
     * 执行用时 :246 ms, 在所有 java 提交中击败了35.43%的用户
     * 内存消耗 :40.1 MB, 在所有 java 提交中击败了91.62%的用户
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int pre=0;
        for (int i=0;i<height.length-1;i++){
            for (int j=i+1;j<height.length;j++){
                int now=Math.min(height[i],height[j])*(j-i);
                if (now>pre){
                    pre=now;
                }
            }
        }
        return pre;
    }
    /**
     * 双指针法
     * 两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。最初我们考虑由最外围两条线段构成的区域。、
     * 现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
     * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
     *
     * 执行用时 :3 ms, 在所有 java 提交中击败了93.58%的用户
     * 内存消耗 :39.8 MB, 在所有 java 提交中击败了92.61%的用户
     * 炫耀一下:
     */
    public int maxArea2(int[] height) {
        int max =0;
        int l = 0;
        int r = height.length-1;
        while (l<r){
            int now = Math.min(height[l],height[r])*(r-l);
            if (now>max){
                max=now;
            }
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
