package SortAlgo;

/**
 * Question 75: Sort Colors
 *
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    /**
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;

        int left = leftIndex;
        int right = rightIndex;

        // 待排序的第一个元素作为基准值
        int key = arr[left];

        // 从左到右两边交替扫面
        while (left < right) {
            while (right > left && arr[right] > key) {
                right--;
            }

            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }

            arr[right] = arr[left];
        }

        arr[left] = key;

        quickSort(arr, leftIndex, left-1);
        quickSort(arr, right+1, rightIndex);
    }
}
