package stackandqueue;

import com.sun.corba.se.spi.transport.ReadTimeouts;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {

    public static void main(String[] args) {
        int[] ints = new Solution239().maxSlidingWindow_my(new int[]{7,-8,7,5,7,1,6,0}, 4);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 暴力解法，每个窗口直接求最大值。超时
     * 使用指针减少循环，仍然超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int maxPos = findMaxOne(nums, 0, k);
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[maxPos] < nums[i + k - 1]) {
                maxPos = i + k - 1;
            } else if (i > maxPos) {
                maxPos = findMaxOne(nums, i, i + k);
            }
            res[i] = nums[maxPos];
        }
        return res;
    }

    // 遍历窗口寻找最大值位置
    private int findMaxOne(int[] nums, int start, int end) {
        int maxPos = start;
        for (int i = start; i < end; i++) {
            if (nums[maxPos] < nums[i]) {
                maxPos = i;
            }
        }
        return maxPos;
    }


    public int[] maxSlidingWindow_my(int[] nums, int k) {
        Deque_my dequeMy = new Deque_my();
        int[] res = new int[nums.length - k + 1];
        // 先将第一个窗口的数据输入队列中
        for (int i = 0; i < k; i++) {
            dequeMy.add(nums[i]);
        }
        res[0] = dequeMy.peek();
        dequeMy.pop(nums[0]);
        for (int i = 1; i < nums.length - k + 1; i++) {
            dequeMy.add(nums[i + k - 1]);
            res[i] = dequeMy.peek();
            dequeMy.pop(nums[i]);
        }

        return res;
    }

    /**
     * 维持一个队列，队列中的最大位置始终在队尾的位置。队列只保留较大的值，如果队列中来了一个相对大的值，则需要将队列中比它小的值移除。（注意这里队列的两端都可以出队）
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue2 myQueue = new MyQueue2();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

class Deque_my {
    // 保证queue中头部元素最大
    private Deque<Integer> queue = new LinkedList();

    // 入队
    public void add(int number) {
        // 队列头部数据最大，尾部如果有数据比number小，则让其出队
        while (!queue.isEmpty() && queue.peekLast() < number) {
            queue.removeLast();
        }
        queue.add(number);
    }

    // 出队
    public void pop(int number) {
        // 出队也就是取出最大的元素
        // 如果队头元素等于number，表示number已经被移出窗口，应该出队
        if (!queue.isEmpty() && number == queue.peekFirst()) {
            queue.pop();
        }
        // 此时队头元素的下一个元素就是队列中的最大值
    }

    public int peek() {
        return queue.peek();
    }

    //
}


//自定义数组
class MyQueue2 {
    Deque<Integer> deque = new LinkedList<>();

    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}