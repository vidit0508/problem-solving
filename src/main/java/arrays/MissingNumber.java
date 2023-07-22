package src.main.java.arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int len = arr.length;
        int sum = (len * (len + 1)) / 2;
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }
        return sum;
    }
}
