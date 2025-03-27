/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 前缀和+哈希表优化

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, 1);// 用于应对pre=k的特殊情况
        for(int i = 0;i<nums.length;i++){
            pre+=nums[i];
            if (mp.containsKey(pre-k)) {// 以i结尾子数组中和为k的数量为mp.get(pre-k)
                res+=mp.get(pre-k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0)+1);// 更新mp
        }
        return res;
    }
}
// 枚举
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int res = 0, len = nums.length;
//         for(int start = 0;start < len;start++){
//             int sum = 0;
//             for(int end = start;end>=0;end--){
//                 sum+=nums[end];
//                 if (sum == k) {
//                     res++;
//                 }
//             }
//         }
//         return res;
//     }
// }

// @lc code=end



/*
// @lcpr case=start
// [1,1,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n3\n
// @lcpr case=end

 */

