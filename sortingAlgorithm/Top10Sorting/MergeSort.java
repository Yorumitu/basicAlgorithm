package sortingAlgorithm.Top10Sorting;

/**
 * 归并排序
 *      归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *      将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 *
 * 步骤：遍历两个数组，比较它们的值。谁比较小，谁先放入大数组中，直到数组遍历完成
 *
 * 优化：
 *     1. 对小规模子数组使用插入排序，小规模范围内插入排序性能更优
 *     2. 测试子数组是否已经有序，如果有序则不需要合并
 *          if (liftArray[mid] > rightArray[mid+1]) merge(...);
 *     3. 改为自底向上的归并，不依赖递归实现，不需要系统递归栈，时间复杂度相同但性能更好
 */
public class MergeSort {
    /**
     * 不断划分区间后，逐渐将小区间合并排序
     * @param arrays
     * @param L
     * @param R
     */
    public static void mergeSort(int[] arrays, int L, int R){
        //只剩一个元素，不用排了
        if (L == R) {
            return ;
        } else {
            //取中间的数进行拆分
            int m = (L + R)/2;
            //分别对左右两个区间进行拆分
            mergeSort(arrays, L, m);
            mergeSort(arrays, m+1, R);

            //拆分完之后合并
            merge(arrays, L, m+1, R);
        }

    }

    /**
     * 合并数组，并实现排序
     * @param arrays
     * @param L 指向数组第一个元素
     * @param M 指向数组中间的元素
     * @param R 指向数组的最后一个元素
     */
    public static void merge(int[] arrays, int L, int M, int R){
        //左边数组的大小
        int[] leftArray = new int[M - L];
        //右边数组的大小
        int[] rightArray = new int[R - M + 1];
        //往两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }
        //对两个数组的元素进行比较之后填入原数组，实现原数组的有序排列
        int i = 0, j = 0;
        int k = L; //数组的第一个元素
        while(i < leftArray.length && j < rightArray.length){
            //在其中一个数组遍历完之前
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i++];
            }else {
                arrays[k] = rightArray[j++];
            }
            k++;
        }
        //将没遍历完的数组存入arrays
        while (i < leftArray.length) {
            arrays[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arrays[k++] = rightArray[j++];
        }

    }
    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        mergeSort(arrays, 0, arrays.length-1);
        for (int i: arrays) {
            System.out.println(i);
        }
    }
}
