/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30204
 *
 * [15] 三数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<=n-3;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] + nums[i+1] + nums[i+1] > 0)// 优化1
                break;
            if(nums[i] + nums[n-2] + nums[n-1] < 0)// 优化2
                continue;
            int j = i+1, k = n-1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if(nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,0,1,2,-1,-4]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n
// @lcpr case=end

 */

