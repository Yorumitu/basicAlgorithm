package sortingAlgorithm.Top10Sorting;


/**
 * 冒泡排序
 * 算法描述：
 *  1. i从0开始，i与i+1比较，如果i>i+1，那么就互换
 *  2. i不断增加，直到i<n-1（n是数组元素的个数，n-1是数组已经最后一个元素） ，一趟下来，可以让数组元素中最大值排在数组的最后面
 *
 * 优化：设定一个标记位记录是否发生了置换，如果在遍历过程中未发生置换，说明已经有序了，此时直接退出即可
 */
public class BubbleSort {
    public static void bubbleSort(int[] arrays) {
        //装载临时变量
        int temp;

        //记录是否发生了置换， 0 表示没有发生置换、 1 表示发生了置换
        int isChange;

        //外层循环是排序的趟数
        for (int i = 0; i < arrays.length - 1; i++) {

            //每比较一趟就重新初始化为0
            isChange = 0;

            //内层循环是当前趟数需要比较的次数
            for (int j = 0; j < arrays.length - i - 1; j++) {

                //前一位与后一位与前一位比较，如果前一位比后一位要大，那么交换
                if (arrays[j] > arrays[j + 1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;

                    //如果进到这里面了，说明发生置换了
                    isChange = 1;

                }
            }
            //如果比较完一趟没有发生置换，那么说明已经排好序了，不需要再执行下去了
            if (isChange == 0) {
                break;
            }
        }
        for (int i: arrays) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 5, 1, 3, 4};
        bubbleSort(arrays);
    }
}
