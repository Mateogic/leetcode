/*
 * @lc app=leetcode.cn id=3341 lang=java
 * @lcpr version=30204
 *
 * [3341] 到达最后一个房间的最少时间 I
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// Dijkstra
import java.util.*;;
class Solution {
    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for(int[] row:dist)
            Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[] {0,0,0});

        while(!pq.isEmpty()){
            int[] curent = pq.poll();
            int curentTime = curent[0], i = curent[1], j = curent[2];
            if(i==n-1 && j==m-1)
                return curentTime;
            if(curentTime > dist[i][j])
                continue;
            int time = 1;
            for(int[] direction : DIRECTIONS){
                int x = i + direction[0], y = j + direction[1];
                if(x >= 0 && x<n && y >=0 && y<m){
                    int newDist = Math.max(curentTime, moveTime[x][y]) + time;
                    if(newDist < dist[x][y]){
                        dist[x][y] = newDist;
                        pq.offer(new int[] {newDist,x,y});
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,4],[4,4]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,0],[0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1],[1,2]]\n
// @lcpr case=end

 */

