/**
 * 题目Id: 1418
 * 题目：点菜展示表
 * 日期: 2021-07-06 20:42:38
 **/
//给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodIt
//emi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。 
//
// 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中
//的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。 
//
// 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。 
//
// 
//
// 示例 1： 
//
// 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David",
//"3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","
//Ceviche"]]
//输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1
//","0"],["5","0","1","0","1"],["10","1","0","0","0"]] 
//解释：
//点菜展示表如下所示：
//Table,Beef Burrito,Ceviche,Fried Chicken,Water
//3    ,0           ,2      ,1            ,0
//5    ,0           ,1      ,0            ,1
//10   ,1           ,0      ,0            ,0
//对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
//而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
//餐桌 10：Corina 点了 "Beef Burrito" 
// 
//
// 示例 2： 
//
// 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],[
//"Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","
//Canadian Waffles"]]
//输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
// 
//解释：
//对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
//而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
// 
//
// 示例 3： 
//
// 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melis
//sa","2","Soda"]]
//输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= orders.length <= 5 * 10^4 
// orders[i].length == 3 
// 1 <= customerNamei.length, foodItemi.length <= 20 
// customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。 
// tableNumberi 是 1 到 500 范围内的整数。 
// 
// Related Topics 数组 哈希表 字符串 有序集合 排序 
// 👍 60 👎 0

package leetcode.editor.cn;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant {
    public static void main(String[] args) {
        Solution solution = new DisplayTableOfFoodOrdersInARestaurant().new Solution();
        List<String> list = new ArrayList<>();
        list.add("David");
        list.add("3");
        list.add("Ceviche");
        List<String> list1 = new ArrayList<>();
        list1.add("Corina");
        list1.add("10");
        list1.add("Beef Burrito");
        List<String> list2 = new ArrayList<>();
        list2.add("David");
        list2.add("3");
        list2.add("Fried Chicken");
        List<String> list3 = new ArrayList<>();
        list3.add("Carla");
        list3.add("5");
        list3.add("Water");
        List<String> list4 = new ArrayList<>();
        list4.add("Carla");
        list4.add("5");
        list4.add("Ceviche");
        List<String> list5 = new ArrayList<>();
        list5.add("Rous");
        list5.add("3");
        list5.add("Ceviche");
        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        solution.displayTable(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Map<Integer, HashMap<String, Integer>> table = new HashMap<>(512);
            Set<String> foodnames = new HashSet<>();
            for (List<String> order : orders) {
                foodnames.add(order.get(2));
                HashMap<String, Integer> food = table.getOrDefault(Integer.parseInt(order.get(1)), new HashMap<String, Integer>());
                food.put(order.get(2), food.getOrDefault(order.get(2), 0) + 1);
                table.put(Integer.parseInt(order.get(1)), food);
            }

            int fdnameSetLen = foodnames.size();
            List<String> foodName = new ArrayList<String>();
            for(String s : foodnames){
                foodName.add(s);
            }
            Collections.sort(foodName);

            List<Integer> tableList = new ArrayList<>();
            for (int tablenum:table.keySet()) {
                tableList.add(tablenum);
            }
            int tablelen = tableList.size();
            Collections.sort(tableList);

            List<List<String>> result = new ArrayList<List<String>>();
            List<String> header = new ArrayList<>();
            header.add("Table");
            for (int i = 0; i < fdnameSetLen; i++) {
                header.add(foodName.get(i));
            }
            result.add(header);
            for (int i = 0; i < tablelen; i++) {
                List<String> row = new ArrayList<>();
                row.add(tableList.get(i).toString());
                Map<String,Integer> map = table.get(tableList.get(i));
                for (int j = 0; j < fdnameSetLen; j++) {
                    row.add(Integer.toString(map.getOrDefault(foodName.get(j),0)));
                }
                result.add(row);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}