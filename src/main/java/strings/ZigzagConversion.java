package src.main.java.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1);
            for (int i = r; i < s.length(); i = i + increment) {
                builder.append(s.charAt(i));
                if (r > 0 && r < numRows - 1 && i + increment - (2 * r) < s.length()) {
                    builder.append(s.charAt(i + increment - (2 * r)));
                }
            }
        }
        return builder.toString();
    }
}
