package src.main.java.companywise.google.easy;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (n - i >= 0) {
                res++;
                n = n - i;
            }
        }
        return res;
    }
}
