package backtracking;

import java.util.*;

public class Solution332 {
    /**
     * TreeMap可以根据键的自然顺序进行排序，或者根据创建映射时提供的Comparator进行排序
     * 机票有可能重复，使用Map<String,<String, Integer>>记录 起点-（终点，数量）
     * 查到最终结果之后立马返回true
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<List<String>> lists = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("SFO");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("ATL");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("ATL");
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("ATL");
        list4.add("JFK");
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("ATL");
        list5.add("SFO");
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        List<String> itinerary = new Solution332().findItinerary(lists);
        System.out.println(itinerary.toString());
    }


    public List<String> findItinerary(List<List<String>> tickets) {
        // 创建tickets的Map结构
        HashMap<String, Map<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            // 判断是否有起点
            if (map.containsKey(ticket.get(0))) {
                Map<String, Integer> temp = map.get(ticket.get(0));
                // 判断是否有终点
                if (temp.containsKey(ticket.get(1))) {
                    temp.put(ticket.get(1), temp.get(ticket.get(1)) + 1);
                    map.put(ticket.get(0), temp);
                } else {
                    temp.put(ticket.get(1), 1);
                    map.put(ticket.get(0), temp);
                }
            } else {
                TreeMap<String, Integer> temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
                map.put(ticket.get(0), temp);
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        ans.add("JFK");
        backTracking(ans, map, tickets.size());
        return ans;
    }

    private boolean backTracking(LinkedList<String> ans, Map<String, Map<String, Integer>> map, int totalSize) {
        // 结束条件
        if (ans.size() == totalSize + 1) {
            return true;
        }

        if (map.containsKey(ans.getLast())) {
            Map<String, Integer> innerMap = map.get(ans.getLast());
            for (String des : innerMap.keySet()) {
                Integer num = innerMap.get(des);
                if (num > 0) {
                    ans.add(des);
                    innerMap.put(des, num - 1);
//                    map.put(, innerMap);
                    if (backTracking(ans, map, totalSize)) {
                        return true;
                    }
                    ans.removeLast();
                    innerMap.put(des, num);
//                    map.put(ans.getLast(), innerMap);
                }
            }
        }
        return false;
    }
}
