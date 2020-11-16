package com.leetcode.editor.cn;
//剑指 Offer 12:矩阵中的路径
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 198 👎 0

import com.leetcode.base.TreeNode;

public class JuZhenZhongDeLuJingLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public boolean exist(char[][] board, String word) {
            if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
                return false;
            }
            int n = board.length;
            int m = board[0].length;
            boolean[][] isVisited = new boolean[board.length][board[0].length];
            char[] chars = word.toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == chars[0]) {
                        if (this.bfs(board, i, j, isVisited, chars, 0)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean bfs(char[][] board, int i, int j, boolean[][] isVisited, char[] chs, int index) {
            if (index == chs.length) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] == true || board[i][j] != chs[index]) {
                return false;
            }
            isVisited[i][j] = true;
            boolean res = bfs(board, i, j - 1, isVisited, chs, index + 1) || bfs(board, i, j + 1, isVisited, chs, index + 1) ||
                    bfs(board, i - 1, j, isVisited, chs, index + 1) || bfs(board, i + 1, j, isVisited, chs, index + 1);
            isVisited[i][j] = false;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }
}