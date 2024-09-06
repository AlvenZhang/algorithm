package greedy;

import java.util.Arrays;

public class Solution455 {

    /**
     * 局部最优解：大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个
     * 全局最优解：喂饱尽可能多的小孩
     *
     * @param args
     */
    public static void main(String[] args) {
        int contentChildren = new Solution455().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        // 将饼干与孩子进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = g.length - 1;
        int i1 = s.length - 1;
        for (; i >= 0; i--) {
            if (i1 >= 0) {
                // 如果饼干满足孩子，则计数；无论是否满足，尝试一次之后都进行下一个孩子
                if (g[i] <= s[i1]) {
                    count++;
                    i1--;
                }
//                break;
            }
        }
        return count;
    }
}
