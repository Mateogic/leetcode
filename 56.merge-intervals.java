/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30204
 *
 * [56] 合并区间
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// List的常用API
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {// 定义数组排序规则
            public int compare(int[] interval1, int[] interval2) {// 按左边界升序排列区间
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();// list便于维护最后一个已有区间
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {// 不能合并（无已有区间或已有区间右边界小于当前区间左边界）
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);// 合并更新已有区间的右边界
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

 */

