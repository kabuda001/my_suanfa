package com.leetcode.editor.cn;
//在LeetCode商店中， 有许多在售的物品。 
//
// 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。 
//
// 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。 
//
// 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。 
//
// 任意大礼包可无限次购买。 
//
// 示例 1: 
//
// 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
//输出: 14
//解释: 
//有A和B两种物品，价格分别为¥2和¥5。
//大礼包1，你可以以¥5的价格购买3A和0B。
//大礼包2， 你可以以¥10的价格购买1A和2B。
//你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。 
//
// 示例 2: 
//
// 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
//输出: 11
//解释: 
//A，B，C的价格分别为¥2，¥3，¥4.
//你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
//你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
//你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
// 
//
// 说明: 
//
// 
// 最多6种物品， 100种大礼包。 
// 每种物品，你最多只需要购买6个。 
// 你不可以购买超出待购清单的物品，即使更便宜。 
//
// Related Topics 深度优先搜索 动态规划
// 👍 131 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P638ShoppingOffers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<List<Integer>, Integer> memo = new HashMap<>();

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            // 把单独购买打包成一种礼包
            for (int i = 0; i < price.size(); i++) {
                List<Integer> commonPrice = new ArrayList<>();
                for (int j = 0; j < price.size(); j++) {
                    if (i == j) {
                        commonPrice.add(1);
                    } else {
                        commonPrice.add(0);
                    }
                }
                commonPrice.add(price.get(i));
                special.add(commonPrice);
            }
            // 把需要全部为0这种特殊情况先记忆
            List<Integer> needZero = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                needZero.add(0);
            }
            memo.put(needZero, 0);
            return helper(special, needs);
        }

        private int helper(List<List<Integer>> special, List<Integer> needs) {
            if (memo.containsKey(needs)) {
                return memo.get(needs);
            }
            int cost = Integer.MAX_VALUE;
            for (List<Integer> item : special) {
                // 需要该礼包最少的数量
                int k = Integer.MAX_VALUE;
                for (int i = 0; i < item.size() - 1; i++) {
                    if (item.get(i) != 0) {
                        k = Math.min(k, needs.get(i) / item.get(i));
                    }
                }
                if (k == 0) {
                    // 不需要这个礼包，继续找下一个礼包
                    continue;
                }
                List<Integer> remain = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    remain.add(needs.get(i) - k * item.get(i));
                }
                cost = Math.min(cost, this.helper(special, remain) + k * item.get(item.size() - 1));
            }
            // 记忆
            memo.put(needs, cost);
            return cost;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P638ShoppingOffers().new Solution();
    }
}