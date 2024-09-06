package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution406 {

    public static void main(String[] args) {
        System.out.println(new Solution406().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}).toString());
    }

    /**
     * 如果同时确定两个维度，会顾此失彼。
     * 先确定k，则会发现什么都没确定下来
     * 可以先确定h，之后所有人就从高到低排序了
     * 然后
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 按照h从大到小进行排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });


        // 遍历数组，按照k，将元素放到合适的位置
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] != i) {
                // 将people[i][1]放到people[people[i][1]][1]
                int tempH = people[i][0];
                int tempK = people[i][1];
                for (int j = i; j > tempK; j--) {
                    people[j][0] = people[j - 1][0];
                    people[j][1] = people[j - 1][1];
                }
                people[tempK][0] = tempH;
                people[tempK][1] = tempK;
            }
        }


        return people;
    }
}
