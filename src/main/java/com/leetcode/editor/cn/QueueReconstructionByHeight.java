package com.leetcode.editor.cn;
//406:根据身高重建队列
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 568 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    // 身高不一样，降序排列
                    return o2[0] - o1[0];
                } else {
                    // 身高相同,按照K升序排列
                    return o1[1] - o2[1];
                }
            });
            List<int[]> res = new ArrayList<>();
            for (int[] person : people) {
                res.add(person[1], person);
            }
            return res.toArray(new int[res.size()][]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new QueueReconstructionByHeight().new Solution();
    }
}