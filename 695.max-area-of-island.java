/*
 * @lc app=leetcode.cn id=695 lang=java
 * @lcpr version=30204
 *
 * [695] 岛屿的最大面积
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int r, int c){
        if(outOfBounds(grid, r, c))
            return 0;
        if(grid[r][c]!=1)
            return 0;
        grid[r][c] = 2;
        return 1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }
    private boolean outOfBounds(int[][] grid, int r, int c){
        if(r<0||r>=grid.length || c<0||c>=grid[0].length)
            return true;
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0,0,0,0,0,0]]\n
// @lcpr case=end

 */

