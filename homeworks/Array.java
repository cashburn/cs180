public class Array {
    int[] array;
    Array(int[] array) {
        this.array = array;
    
    }

    int sum() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    double average() {
        return (double) sum() / array.length;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        Array array = new Array(a);
        System.out.println(array.sum() + array.average());
    }
}