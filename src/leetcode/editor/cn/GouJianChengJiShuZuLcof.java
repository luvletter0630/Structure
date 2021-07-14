/**
 * 题目Id: 剑指 Offer 66
 * 题目：构建乘积数组
 * 日期: 2021-07-05 21:21:39
 **/
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 
// 👍 127 👎 0

package leetcode.editor.cn;

public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        System.out.println("Hello world");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int size = a.length;
            int[] supArray = new int[size];
            //1 a[0] a[0]*a[1] a[0]*[1]*a[2] a[0]*[1]*a[2]*a[4]
            for (int i = 0; i < size; i++) {
                supArray[i] = 1;
            }
            for (int i = 0, cnt = 1; i < size; i++) {
                supArray[i] *= cnt;
                cnt *= a[i];
            }

            for (int i = size - 2, cnt = a[i + 1]; i >= 0; i--) {
                supArray[i] *= cnt;
                cnt *= a[i];
            }
            return supArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}