package src.main.java.topicwise.bit.manipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int oneCount = 0;
        while (n != 0) {
            oneCount = oneCount + (n & 1);
            n = n >>> 1;
        }
        return oneCount;
    }
}
