/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30204
 *
 * [128] 最长连续序列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int num:nums)
            set.add(num);
        for(int num:set){
            if(!set.contains(num-1)){// 如果num-1存在，说明num不可能是连续序列的起点
                int cur = num;
                int curLen = 1;
                while (set.contains(cur+1)) {
                    cur++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,2]\n
// @lcpr case=end

 */

