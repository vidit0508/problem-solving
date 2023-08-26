package src.main.java.searchingandsorting;

public class QuickSort {

    static int[] nums = null;

    public static void main(String[] args) {
        nums = new int[]{4, 6, 2, 5, 7, 9, 1, 3};
        System.out.println("before sorting");
        print();
        System.out.println();
        doQuickSort(0, nums.length - 1);
        System.out.println("after sorting");
        print();
    }

    private static void doQuickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = doPartitioning(low, high);
            doQuickSort(low, pivotIndex - 1);
            doQuickSort(pivotIndex + 1, high);
        }
    }

    private static int doPartitioning(int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (nums[i] <= pivot) {
                i++;
            }

            while (nums[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(i, j);
            }
        }

        swap(low, j);
        return j;
    }

    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print() {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
