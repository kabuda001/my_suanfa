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

import java.util.List;

public class P638ShoppingOffers {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int result = 0;
            int size = price.size();
            for (int i = 0; i < size; i++) {
                result += price.get(i) * needs.get(i);
            }
            for (List<Integer> item : special) {
                // 是否有效
                boolean isValid = true;
                for (int i = 0; i < size; i++) {
                    if (needs.get(i) < item.get(i)) {
                        // 超过要买的了
                        isValid = false;
                    }
                    // 减去礼包包含的商品
                    Integer need = needs.get(i);
                    need -= item.get(i);
                    needs.set(i, need);

                }
                if (isValid) {
                    // 递归，needs已经减去了礼包包含
                    result = Math.min(result, this.shoppingOffers(price, special, needs) + item.get(item.size() - 1));
                }
                // 还原needs
                for (int i = 0; i < size; i++) {
                    Integer need = needs.get(i);
                    need += item.get(i);
                    needs.set(i, need);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        //测试代码
        Solution solution = new P638ShoppingOffers().new Solution();
    }
}