/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30204
 *
 * [51] N 皇后
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 题目要求:所有皇后(Q)不能位于同一行、同一列、同一斜对角线
// dfs(row,chess)表示当前需要填充第row行，棋盘状态为chess的搜索方案
// 递归入口:dfs(0,chess)即原问题，表示棋盘状态为初始值，从第0行开始填充
// 递归边界:i==n表示已经填充从0到n-1共n行，找到一组可行解，添加到res
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(char[] c:chess)// 初始化
            Arrays.fill(c,'.');
        dfs(0,n,chess);// 原问题
        return res;
    }
    private void dfs(int row,int n, char[][] chess){
        if(row == n){// 一组可行解
            List<String> cur = new ArrayList<>();
            for(char[] c:chess)
                cur.add(String.valueOf(c));
            res.add(cur);
        }
        for(int col = 0;col < n;col++){// 尝试将皇后填充到此行的各列
            if(isValid(row,col,n,chess)){// 检查是否能填充到当前位置
                chess[row][col] = 'Q';
                dfs(row+1, n, chess);// 递归
                chess[row][col] = '.';// 恢复现场
            }
        }
    }
    // 检查能否在(row,col)位置填充皇后
    private boolean isValid(int row,int col, int n, char[][]chess){
        for(int i = 0;i<row;i++){// 检查本列是否已经存在皇后
            if(chess[i][col]=='Q')
                return false;
        }
        for(int j = 0;j<col;j++){// 检查本列是否已经存在皇后
            if(chess[row][j]=='Q')
                return false;
        }
        for(int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){// 检查45度斜对角线是否已经存在皇后
            if(chess[i][j]=='Q')
                return false;
        }
        for(int i = row-1,j = col+1;i>=0 && j<n;i--,j++){// 检查135度斜对角线是否已经存在皇后
            if(chess[i][j]=='Q')
                return false;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

