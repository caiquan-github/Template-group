//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int value1 = 0;
        int value2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                value1 = 1;
                continue;
            }
            if (i == 2) {
                value2 = 2;
                continue;
            }
            int v3 = value1 + value2;
            value1 = value2;
            value2 = v3;
        }
        return value2;

    }


}

//leetcode submit region end(Prohibit modification and deletion)
