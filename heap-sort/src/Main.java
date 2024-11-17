import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(
                1,14,10,8,7,9,3,2,4
        );
        List<Integer> integerList = new ArrayList<>(integers);
        heapSort(integerList);
        System.out.println(integerList);
    }

    public static void heapSort(List<Integer> integerList){
        buildMaxHeap(integerList);
        int heapSize = integerList.size();
        for (int i = heapSize - 1; i > 0; i--) {
            Collections.swap(integerList, 0, i);
            heapSize--;
            maxHeapify(integerList, 0, heapSize);
        }
    }

    public static void buildMaxHeap(List<Integer> integerList){
        int heapSize = integerList.size();
        for (int i = (heapSize - 1) / 2; i >= 0; i--)
            maxHeapify(integerList, i, heapSize);
    }

    public static void maxHeapify(List<Integer> integerList, int index, int heapSize){
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        int largest;
        if (l < heapSize && integerList.get(index) < integerList.get(l))
            largest = l;
        else
            largest = index;
        if (r < heapSize && integerList.get(largest) < integerList.get(r))
            largest = r;
        if (index != largest){
            Collections.swap(integerList, largest, index);
            maxHeapify(integerList, largest, heapSize);
        }
    }
}