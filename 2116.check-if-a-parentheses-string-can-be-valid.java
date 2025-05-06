/*
 * @lc app=leetcode.cn id=2116 lang=java
 * @lcpr version=30204
 *
 * [2116] 判断一个括号字符串是否有效
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 若括号字符串字符数量为计数，直接false
// 通用思路:有效括号字符串的任意前缀，满足左括号数量大于等于右括号数量
// 利用变量c维护未匹配的左括号数量，那么c应该始终大于等于0，并且最终等于0
// locked字符串支持该位置修改为左或右括号，故c的取值是一个(连续奇数/偶数)区间，若修改为左括号则c++，否则c--
// 维护区间的最小值和最大值
// 如果 si=(，那么把 mn 和 mx 都加一。
// 如果 si=)，那么把 mn 和 mx 都减一。如果 mx<0，去掉负数后集合为空，说明无法把 s 变成有效括号字符串。如果 mn<0，那么把 mn 改成 1。比如 {0,2,4} 都减一变成 {−1,1,3}，去掉负数变成 {1,3}，其中最小的数是 1。
// 如果 si=?，这个问号可以是左括号，把 mx 加一；也可以是右括号，把 mn 减一。如果 mn=−1，此时 c 的取值范围都是奇数，把 mn 改成 1。
// 如果最终 mn=0，说明最终 c 能变成 0，我们可以把 s 变成有效括号字符串。
class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if (len%2!=0) // 括号为奇数个，无法匹配
            return false;
        int max = 0, min = 0;// 维护未匹配左括号数量的上下限
        for (int i = 0; i < len; i++) {// 遍历
            if (locked.charAt(i)=='1') {// 不可修改
                int num = s.charAt(i)=='('?1:-1;
                max+=num;
                if (max < 0) // 上限小于0，不可匹配
                    return false;
                min+=num;
            }
            else{// 可以修改
                max++;// 修改为右括号
                min--;// 修改为左括号
            }
            if (min < 0) // 取第二小的数作为新下限 -1 1 3 ....
                min = 1;
        }
        return min==0;// 剩余未匹配左括号数量为0
    }
}
// @lc code=end



/*
// @lcpr case=start
// "))()))"\n"010100"\n
// @lcpr case=end

// @lcpr case=start
// "()()"\n"0000"\n
// @lcpr case=end

// @lcpr case=start
// ")"\n"0"\n
// @lcpr case=end

// @lcpr case=start
// "(((())(((())"\n"111111010111"\n
// @lcpr case=end

 */

