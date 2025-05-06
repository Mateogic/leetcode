/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30204
 *
 * [207] 课程表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 拓扑排序(BFS)
// 记录入度数量
// 构建邻接表记录每门课程的后续课程
// 将入度为0的课程(无先修课程)加到队列，表示已修读该课程
// 然后根据邻接表查询后续课程，将后续课程的入度-1，进而尝试将其入队

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];// 入度
        int cnt = 0;// 已经修读的课程数量
        List<List<Integer>> adjList = new ArrayList<>();// 邻接表
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // 记录初始入度+构建邻接表
        for(int[] prerequisite:prerequisites){
            int preCourse = prerequisite[1];
            int postCourse = prerequisite[0];
            inDegrees[postCourse]++;
            adjList.get(preCourse).add(postCourse);// 记录每门课程的后续课程
        }

        // 将入度为0的课程入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i]==0)
                queue.offer(i);
        }

        // 拓扑排序
        while(!queue.isEmpty()){
            int studyedCourse = queue.poll();
            cnt++;
            List<Integer> postCourses = adjList.get(studyedCourse);// 获取后续课程列表
            for(int postCourse:postCourses){
                inDegrees[postCourse]--;
                if(inDegrees[postCourse]==0)// 尝试入队
                    queue.offer(postCourse);
            }
        }
        return cnt==numCourses;// 修读课程数量 == 所有课程数量
    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

