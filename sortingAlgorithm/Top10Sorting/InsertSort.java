package sortingAlgorithm.Top10Sorting;

/**
 * 插入排序
 * 基本操作就是将一个数据插入到已经排好序的有序数据中，从而得到一个新的、个数加一的有序数据，
 * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 *
 * 我们把第一个元素当作已排好序的有序数据，从第二个元素开始判断插入位置
 */
public class InsertSort {

    public static void insertSort(int[] arrays) {
        int temp;
        for (int i = 1; i < arrays.length; i++) {

            temp = arrays[i];

            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较，不断往前比较，插入到大的数的前面
            int j = i - 1;

            while (j >= 0 && arrays[j] > temp) {

                //往后退一个位置，让当前数据与之前前位进行比较
                arrays[j + 1] = arrays[j];

                //不断往前，直到退出循环
                j--;

            }
            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[j + 1] = temp;

        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        insertSort(arrays);
        for (int i: arrays) {
            System.out.println(i);
        }
    }
}
