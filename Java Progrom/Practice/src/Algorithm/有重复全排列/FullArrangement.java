package Algorithm.有重复全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列（去除重复排序数组的全排序）：——全排列的java实现（无重复元素）
 * 需要去除重复的元素；既然元素值是重复的，那么我们可以将问题简化，将问题分解成去除数组中重复元素和全排列数组两部分；
 */
public class FullArrangement {
    private static List<String> list = new ArrayList<>();

    public static void doFullArrangement(String[] array) {
        /*
         * 清空list，因为此list是静态的，因此每次排序时都需要清空，否则的话若重复调用排序的方法的话将不会去除重复的排序
         */
        list.removeAll(list);
        getAllOrder(array, 0, array.length);
    }

    /**
     * @param start 从start开始，到end结束来全排列数组
     * @param end
     */
    private static void getAllOrder(Object[] array, int start, int end) {
        if (start == end) {
            //将数组转换成字符串，通过判断list中是否包含该字符串（数组的字符串形式）来判断该数组有没有被输出过，从而
            //去除重复的数组排序。
            String arrayStr = Arrays.toString(array);
            if (!list.contains(arrayStr)) {
                list.add(arrayStr);
            } else {
                System.out.println(arrayStr);
            }
            return;
            //System.out.println(Arrays.toString(array));//使用Arrays工具类遍历输出数组元素
        } else {
            for (int i = start; i < end; i++) {
                swap(array, start, i);
                getAllOrder(array, start + 1, end);
                swap(array, i, start);
            }
        }
    }

    //数组中的两个元素交换位置
    private static void swap(Object[] array, int i, int j) {
        if (i == j) {
            return;
        }
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
