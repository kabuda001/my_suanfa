package com.leetcode.editor.cn;
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。 
// Related Topics 排序 数组 
// 👍 258 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P57InsertInterval {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> source = new ArrayList<>(Arrays.asList(intervals));
            source.add(newInterval);
            source.sort((o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
            LinkedList<int[]> ans = new LinkedList<>();
            for (int[] cur : source) {
                if (ans.isEmpty()) {
                    ans.add(cur);
                    continue;
                }
                int[] last = ans.getLast();
                if (cur[0] <= last[1]) {
                    last[1] = Math.max(cur[1], last[1]);
                } else {
                    ans.add(cur);
                }
            }
            return ans.toArray(new int[][]{});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P57InsertInterval().new Solution();
    }
}