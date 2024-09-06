package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Solution425 {

    public static void main(String[] args) {
//        System.out.println(2147483646 - (-2147483646));
        System.out.println(new Solution425().findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}));
    }

    /**
     * 先按照起始位置从小到大排序
     * 然后从左到右遍历x轴，一旦遇到有气球结束，则射出一支弓箭
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0;
        // 射箭位置
        long pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 起始位置大于最后射箭位置
            if (points[i][0] > pos) {
                count++;
                // 重置最后射箭位置
                pos = points[i][1];
            } else {
                // 起始位置小于等于最后射箭位置
                // 检查是否需要更新最后射箭位置
                if (points[i][1] < pos) {
                    // 需要更新
                    pos = points[i][1];
                }
            }
        }
        return ++count;
    }
}
