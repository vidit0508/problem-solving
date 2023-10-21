package src.main.java.topicwise.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int res = 1;
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.putIfAbsent(pattern, new ArrayList<>());
                map.get(pattern).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Queue<String> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }

                for (int i = 0; i < word.length(); i++) {
                    String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                    for (String neighbourWord : map.get(pattern)) {
                        if (!visited.contains(neighbourWord)) {
                            visited.add(neighbourWord);
                            tempQueue.add(neighbourWord);
                        }
                    }
                }
            }
            queue.addAll(tempQueue);
            res = res + 1;
        }

        return 0;
    }
}
