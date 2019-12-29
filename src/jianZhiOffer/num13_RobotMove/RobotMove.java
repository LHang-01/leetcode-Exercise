package jianZhiOffer.num13_RobotMove;

/**
 * 剑指offer面试题13--机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0) return 0;
        //显示初始化
        boolean[][] marked = new boolean[rows][cols];
        return dfs(threshold,rows,cols,0,0,marked);
    }

    private int dfs(int threshold, int rows, int cols, int row, int col, boolean[][] marked) {
        //在矩形内，没走过，并且满足要求
        if (row>=0&&row<rows&&col>=0&&col<cols&&(!marked[row][col])&&requried(row,col,threshold)){
            //标记为已走，即通过；
            marked[row][col]=true;
            //统计四个方向的满足要求的格子+本格子之和
            return 1+ dfs(threshold,rows,cols,row+1,col,marked)+dfs(threshold,rows,cols,row-1,col,marked)+
                    dfs(threshold,rows,cols,row,col+1,marked)+dfs(threshold,rows,cols,row,col-1,marked);
        }
        return 0;
    }

    //判断进入行坐标和列坐标的数位之和是否大于k的格子。
    private boolean requried(int row, int col, int threshold) {
        int sum = 0;
        while (row>9){
            sum+=row/10;
            row=row%10;
        }
        sum+=row;
        while (col>9){
            sum+=col/10;
            col=col%10;
        }
        sum+=col;
        return sum<=threshold;
    }
}
