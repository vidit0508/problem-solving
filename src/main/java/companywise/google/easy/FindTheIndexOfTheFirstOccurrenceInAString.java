package src.main.java.companywise.google.easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {

        Character first = needle.charAt(0);
        int max = haystack.length() - needle.length();

        for (int i = 0; i <= max; i++) {
            if (first != haystack.charAt(i)) {
                while (++i <= max && haystack.charAt(i) != first);
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
}
