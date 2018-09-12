package learn;

import org.junit.Test;

import java.util.*;

/**
 * @author Create by xuantang
 * @date on 3/1/18
 */
public class Sort {


    /**
     * Bubble Sort
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int []arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }


    /**
     * Select Sort
     * @param arr
     * @return
     */
    public static int[] selectSort(int []arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    /**
     * Insert Sort
     * @param arr
     * @return
     */
    public static int[] insertSort(int []arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    @Test
    public void QuickSort() {
        count = 0;
        quickSort(new int[]{8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(count);

        count = 0;
        quickSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(count);

        count = 0;
        quickSort(new int[]{4, 6, 3, 8, 5, 2, 7, 1});
        System.out.println(count);
    }

    /**
     * Quick Sort
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr) {
        qsort(arr, 0, arr.length-1);
        return arr;
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        mSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        mSort(a, left, mid);
        mSort(a, mid + 1, right);
        merge(a, left, mid, right);

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1]) {
                tmp[tIndex++] = a[left++];
            } else {
                tmp[tIndex++] = a[r1++];
            }
        }
        // 将左边剩余的归并
        while (left <= mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while ( r1 <= right ) {
            tmp[tIndex++] = a[r1++];
        }
        //从临时数组拷贝到原数组
        while(cIndex <= right){
            a[cIndex] = tmp[cIndex];
            cIndex++;
        }
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high){
            int pivot = partition(arr, low, high);
            qsort(arr, low, pivot - 1);
            qsort(arr, pivot + 1, high);
        }
    }
    static int count = 0;
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
                count++;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
                count++;
            }
            arr[high] = arr[low];
            count++;
        }
        arr[low] = pivot;
        return low;
    }

    /**
     *
     * @param arr
     */
    public static int[] shellSort(int[] arr) {
        int j = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < arr.length; i++) {
                //System.out.println("i:" + i);
                temp = arr[i];
                for (j = i - increment; j >= 0; j -= increment) {
//                    System.out.println("j:" + j);
//                    System.out.println("temp:" + temp);
//                    System.out.println("arr[" + j + "]:" + arr[j]);
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println("");
        }
        return arr;
    }

    class NumberCount {
        int key;
        int count;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        String[] split = line.split("\\+");
//        Map<String, Integer> map = new TreeMap<>();
//        long sum = 0;
//        for (String str : split) {
//            sum += Integer.parseInt(str);
//            if (map.get(str) == null) {
//                map.put(str, 1);
//            } else {
//                int oldValue = map.get(str);
//                map.replace(str, oldValue, oldValue + 1);
//            }
//        }
//        Set<String> keySet = map.keySet();
//        Iterator<String> iterator = keySet.iterator();
//        StringBuilder sb = new StringBuilder();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            sb.append(key).append("*").append(map.get(key)).append("+");
//        }
//        System.out.println(sb.toString().substring(0, sb.toString().length()-1));
//        System.out.println(sum);

        int[] sums = twoSum(new int[]{3, 2 ,4}, 6);
        System.out.println(sums[0] + " " + sums[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
