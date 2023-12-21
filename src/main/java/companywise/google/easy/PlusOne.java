package src.main.java.companywise.google.easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] < 9) {
            digits[len - 1] = digits[len - 1] + 1;
            return digits;
        } else {
            int sum = digits[len - 1] + 1;
            digits[len - 1] = 0;
            int i = len - 2;
            int carry = sum / 10;
            while (i >= 0) {
                sum = digits[i] + carry;
                carry = sum / 10;
                digits[i] = sum % 10;
                i--;
            }
            if (carry > 0) {
                int[] arr = new int[digits.length + 1];
                arr[0] = carry;
                for (i = 1; i < arr.length; i++) {
                    arr[i] = digits[i - 1];
                }
                return arr;
            } else {
                return digits;
            }
        }
    }
}
