//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 479 👎 0


package leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int len = matrix[0].length;
            int rowLen = matrix.length;
            for (int i = 0; i < rowLen; i++) {
                if (matrix[i][len - 1] > target){
                    return binaryFind(matrix[i],target,0,len - 1);
                }
            }
            return false;
        }

        public boolean binaryFind(int[] nums,int target,int l,int r){
            while (l < r){
                int mid = (r - l >> 1) + l;
                if (nums[mid] == target){
                    return true;
                }else if (nums[mid] > target){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }
            return nums[l] == target ? true : false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}