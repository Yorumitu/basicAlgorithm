package sortingAlgorithm.Top10Sorting;

/**
 * TODO 希尔排序
 *
 *  希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
 *  是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。
 *  是插入排序的高级版
 *
 * 直观上看希尔排序：
 *  就是把数列进行分组(不停使用插入排序)，直至从宏观上看起来有序，最后插入排序起来就容易了(无须多次移位或交换)。
 *  从专业的角度上讲，将一个序列分成好几个序列，用一个数来表示：那个数称为增量。显然的是，增量是不断递减的(直到增量为1)
 *
 *  希尔排序代码其实非常简单(相比对堆排序)，理解起来也不难，就用增量来将数组进行分隔，直到增量为1。底层干的还是插入排序干的活～
 */
public class ShellSort {
    public static void shellSort() {

    }
    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        shellSort();
        for (int i: arrays) {
            System.out.println(i);
        }
    }
}
