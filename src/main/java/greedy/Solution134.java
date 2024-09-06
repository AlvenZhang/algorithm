package greedy;

import javafx.scene.layout.CornerRadii;
import sun.rmi.transport.proxy.RMISocketInfo;

import java.util.Currency;

public class Solution134 {

    public static void main(String[] args) {
        System.out.println(new Solution134().canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 4, 1}));
//        int a = 1;
//        int b = 3;
//        a%=b;
//        System.out.println(a);
    }

    /**
     * 从头开始遍历站点。
     * 若本站点不可以通过。并且清空curSum
     * 如果本站点可以通过。那么继续下一个站点
     *
     * 不断从0向前推动Index，直到找到合适的位置，或者到最后一个位置。然后totalSum为负表示未找到合适起点
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            // 计算当前站点汽油使用情况
            curSum += gas[i] - cost[i];
            // 计算汽油总量
            totalSum += gas[i] - cost[i];
            // 如果当前站点使用汽油大于汽油存储量
            if (curSum < 0) {
                // 将起点索引直接向后一个挪动
                index = (i + 1) % gas.length;
                // 重置当前站点汽油使用情况
                curSum = 0;
            }
        }
        // 如果最终汽油使用总量大于汽油存储总量，则表示不符合
        if (totalSum < 0) return -1;
        return index;
    }

}
