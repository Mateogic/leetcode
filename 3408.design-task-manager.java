/*
 * @lc app=leetcode.cn id=3408 lang=java
 * @lcpr version=30204
 *
 * [3408] 设计任务管理器
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class TaskManager {
    // taskId -> (priority, userId)
    private final Map<Integer, int[]> mp = new HashMap<>();

    // (priority, taskId, userId)
    // 最大堆，将优先级最高、taskId最高(优先级相同)的任务放在堆顶
    private final PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            this.add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        mp.put(taskId, new int[]{priority, userId});
        pq.offer(new int[]{priority, taskId, userId});
    }

    public void edit(int taskId, int newPriority) {
        // 懒修改
        int userId = mp.get(taskId)[1];
        this.add(userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        // 懒删除
        mp.get(taskId)[0] = -1;
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1], userId = top[2];
            int[] p = mp.get(taskId);
            if (p[0] == priority && p[1] == userId) {
                rmv(taskId);
                return userId;
            }
            else// 货不对板，堆顶和 mp 中记录的不一样，说明堆顶数据已被修改或删除，不做处理
                continue;
        }
        return -1;
    }
}
/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
// @lc code=end



/*
// @lcpr case=start
// ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"][[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]\n
// @lcpr case=end

 */

