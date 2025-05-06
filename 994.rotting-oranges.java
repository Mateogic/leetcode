/*
 * @lc app=leetcode.cn id=994 lang=java
 * @lcpr version=30204
 *
 * [994] 腐烂的橘子
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 多源BFS
// 层序遍历BFS先搜索到的点，一定是距离更近的点。
// 所求单元格中没有新鲜橘子所需的最小分钟数，即求腐烂橘子到所有新鲜橘子的最短路径

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> rotted = new ArrayList<>();
        for(int i = 0;i<m;i++){// 统计初始时新鲜橘子的数量，腐烂橘子的位置
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2){
                    rotted.add(new int[]{i,j});
                }
            }
        }
        int res = 0;// 腐烂轮数
        while(fresh > 0 && !rotted.isEmpty()){// 还存在未腐烂的橘子，且还有可能腐烂到这些橘子
            res ++;
            List<int[] >tmp = rotted;// 本轮腐烂的源头
            rotted = new ArrayList<>();// 下一轮腐烂的源头
            for(int[] pos:tmp){
                for(int[] direction : DIRECTIONS){
                    int row = pos[0] + direction[0];
                    int col = pos[1] + direction[1];
                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                        grid[row][col] = 2;
                        fresh --;
                        rotted.add(new int[]{row,col});
                    }
                }
            }
        }
        return fresh > 0?-1:res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,1],[1,1,0],[0,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,1],[0,1,1],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,2]]\n
// @lcpr case=end

 */

