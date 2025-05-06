/*
 * @lc app=leetcode.cn id=41 lang=java
 * @lcpr version=30204
 *
 * [41] 缺失的第一个正数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 将原始数组处理为哈希数组，所寻元素的取值范围是[1,len+1]
// 当前元素nums[i]的实际位置是i，目标位置是nums[i]-1
// 理想情况是两位置处的元素相同，即nums[nums[i]-1]==nums[i]，否则交换，构成哈希数组
// 正常情况：nums[i]应该存储的值为i+1
// 详细分析：索引 0 1 2 3 ... i-1  i    i+1 ... 
//         取值 1 2 3 4 ... i    x!=i i+3?...
//         正误 y y y y ... y    n 
// 找到第一个为n的位置索引i，返回i+1
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // 处理成哈希数组
        for (int i = 0; i < len; i++) {
            while (nums[i]>=1 && nums[i]<=len && nums[i]!=nums[nums[i]-1]) {// 实际位置元素不等于目标位置元素
                swap(nums, i, nums[i]-1);// 交换当前位置和目标位置处的元素
            }
        }
        // 寻找第一个异常位置
        for (int i = 0; i < len; i++) {
            if (i!=nums[i]-1) {
                return i+1;
            }
        }
        return len+1;// 缺少最后一个元素
    }
    public void swap(int[] nums,int x,int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,-1,1]\n
// @lcpr case=end

// @lcpr case=start
// [7,8,9,11,12]\n
// @lcpr case=end

 */

