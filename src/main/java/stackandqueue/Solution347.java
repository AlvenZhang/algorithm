package stackandqueue;

import java.awt.*;
import java.util.*;

public class Solution347 {


    public static void main(String[] args) {
        int[] ints = new Solution347().topKFrequent3(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    /**
     * 可以成功，但是时间复杂度较高
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for (Integer integer : map.keySet()) {
                Integer i1 = map.get(integer);
                if (i1 > max) {
                    max = i1;
                    maxKey = integer;
                }
            }
            map.remove(maxKey);
            res[i] = maxKey;
        }
        return res;
    }

    /**
     * 使用小根堆实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        // 使用map统计出现频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 使用小根堆得到k个频率最高的值
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
            } else {
                if (integerIntegerEntry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
                }
            }
        }
        // 队列中所有的元素出队
        int[] res = new int[k];
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }


    //解法2：基于小顶堆实现
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //key为数组元素值,val为对应出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num, cnt),cnt表示元素值num在数组中的出现次数
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //小顶堆只需要维持k个元素有序
            if (pq.size() < k) { //小顶堆元素个数小于k个时直接加
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) { //当前元素出现次数大于小顶堆的根结点(这k个元素中出现次数最少的那个)
                    pq.poll(); //弹出队头(小顶堆的根结点),即把堆里出现次数最少的那个删除,留下的就是出现次数多的了
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
