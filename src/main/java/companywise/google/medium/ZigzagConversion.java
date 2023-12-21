package src.main.java.companywise.google.medium;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int incr = 2 * (numRows - 1);

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < s.length(); i = i + incr) {
                builder.append(s.charAt(i));
                // if curr row is greater then zero and lessn than last row that means
                // we need to add character in between
                if (r > 0 && r < numRows - 1 && i + incr - (2 * r) < s.length()) {
                    builder.append(s.charAt(i + incr - (2 * r)));
                }
            }
        }
        return builder.toString();
    }
}
