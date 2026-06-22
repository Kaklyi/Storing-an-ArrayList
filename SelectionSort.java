import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {

    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comp) {

        int n = list.size();

        for (int current = 0; current < n - 1; current++) {

            int smallest = current; // track smallest

            for (int next = current + 1; next < n; next++) {

                // compare items
                if (comp.compare(list.get(next), list.get(smallest)) < 0) {
                    smallest = next;
                }
            }

            // swap if needed
            if (smallest != current) {
                Student temp = list.get(current);
                list.set(current, list.get(smallest));
                list.set(smallest, temp);
            }
        }
    }
}
