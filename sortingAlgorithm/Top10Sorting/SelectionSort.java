package sortingAlgorithm.Top10Sorting;


/**
 * 选择排序
 * 每一次从待排序的数据元素中选出最小(或最大)的一个元素，存放在序列的起始(末尾)位置，直到全部待排序的数据元素排完。
 *      两层循环，第一层是对数组的遍历，第二层是找出最大值（由于每一趟都会将最大值放最后，因此每次遍历到length-i处就行了）
 *      将最大值跟最后（length-1-i）的值进行交换
 *
 *
 * 排序的稳定性：
 *  判断某排序算法是否稳定，我们可以简单理解成：排序前2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序相同
 *      如果相同，则是稳定的排序方法。
 *      如果不相同，则是不稳定的排序方法
 *  如果排序前的数组是[3,3,1]，假定我们使用选择排序的话，那第一趟排序后结果就是[1,3,3]。
 *  这个数组有两个相同的值，它俩在array[0]和array[1]，结果经过排序，array[0]的跑到了array[2]上了。
 * 那么这就导致：2个相等的数其在序列的前后位置顺序和排序后它们两个的前后位置顺序不相同，因此，我们就说它是不稳定的
 *
 * 为什么要稳定：排序的元素往往不只有一个属性，例如我们对一群人按年龄排序，但是人除了年龄属性还有身高体重属性，
 * 在年龄相同时如果不想破坏原先身高体重的次序，就必须用稳定排序算法.
 * 很清晰的指出，只有当在“二次”排序时不想破坏原先次序，稳定性才有意义
 */
public class SelectionSort {
    public static void selectionSort(int[] arrays) {
        //记录当前趟数的最大值的角标
        int pos ;

        //交换的变量
        int temp;

        //外层循环控制需要排序的趟数
        for (int i = 0; i < arrays.length - 1; i++) {
            //新的趟数、将角标重新赋值为0
            pos = 0;

            //内层循环控制遍历数组的个数并得到最大数的角标
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[pos]) {
                    pos = j;
                }
            }
            //交换
            temp = arrays[pos];
            arrays[pos] = arrays[arrays.length - 1 - i];
            arrays[arrays.length - 1 - i] = temp;
        }
        for (int i: arrays) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 3, 5, 1, 6, 1, 2, 3, 7, 2, 3};
        selectionSort(arrays);
    }
}
