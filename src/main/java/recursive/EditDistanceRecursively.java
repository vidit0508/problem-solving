package src.main.java.recursive;

public class EditDistanceRecursively {

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int s1Len = s1.length();
        int s2Len = s2.length();
        System.out.println(getMinimumEdits(s1, s2, s1Len, s2Len));
    }

    private static int getMinimumEdits(String s1, String s2, int s1Len, int s2Len) {
        if (s1Len == 0) {
            return s2Len;
        }

        if (s2Len == 0) {
            return s1Len;
        }

        if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
            return getMinimumEdits(s1, s2, s1Len - 1, s2Len - 1);
        } else {
            return 1 + Math.min(Math.min(getMinimumEdits(s1, s2, s1Len, s2Len - 1),
                    getMinimumEdits(s1, s2, s1Len - 1, s2Len)),
                    getMinimumEdits(s1, s2, s1Len - 1, s2Len - 1));
        }
    }


}
