/*
 * @lc app=leetcode.cn id=2109 lang=java
 * @lcpr version=30204
 *
 * [2109] 向字符串添加空格
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 方法一:双指针
// 指针i遍历字符串，指针j遍历spaces数组，题目要求在s(spaces[j])之前append(' ')
// 因此，在append(s.charAt(i))之前判断是否有i == spaces[j]，若是则先append(' ')后append(s.charAt(i))，否则直接append(s.charAt(i))
// StringBuffer是一种线程安全、支持可变的字符序列
// class Solution {
//     public String addSpaces(String s, int[] spaces) {
//         StringBuffer sb = new StringBuffer();
//         int n = s.length(), m = spaces.length;
//         for(int i = 0,j = 0;i<n;i++){
//             if(j <m && i == spaces[j]){
//                 sb.append(' ');
//                 j++;
//             }
//             sb.append(s.charAt(i));
//         }
//         return sb.toString();
//     }
// }
// 方法二:substring
// 假设spaces有m个元素，相当于用空格将字符串s切割成m+1个子串
// 每个子串的起始和结尾索引分别为spaces[i]和spaces[i+1]-1，恰好符合 substring(spaces[i],spaces[i+1]) 左开右闭的特性
// 注意第一个子串的起止索引分别为0和spaces[0]-1 -> substring(0,spaces[0])，最后一个子串的起止索引为spaces[m-1]和n-1 -> substring(spaces[m-1])
// 使用start维护起始索引，即上次遍历的结尾索引
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int start = 0;
        for(int space : spaces){
            sb.append(s.substring(start,space));
            sb.append(' ');
            start = space;
        }
        sb.append(s.substring(start));// 添加最后剩余的子串
        return sb.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "LeetcodeHelpsMeLearn"\n[8,13,15]\n
// @lcpr case=end

// @lcpr case=start
// "icodeinpython"\n[1,5,7,9]\n
// @lcpr case=end

// @lcpr case=start
// "spacing"\n[0,1,2,3,4,5,6]\n
// @lcpr case=end

 */

