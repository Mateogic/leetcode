/*
 * @lc app=leetcode.cn id=84 lang=java
 * @lcpr version=30204
 *
 * [84] 柱状图中最大的矩形
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 高度h=h[i]:面积最大矩形的高度一定是某个柱子的高度，可利用反证法证明
// 宽度:right-left-1
    // 左侧left:索引i左侧首个高度小于h的柱子索引
    // 右侧right:索引i右侧首个高度小于h的柱子索引
// 方法一:暴力解法:针对每个柱子遍历找到其左右两侧的left和right
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int res = 0;
//         for(int i = 0;i<heights.length;i++){
//             // 找到高度小于heights[i]的首个左侧/右侧柱子索引left/right
//             int left, right;
//             for(left = i;left>=0;left--){
//                 if(heights[left] < heights[i])
//                     break;
//             }
//             for(right = i;right < heights.length;right++){
//                 if(heights[right] < heights[i])
//                     break;
//             }
//             res = Math.max(res, heights[i]*(right - left-1));
//         }
//         return res;
//     }
// }
// 方法二:预处理法:时间换空间
    // 利用之前处理过的左右边界避免重复比较，双重循环但时间复杂度为O(n)
// class Solution{
//     public int largestRectangleArea(int[] height){
//         int res=  0;
//         int n = height.length;
//         int[] left = new int[n];// 左侧第一个小于当前高度的柱子位置
//         int[] right = new int[n];// 右侧第一个小于当前高度的柱子位置
//         // 预处理左边界
//         for(int i = 0;i<n;i++){
//             int l = i-1;
//             while(l > -1 && height[l] >= height[i])// 利用已知柱子的边界跳过不避免的比较
//                 l = left[l];// 向左跳过那些高度不小于当前柱子的位置
//             left[i] = l;// left[0] = -1(边界)
//         }
//         // 预处理右边界
//         for(int i = n-1;i>=0;i--){
//             int r = i+1;
//             while(r < n && height[r] >= height[i])
//                 r = right[r];// 向右跳
//             right[i] = r;// right[n-1] = n(边界)
//         }
//         for(int i = 0;i<n;i++)
//             res = Math.max(res,(right[i] - left[i]-1)*height[i]);
//         return res;
//     }
// }

// 方法三:单调栈法
    // 维护单调递增栈，当前元素入栈之前，栈顶即为首个小于当前高度的柱子索引
    // 如果空栈，表示该侧所有柱子都比当前柱子更高，边界为-1(左)或n(右)
import java.util.ArrayDeque;
import java.util.Deque;
class Solution{
    public int largestRectangleArea(int[] height){
        int res = 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        // 处理左边界
        for(int i = 0;i<n;i++){
            while(!stk.isEmpty() && height[stk.peek()] >= height[i])// 清除栈内大于当前高度的柱子索引
                stk.pop();
            left[i] = stk.isEmpty()?-1:stk.peek();// 空栈:左边界为-1, left[0] = -1/非空:栈顶元素即为左边界
            stk.push(i);
        }
        // 清空栈，处理右边界
        stk.clear();
        for(int i = n-1;i>=0;i--){
            while(!stk.isEmpty() && height[stk.peek()] >= height[i])
                stk.pop();
            right[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        for(int i = 0;i<n;i++)
            res = Math.max(res, (right[i] - left[i]-1)*height[i]);
        return res;
    }
}
    // @lc code=end
/*
// @lcpr case=start
// [2,1,5,6,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n
// @lcpr case=end

 */

