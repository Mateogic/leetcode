/*
 * @lc app=leetcode.cn id=827 lang=java
 * @lcpr version=30204
 *
 * [827] 最大人工岛
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Map;

class Solution {
    public int largestIsland(int[][] grid) {
        int res = 0, tmp = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int idx = 2;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    tmp = dfs1(grid, i, j, idx);
                    res = Math.max(res, tmp);
                    mp.put(idx, tmp);
                    idx++;
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    res = Math.max(res, dfs2(grid, i, j, mp));
                }
            }
        }
        return res;
    }
    private int dfs1(int[][] grid, int r, int c, int idx){
        if(outOfBounds(grid, r, c))
            return 0;
        if(grid[r][c]!=1)
            return 0;
        grid[r][c] = idx;
        return 1+dfs1(grid, r-1, c, idx) + dfs1(grid, r+1, c, idx) + dfs1(grid, r, c-1, idx) + dfs1(grid, r, c+1, idx);
    }
    private int dfs2(int[][] grid, int r, int c, Map<Integer, Integer> mp){
        int area = 1;
        Set<Integer> set = new HashSet<>();
        if(r>=1)
            set.add(grid[r-1][c]);
        if(r<=grid.length-2)
            set.add(grid[r+1][c]);
        if(c>=1)
            set.add(grid[r][c-1]);
        if(c<=grid[0].length-2)
            set.add(grid[r][c+1]);
        for(int idx:set){
            area+=mp.getOrDefault(idx, 0);
        }
        return area;
    }
    private boolean outOfBounds(int[][] grid, int r, int c){
        if(r<0|| r>=grid.length || c<0 || c>=grid[0].length)
            return true;
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1, 0], [0, 1]]\n
// @lcpr case=end

// @lcpr case=start
// [[1, 1], [1, 0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1, 1], [1, 1]]\n
// @lcpr case=end

 */

