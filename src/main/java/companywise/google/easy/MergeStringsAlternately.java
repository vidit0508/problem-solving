package src.main.java.companywise.google.easy;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int lenOne = word1.length();
        int lenTwo = word2.length();

        int one = 0;
        int two = 0;

        while (one < lenOne && two < lenTwo) {
            sb.append(word1.charAt(one));
            sb.append(word2.charAt(two));
            one++;
            two++;
        }

        while (one < lenOne) {
            sb.append(word1.charAt(one));
            one++;
        }

        while (two < lenTwo) {
            sb.append(word2.charAt(two));
            two++;
        }

        return sb.toString();
    }
}
