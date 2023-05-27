import java.util.*;

public class MatrixAddition {
    public static void main(String[] args) {
        // Useful Object
        Scanner scan = new Scanner(System.in);

        // Declare the variable
        int[][] matrix1, matrix2, result;
        matrix1 = new int[1001][1001];
        matrix2 = new int[1001][1001];
        result = new int[1001][1001];
        int n, m;

        // Input two mattrices
        System.out.println("Enter the size of the matrix: ");
        n = scan.nextInt();
        m = scan.nextInt();

        // Input the first matrix
        System.out.println("Enter the matrix one");
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                matrix1[i][j] = scan.nextInt();

        // Input the second matrix
        System.out.println("Enter the matrix one");
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                matrix2[i][j] = scan.nextInt();

        // Calculating
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                result[i][j] = matrix1[i][j] + matrix2[i][j];

        // Print the result
        System.out.println("The added matrix is: ");
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j)
                System.out.print(String.valueOf(result[i][j]) + " ");
            System.out.println();
        }

        scan.close();
        System.exit(0);
    }
}
