package src.main.java.companywise.google.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void generate(List<String> ans, StringBuilder builder, int leftCount, int rightCount, int n) {
        if (builder.length() == 2 * n) {
            ans.add(builder.toString());
            return;
        }

        if (leftCount < n) {
            builder.append("(");
            generate(ans, builder, leftCount + 1, rightCount, n);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (leftCount > rightCount) {
            builder.append(")");
            generate(ans, builder, leftCount, rightCount + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
