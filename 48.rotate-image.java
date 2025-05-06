/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30204
 *
 * [48] 旋转图像
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// matrix[i][j] -> matrix[j][n-i-1]
// 先矩阵转置:matrix[i][j] -> matrix[j][i]
// 再依据竖直对称轴翻转:matrix[j][i] -> matrix[j][n-i-1]
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp = 0;
        // 矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 竖轴对称翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
// @lcpr case=end

 */

