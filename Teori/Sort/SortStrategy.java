package Sort;

import java.util.List;

public interface SortStrategy {
    void sort(List<Double> data);

    String getName();
}
