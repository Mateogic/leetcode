/*
 * @lc app=leetcode.cn id=2349 lang=java
 * @lcpr version=30204
 *
 * [2349] 设计数字容器系统
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Map;
import java.util.TreeSet;

class NumberContainers {
    private final Map<Integer, Integer> indexToNumber = new HashMap<>();
    // 使用treeset实现自动索引排序，便于根据number快速找到index
    private final Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public void change(int index, int number) {
        Integer oldNumber = indexToNumber.get(index);
        if(oldNumber!=null){
            numberToIndices.get(oldNumber).remove(index);
        }
        indexToNumber.put(index,number);
        numberToIndices.computeIfAbsent(number,_ ->new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        TreeSet<Integer> indices = numberToIndices.get(number);
        return indices==null||indices.isEmpty()?-1:indices.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
// @lc code=end



/*
// @lcpr case=start
// ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"][[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]\n
// @lcpr case=end

 */

