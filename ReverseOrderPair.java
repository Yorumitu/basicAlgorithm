import java.util.ArrayList;
import java.util.Scanner;

/**
 * 归并算法
 *
 * 最近，TOM 老猫查阅到一个人类称之为“逆序对”的东西，这东西是这样定义的：
 * 对于给定的一段正整数序列，逆序对就是序列中 a_i>a_j且 i<j 的有序对。
 * 知道这概念后，他们就比赛谁先算出给定的一段正整数序列中逆序对的数目。注意序列中可能有重复数字。
 * Update:数据已加强。
 *  输入格式
 * 第一行，一个数 n，表示序列中有 n个数。
 * 第二行 n 个数，表示给定的序列。序列中每个数字不超过 10^9。
 *
 * 输出格式
 * 输出序列中逆序对的数目。
 *
 *
 * 输入
 * 6
 * 5 4 2 6 3 1
 *
 * 输出
 * 11
 *
 * 说明/提示
 * 对于 25% 的数据，n <= 2500
 * 对于 50% 的数据，n <= 4*10^4。
 * 对于所有数据，n <= 5*10^5
 *
 * 请使用较快的输入输出
 */

public class ReverseOrderPair {
    static long sum = 0;
    static int maxSize = 1000000;
    static int[] leftArray = new int[maxSize];
    static int[] rightArray = new int[maxSize]; //存放左右区间子数组
    static int[] arrays = new int[maxSize];

    public static void mergeSort(int[] arrays, int left, int right){
        if (arrays.length == 0) {
            return;
        } else {
            int mid = (left + right)/2;
            //拆分
            mergeSort(arrays, left, mid);
            mergeSort(arrays, mid + 1, right);

            //合并
            merge(arrays, left, mid+1, right);
        }
    }
    public static void merge(int[] array, int left, int mid, int right){
        for (int i = left; i < mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArray[i - mid] = array[i];
        }

        //比较两个数组的元素，填入原数组，实现原数组的有序排列
        int i = 0, j = 0;
        int k = left;//数组的第一个元素
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]){
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
                /**
                 * 如果左区间的i位置元素比右区间j位置元素大
                 * 说明左区间i ~ mid的元素都比j位置元素大
                 * 即逆序
                 * 累加mid - i + 1
                 */
                sum += mid - i + 1;
            }
            k++;
        }
        //将没遍历完的数组存入arrays
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }
        mergeSort(arrays, 0, n);
    }
}
