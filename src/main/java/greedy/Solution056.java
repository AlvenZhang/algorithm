package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution056 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution056().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }

    /**
     * 按照起点进行排序
     * 遍历区间，先确定起点，然后更新终点
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 使用两个List记录起点和终点
        List<int[]> res = new LinkedList<>();
        int[] cache = new int[2];
        cache[0] = intervals[0][0];
        // 记录区间终点的更新
        int pos = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= pos) {
                // 交叉，更新pos
                pos = Math.max(pos, intervals[i][1]);
            } else {
                // 未交叉，记录终点位置
                cache[1] = pos;
                res.add(cache);
                // 重置起点位置
                cache = new int[2];
                cache[0] = intervals[i][0];
                // 重置pos
                pos = intervals[i][1];
            }
        }

        // 补上最后一个终点
        cache[1] = pos;
        res.add(cache);

        return res.toArray(new int[res.size()][]);
    }
}
