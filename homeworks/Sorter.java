import java.util.Arrays;
public class Sorter {
    static double[] sortArray(double[] input) {
        double[] sortArray = Arrays.copyOf(input, input.length);
        Arrays.sort(sortArray);
        return sortArray;
    }
}