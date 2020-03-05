package backtracking;

/**
 * 二维平面+回溯
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Num79 {
    private char[][] board;
    private String word;
    //四种行走的方向
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    //用于标记是否走过
    private boolean[][] marked;
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCCED";
        Num79 solution = new Num79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

    //执行用时 :6 ms, 在所有 java 提交中击败了84.76%的用户
    //内存消耗 :38.2 MB, 在所有 java 提交中击败了97.16%的用户
    public boolean exist(char[][] board, String word) {
        //显示初始化
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        this.word=word;
        this.board=board;
        marked=new boolean[m][n];
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

    private boolean dfs(int i, int j, int index) {
        //index终止条件：当index=word的最后一个字符时，根据board[i][j]与word.charAt(index)是否相等判断此次行走方向是否正确，若不等则返回false到第48行，接着到42行，换下一个方向。
        if (index == word.length() - 1) {
            return board[i][j] == word.charAt(index);
        }
        if (word.charAt(index)==board[i][j]){
            //当word.charAt(index)=board[i][j]时，先标记为已走
            marked[i][j]=true;
            //以board[i][j]为中心，遍历上左下右四个方向行走
            for (int k = 0;k<4;k++){
                int newi=i+direction[k][0];
                int newj=j+direction[k][1];
                //判断是否越界，是否已经走过
                if (inArea(newi,newj)&&!marked[newi][newj]){
                    //若下一步没有越界也没有走过，则调用dfs(newi,newj,index+1)，判断word.charAt(index+1)与board[newi][newj].
                    if (dfs(newi,newj,index+1)){
                        return true;
                    }
                }
            }
            //若遍历完后，没有一个方向与index+1相等，则返回false，并且将之前标记为已走的修改为未走
            marked[i][j] = false;
            return false;
        }
        //当word.charAt(index)！=board[i][j]时，返回false。
        return false;
    }

    //判断是否还在矩形区域内
    private boolean inArea(int newi, int newj) {
        return newi>=0&&newi<m&&newj>=0&&newj<n;
    }
}
