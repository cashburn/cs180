public class Matrix {
    int[][] matrix;
    Matrix(int[][] matrix) { this.matrix = matrix; }
    
    int sum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}