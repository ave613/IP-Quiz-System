import java.util.ArrayList;
import java.util.List;
public class MergeSortDescending {
    public static void mergeSort(List<StudentResult> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
             // Split the list into two halves
            List<StudentResult> left = new ArrayList<>(list.subList(0, mid));
            List<StudentResult> right = new ArrayList<>(list.subList(mid, list.size()));
            // Recursively sort both halves
            mergeSort(left);
            mergeSort(right);
            merge(left, right, list);
        }
    }
    private static void merge(List<StudentResult> left, List<StudentResult> right, List<StudentResult> list) {
        int i = 0, j = 0, k = 0;
   // Merge the two arrays into list in descending order
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMarks() >= right.get(j).getMarks()) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }
        // Copy the remaining elements from left, if any
        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        // Copy the remaining elements from right, if any
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
