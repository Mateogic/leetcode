/*
 * @lc app=leetcode.cn id=3375 lang=java
 * @lcpr version=30204
 *
 * [3375] 使数组的值全部为 K 的最少操作次数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 本质:计算nums中不同数字的个数
// 选择h为次大值，可以将所有最大值变为次大值
// 若h > min(nums):return -1;无解，操作不可能将更小值变大，只能将最大值变小
// 若h = min(nums):return 数组中不同数字个数 - 1;
// 若h < min(nums):return 数组中不同数字个数;
// 对于用例[5,2,5,4,5]\n2\n
    // 第一次操作选次大值h=4，将最大值变为次大值:[4,2,4,4,4]
    // 第二次操作选次大值h=2，将最大值变为次大值:[2,2,2,2,2]，(这是k=min(nums)的情况，若k=1<min(nums)还要再选一次h=k，变为[1,1,1,1,1])
class Solution {
    public int minOperations(int[] nums, int k) {
        int[] hash = new int[101];
        int min = 101,res = 0;
        for(int num:nums){
            hash[num]++;
            if(min > num)
                min = num;
        }
        if(k>min)
            return -1;
        for(int num:hash){
            if(num > 0)
                res++;
        }
        return k==min?res-1:res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,2,5,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [2,1,2]\n2\n
// @lcpr case=end

// @lcpr case=start
// [9,7,5,3]\n1\n
// @lcpr case=end

 */

