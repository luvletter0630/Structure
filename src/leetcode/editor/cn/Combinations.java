//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 652 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(4,2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res ;

        public List<List<Integer>> combine(int n, int k){
            res = new ArrayList<>();
            dfs(new ArrayList<Integer>(),n,k,0);
            return res;
        }

        private void dfs(List<Integer> list,int n,int k,int x){
            if (list.size() + (n - x + 1) < k){
                return;
            }
            if (list.size() == k){
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = x + 1; i <= n; i++) {
                list.add(i);
                dfs(list,n,k,i);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}