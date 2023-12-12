package src.main.java.companywise.google.easy;

//         XOR works like this
//         So it can be used to find the element among two elements
//        0 ^ 0 = 0
//        0 ^ 1 = 1
//        1 ^ 0 = 1
//        1 ^ 1 = 0

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char ch = 0;

        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ch ^= t.charAt(i);
        }

        return ch;
    }
}
