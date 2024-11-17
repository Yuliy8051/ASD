import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(7, 6, 10, 5, 9, 2, 1, 15, 7);
        list = new ArrayList<>(list);
        quickSort(list, 0, list.size() - 1);
        System.out.println(list);
    }

    public static void quickSort(List<Integer> list, int l, int r){
        if (l < r){
            int q = partition(list, l, r);
            quickSort(list, l, q - 1);
            quickSort(list, q + 1, r);
        }
    }
    public static int partition(List<Integer> list, int l, int r){
        Integer pivot = list.get(r);
        for (int i = l; i < r; i++) {
            if (list.get(i) <= pivot){
                Collections.swap(list, l, i);
                l++;
            }
        }
        Collections.swap(list, r, l);
        return l;
    }
}