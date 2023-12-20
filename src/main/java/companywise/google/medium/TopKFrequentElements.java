package src.main.java.companywise.google.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // we used minHeap here
        // todo comparison should more clearer to you
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(
                (num1, num2) -> Integer.compare(freqMap.get(num1), freqMap.get(num2))
        );

        for (int num : freqMap.keySet()) {
            pQueue.offer(num);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }


        int[] res = new int[pQueue.size()];
        int index = 0;
        while (!pQueue.isEmpty()) {
            res[index] = pQueue.poll();
            index++;
        }

        return res;
    }
}
