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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int first = 0;first < n; first++){
            if (first > 0 && nums[first] == nums[first-1])// 不再枚举和上次相同的数，否则会重复
                continue;
            int third = n - 1;
            for (int second = first + 1;second < n;second++){
                if (second > first+1 && nums[second] == nums[second-1])
                    continue;
                while (second < third && nums[first] + nums[second] + nums[third] > 0)
                    third--;// 出循环的情况：second == third 或者 nums[first] + nums[second] + nums[third] <= 0
                // 如果跳出循环的情况为：second == third && nums[first] + nums[second] + nums[third] < 0也不应该继续增大second
                // 因为这种情形的前步为：third = second + 1 = flag + 1 && nums[first] + nums[second] + nums[third] > 0
                // 即nums[first] + nums[flag] + nums[flag+1] > 0
                // 继续增大second枚举，最小三数之和nums[first] + nums[flag+1] + nums[flag+2]必然大于0
                if (second == third)// 相当于重复使用nums[second]，即便满足nums[first] + nums[second] + nums[third] == 0也不是合法的三元组
                    break;// 终止循环，继续枚举second不再有合法的third
                if (nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
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

