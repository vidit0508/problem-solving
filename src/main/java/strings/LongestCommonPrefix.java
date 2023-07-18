package src.main.java.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        String prefix  = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public static String getPrefix(String prevPrefix, String comparePrefix) {
        int len = prevPrefix.length() > comparePrefix.length() ? comparePrefix.length() : prevPrefix.length();
        String newPrefix = "";
        for (int i = 0; i < len; i++) {
            if (prevPrefix.charAt(i) == comparePrefix.charAt(i)) {
                newPrefix = newPrefix + prevPrefix.charAt(i);
            } else {
                break;
            }
        }
        return newPrefix;
    }
}
