/*
 * @lc app=leetcode.cn id=2829 lang=java
 * @lcpr version=30204
 *
 * [2829] k-avoiding 数组的最小总和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 对于[1,k-1]的数字，在1和k-1之间选1，2和k-2之间选2，直到k/2无论奇偶都可以选
// m=min(k/2,n)，答案的第一部分就是从1到m，等差数列求和公式:m(m+1)/2
// 之后还要选n-m个数字，从k选到k+n-m-1，等差数列求和公式:(n-m)(2k+n-m-1)/2
class Solution {
    public int minimumSum(int n, int k) {
        int m = Math.min(k/2,n);
        return m*(m+1)/2 + (n-m)*(2*k+n-m-1)/2;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n4\n
// @lcpr case=end

// @lcpr case=start
// 2\n6\n
// @lcpr case=end

 */

