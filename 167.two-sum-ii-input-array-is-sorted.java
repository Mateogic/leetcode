/*
 * @lc app=leetcode.cn id=167 lang=java
 * @lcpr version=30204
 *
 * [167] 两数之和 II - 输入有序数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            if(numbers[i] + numbers[j]==target)
                break;
            if(numbers[i] + numbers[j] > target)
                j--;
            else
                i++;
        }
        return new int[]{i+1,j+1};
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [2,3,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [-1,0]\n-1\n
// @lcpr case=end

 */

