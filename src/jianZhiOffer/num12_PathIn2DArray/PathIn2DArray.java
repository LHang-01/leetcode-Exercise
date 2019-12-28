package jianZhiOffer.num12_PathIn2DArray;

/**
 * 剑指offer面试题12--矩阵中的路径（leetcode79. 单词搜索）
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如下面矩阵
 *
 * a b t g
 * c f c s
 * j d e h
 * 包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathIn2DArray {
    private char[] matrix;
    private char[] str;
    //用于标记是否走过
    private boolean[] marked;
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    //执行用时 :6 ms, 在所有 java 提交中击败了84.76%的用户
    //内存消耗 :38.2 MB, 在所有 java 提交中击败了97.16%的用户
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || rows <= 0|| cols <=0 || str == null) return false;
        //显示初始化
        m = rows;
        n =cols;
        this.str=str;
        this.matrix=matrix;
        marked=new boolean[matrix.length];
        for (int i =0;i<m;i++){
            for (int j=0;j<n;j++){
                //入口
                if (dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param i      横坐标
     * @param j      纵坐标
     * @param index  word中正在比较的字母位置
     * @return
     */
    private boolean dfs(int i, int j, int index) {
        //在矩形区域内,并且没有被踩过才继续判断
        if (i>=0&&i<m&&j>=0&&j<n&&(!marked[i*n+j])){
            //index终止条件：当index=word的最后一个字符时，根据matrix[i*n+j]与str[index]是否相等判断此次行走方向是否正确，若不等则返回false，换下一个方向。
            if (index == str.length - 1) {
                return matrix[i*n+j] == str[index];
            }
            if (str[index]==matrix[i*n+j]){
                //当word.charAt(index)=matrix[i*n+j]时，先标记为已走
                marked[i*n+j]=true;
                //以[i,j]为中心，遍历上左下右四个方向行走，只要有一个方向走通了就返回true
                if (dfs(i+1,j,index+1)||dfs(i-1,j,index+1)||dfs(i,j+1,index+1)||dfs(i,j-1,index+1)){
                    return true;
                }
                //若遍历完后，没有一个方向与index+1相等，则返回false（）表示此路走不通，返回之后换一个方向继续探索，并且将之前标记为已走的修改为未走
                marked[i*n+j] = false;
                return false;
            }
            //当str[index]!=matrix[i*n+j]时，返回false。
            return false;
        }
        return false;
    }
}
