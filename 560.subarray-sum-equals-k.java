/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;
import java.util.Map;
// 前缀和+哈希表优化
// 用一个哈希表 cnt 统计 s[j] 的个数。那么枚举到 s[j] 时，就可以用O(1)的时间复杂度从哈希表中就可以找到有 cnt[s[j]−k] 个 s[i]，即为元素和等于 k 的子数组个数
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
            mp.put(pre, mp.getOrDefault(pre, 0)+1);// 更新和为pre前缀和的数量
        }
        return res;
    }
}
// 枚举
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int res = 0, len = nums.length;
//         for(int end = 0;end < len;end++){
//             int sum = 0;
//             for(int start = end;start>=0;start--){
//                 sum+=nums[start];
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

