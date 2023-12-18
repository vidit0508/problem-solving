package src.main.java.companywise.google.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < email.length(); i++) {
                char curr = email.charAt(i);
                if (curr == '+' || curr == '@') {
                    break;
                }

                if (curr != '.') {
                    sb.append(curr);
                }
            }

            StringBuilder domainBuilder = new StringBuilder();

            for (int i = email.length() - 1; i >= 0; i--) {
                char curr = email.charAt(i);
                domainBuilder.append(curr);
                if (curr == '@') {
                    break;
                }
            }
            domainBuilder = domainBuilder.reverse();
            sb.append(domainBuilder);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}
