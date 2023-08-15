package src.main.java.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int count = 0;

        int i = 0;
        while (i < k) {
            while (!deque.isEmpty()
                    && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            i++;
        }

        for ( ; i < nums.length; i++) {
            res[count++] = nums[deque.peekFirst()];
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty()
                    && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res[count++] = nums[deque.peekFirst()];
        return res;
    }
}
