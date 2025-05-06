/*
 * @lc app=leetcode.cn id=240 lang=java
 * @lcpr version=30204
 *
 * [240] 搜索二维矩阵 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 将矩阵逆时针旋转 45° ，转化为图形式，发现其类似于 二叉搜索树 ，
// 即对于每个元素，其左分支元素更小、右分支元素更大。
// 因此，通过从 “左下根节点” 开始搜索，遇到比 target 大的元素就向左，反之向右，即可找到目标值 target
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length, m = matrix[0].length;
//         int i = n-1,j=0;
//         while (i>=0 && j<=m-1) {
//             if (matrix[i][j] < target) 
//                 j++;
//             else if (matrix[i][j] > target) 
//                 i--;
//             else
//                 return true;
//         }
//         return false;
//     }
// }

// 逐行二分
class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        for(int[] nums : matrix){
            int idx = binarySearch(nums, target);
            if (idx>=0) {
                return true;
            }
        }
        return false;
    }
    public int binarySearch(int[] nums, int target){
        int l = 0,r = nums.length-1;
        while (l<=r) {
            int mid = (r-l)/2+l;
            if (nums[mid] == target) 
                return mid;
            else if(nums[mid] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n20\n
// @lcpr case=end

 */

