package src.main.java.strings;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        printArray(s);
        reverseString(s);
        printArray(s);
    }

    private static void printArray(char[] s) {
        System.out.print("[");
        for (char ch : s) {
            System.out.print(ch);
        }
        System.out.println("]");
    }

    private static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }
    }
}
