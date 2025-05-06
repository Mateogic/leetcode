/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 偏移量
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int m = matrix.length, n = matrix[0].length;
//         List<Integer> res = new ArrayList<>();
//         boolean[][] visited = new boolean[m][n];
//         int curRow = 0, curCol = 0;
//         int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
//         int directionsIdx = 0;
//         int cnt = m*n;
//         for(int i = 0;i<cnt;i++){
//             res.add(matrix[curRow][curCol]);
//             visited[curRow][curCol] = true;
//             int nextRow = curRow + directions[directionsIdx][0];
//             int nextCol = curCol + directions[directionsIdx][1];
//             // 越界或已经访问过
//             if (nextRow <0 || nextRow>=m || nextCol < 0 || nextCol>=n || visited[nextRow][nextCol]==true) 
//                 directionsIdx = (directionsIdx+1)%4;
//             curRow +=directions[directionsIdx][0];
//             curCol +=directions[directionsIdx][1];
//         }
//         return res;
//     }
// }

// 缩圈模拟
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n-1, top = 0, bottom = m-1;
        while(left <= right && top <= bottom){
            for(int i = left;i<=right;i++)
                res.add(matrix[top][i]);
            top++;
            for(int i = top;i<=bottom;i++)
                res.add(matrix[i][right]);
            right--;
            if (left <= right && top <= bottom) {// 针对行列数目不等的矩阵判断
                for(int i = right;i>=left;i--)
                    res.add(matrix[bottom][i]);
                bottom--;
            }

            if (left <= right && top <= bottom) {
                for(int i = bottom;i>=top;i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
// @lcpr case=end

 */

