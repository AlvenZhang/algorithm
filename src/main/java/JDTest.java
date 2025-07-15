import com.sun.org.apache.regexp.internal.REUtil;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class JDTest {
    // 两个有序的列表，将两个有序列表整合成一个
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(5);
        list2.add(7);
        System.out.println(JDTest.merge(list1, list2).toString());
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        // 判空
        if (list1 == null) {
            if (list2 == null) {
                return new ArrayList<>();
            }
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        // 处理剩余的部分
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (i < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }


}
