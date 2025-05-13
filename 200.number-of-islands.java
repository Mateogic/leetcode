/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30204
 *
 * [200] 岛屿数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;

    }
    private void dfs(char[][] grid, int r, int c){
        if(outOfBounds(grid, r, c))
            return ;
        if(grid[r][c]!='1')
            return ;
        grid[r][c] = '2';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
    private boolean outOfBounds(char[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)// 出界
            return true;
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]\n
// @lcpr case=end

 */

