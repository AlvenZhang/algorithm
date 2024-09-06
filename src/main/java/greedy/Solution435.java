package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {


    public static void main(String[] args) {
        System.out.println(new Solution435().eraseOverlapIntervals1(new int[][]{{1, 2}, {2, 12}}));
    }

    /**
     * 统计没有重叠的区间，然后总数减去统计的数值
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 首先排序，按照开始端点，从小到大
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 记录删除区间的个数
        int countLeft = 0;
        // 记录上一个区间的终点，遍历各个区间
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果区间开始位置小于等于上一个区间的终点，删除（即直接跳过）
            if (intervals[i][0] < lastEnd) {
                countLeft++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        // 防止第一个应该被删除，从右向左重复一遍
        // 记录删除区间的个数
        int countRight = 0;
        // 记录上一个区间的终点，遍历各个区间
        lastEnd = intervals[intervals.length - 1][0];
        for (int i = intervals.length - 2; i >= 0; i--) {
            // 如果区间开始位置小于等于上一个区间的终点，删除（即直接跳过）
            if (intervals[i][1] > lastEnd) {
                countRight++;
            } else {
                lastEnd = intervals[i][0];
            }
        }

        return Math.min(countLeft, countRight);
    }

    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            } else {
                count++;
            }
        }
        return intervals.length - count;
    }
}
