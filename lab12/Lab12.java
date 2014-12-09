import java.io.*;
public class Lab12 {
    public static int power(int a, int b) {
        if (b == 0)
            return 1;
        return a * power(a, (b-1));
    }
    
    public static int fileCount(File rootDir) {
        int n = 0;
        if (!rootDir.isDirectory())
            return 1;
        else {
            n++;
            File[] listFiles = rootDir.listFiles();
            for (File i : listFiles) 
                n += fileCount(i);
        }
        return n;
    }
    
    public static void hanoi(int n, char src, char dest, char aux) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.printf("move %d from %c to %c \n", n, src, dest);
            return;
        }
        hanoi(n - 1, src, aux, dest);
        System.out.printf("move %d from %c to %c \n", n, src, dest);
        hanoi(n - 1, aux, dest, src);
    }
    
    public static int mysterySeries(int i, int j) {
        if ((i < 0) || (j < 0) || (i < j))
            return 0;
        if ((j == 0) || (i == j))
            return 1;
        return mysterySeries(i - 1, j - 1) + mysterySeries(i - 1, j);
    }
}