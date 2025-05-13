/*
 * @lc app=leetcode.cn id=463 lang=java
 * @lcpr version=30204
 *
 * [463] 岛屿的周长
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return dfs(grid, i, j);
            }
        }
        return -1;
    }
    private int dfs(int[][] grid, int r, int c){
        if(outOfBounds(grid, r, c))
            return 1;
        if(grid[r][c]==0)
            return 1;
        if(grid[r][c]==2)
            return 0;
        grid[r][c] = 2;
        return dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
    private boolean outOfBounds(int[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)
            return true;
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0]]\n
// @lcpr case=end

 */

