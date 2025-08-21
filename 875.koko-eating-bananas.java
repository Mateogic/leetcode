/*
 * @lc app=leetcode.cn id=875 lang=java
 * @lcpr version=30204
 *
 * [875] 爱吃香蕉的珂珂
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0, res = 0, mid = 0;
        for(int pile: piles){
            if(pile > right)
                right = pile;
        }
        while(left <= right){
            mid = left + (right - left) / 2;
            if(check(piles, mid) <= h){// 如果花费时间小于h，还可以多花点时间，但是符合题意，记录m，向左二分
                res = mid;
                right = mid - 1;
            }
            else// 花费时间大于h，需要加快速度，不记录m，向右二分
                left = mid + 1;
        }
        return res;
    }
    public long check(int[] piles, int speed){
        long need = 0;
        for(int pile:piles){
            need+=(pile + speed - 1) / speed;// 向上取整
        }
        return need;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,6,7,11]\n8\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n5\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n6\n
// @lcpr case=end

 */

