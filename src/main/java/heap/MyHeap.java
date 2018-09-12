package heap;

import java.util.PriorityQueue;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class MyHeap {

    int arr[] = new int[]{1, 2, 3, 34, 5, 6};
    int postion;

    public void siftUp(int position) {
        int father = position >> 1;
        int child = position;
        int tmp = arr[position];
        while (father >= 0 && child > 1) {
            if (arr[father] > tmp) {
                arr[child] = arr[father];
                child = father;
                father = child >> 1;
            } else {
                break;
            }
        }
        arr[child] = tmp;

    }
}
