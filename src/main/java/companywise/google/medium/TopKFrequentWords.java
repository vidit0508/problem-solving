package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;

        System.out.println(topKFrequent(words, k));

    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // here we used minHeap
        PriorityQueue<String> pQueue = new PriorityQueue<>(
                (w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2))
                        ? w2.compareTo(w1)
                        : freqMap.get(w1) - freqMap.get(w2));

        for (String word : freqMap.keySet()) {
            pQueue.offer(word);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!pQueue.isEmpty()) {
            res.add(pQueue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
