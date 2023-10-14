package src.main.java.topicwise.graph;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = getSum(gas);
        int costSum = getSum(cost);

        // below condition means that solution is not present
        if (gasSum < costSum) {
            return -1;
        }

        int res = 0;
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            sum = sum + (gas[i] - cost[i]);
            if (sum < 0) {
                sum = 0;
                // we are adding plus one directly because we are sure from sum logic then solution is present
                res = i + 1;
            }
        }
        return res;
    }

    private static int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
