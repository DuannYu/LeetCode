import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 912: Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 */
public class SortAlgo {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};

        SortAlgo sortAlgo = new SortAlgo();


        System.out.print("计数排序: ");
        for (int i : sortAlgo.countingSort(arr)) {
            System.out.print(i + "\t");
        }

        System.out.print("\n快速排序: ");

        for (int i : sortAlgo.quickSort(arr)) {
            System.out.print(i + "\t");
        }

        System.out.print("\n堆排序：  ");

        for (int i : sortAlgo.heapSort(arr)) {
            System.out.print(i + "\t");
        }

        System.out.print("\n归并排序：  ");

        for (int i : sortAlgo.mergeSort(arr)) {
            System.out.print(i + "\t");
        }
    }


    private List<Integer> countingSort(int[] nums) {
        if (nums == null) return null;

        int minElem = Integer.MAX_VALUE, maxElem = Integer.MIN_VALUE;

        for (int elem : nums) {
            minElem = Math.min(elem, minElem);
            maxElem = Math.max(elem, maxElem);
        }

        int[] countingArray = new int[maxElem-minElem+1];

        for (int elem : nums) {
            countingArray[elem-minElem]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < countingArray.length; i++) {
            while (countingArray[i] != 0) {
                list.add(i+minElem);
                countingArray[i]--;
            }
        }
        return list;
    }

    private List<Integer> quickSort(int[] nums) {
        if (nums == null) return null;

        quickSort(nums, 0, nums.length-1);

        List<Integer> list = new LinkedList<>();
        for (int elem : nums) {
            list.add(elem);
        }
        return list;
    }

    /**
     * @param nums        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return;

        int left = leftIndex;
        int right = rightIndex;

        // 待排序的第一个元素作为基准值
        int key = nums[left];

        // 从左到右两边交替扫面
        while (left < right) {
            while (right > left && nums[right] > key) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= key) {
                left++;
            }

            nums[right] = nums[left];
        }

        nums[left] = key;

        quickSort(nums, leftIndex, left-1);
        quickSort(nums, right+1, rightIndex);
    }

    private List<Integer> heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }

        List<Integer> list = new LinkedList<>();
        for (int elem : arr) {
            list.add(elem);
        }
        return list;
    }


    private List<Integer> mergeSort(int[] nums) {
        sort(nums, 0, nums.length-1);

        List<Integer> list = new LinkedList<>();
        for (int elem : nums) {
            list.add(elem);
        }
        return list;
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }

    private void sort(int[] nums, int l, int r) {
        if (l == r)
            return;
        int mid = l + (r - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int index = 0;
        int part1 = l;
        int part2 = mid + 1;

        while (part1 <= mid && part2 <= r) {
            temp[index++] = nums[part1] < nums[part2] ? nums[part1++] : nums[part2++];
        }

        while (part1 <= mid) {
            temp[index++] = nums[part1++];
        }

        while (part2 <= r) {
            temp[index++] = nums[part2++];
        }

        for (int i = 0; i < temp.length;i++) {
            nums[l+i] = temp[i];
        }
    }
}
