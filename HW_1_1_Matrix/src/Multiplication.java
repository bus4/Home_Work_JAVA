import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Альберт on 18.10.2016.
 */
public class Multiplication {

    public static void Multi() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество строк первой матрицы:");
        int row = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество столбцов первой матрицы:");
        int colum = Integer.parseInt(reader.readLine());

        int[][] matrixA = new int[row][colum];

        for (int j = 0; j < matrixA.length; j++) {
            for (int i = 0; i < matrixA[j].length; i++) {
                System.out.println("Введите значение ячейки " + j + " " + i);
                matrixA[j][i] = Integer.parseInt(reader.readLine());
            }
            System.out.println();
        }

        System.out.println("ВНИМАНИЕ! Число строк во второй матрице равно количеству столбцов первой матрицы");
        int row2 = colum;
        System.out.println("Введите количество столбцов второй матрицы:");
        int colum2 = Integer.parseInt(reader.readLine());

        int[][] matrixB = new int[row2][colum2];

        for (int j = 0; j < matrixB.length; j++) {
            for (int i = 0; i < matrixB[j].length; i++) {
                System.out.println("Введите значение ячейки " + j + " " + i);
                matrixB[j][i] = Integer.parseInt(reader.readLine());
            }
            System.out.println();
        }


        System.out.println("Исходная матрица A: ");
        System.out.println();

        for (int j = 0; j < matrixA.length; j++) {
            for (int i = 0; i < matrixA[j].length; i++) {
                System.out.print(matrixA[j][i] + " ");
                //           cloneMatrixA [i][j] = matrixA [j][i];
            }
            System.out.println();
        }

        System.out.println("Исходная матрица B: ");
        System.out.println();

        for (int j = 0; j < matrixB.length; j++) {
            for (int i = 0; i < matrixB[j].length; i++) {
                System.out.print(matrixB[j][i] + " ");
                //           cloneMatrixA [i][j] = matrixA [j][i];
            }
            System.out.println();
        }

        int m = row;
        int n = colum;
        int k = colum2;
        int[][] cloneMatrixA = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrixB[j][i] + " ");
                int r = 0;
                for (int q = 0; q < n; q++) {
                    r = r + matrixA[i][q] * matrixB[q][j];
                }
                cloneMatrixA[i][j] = r;
            }
        }


        System.out.println();
        System.out.println("Результат умножения: ");
        // System.out.println(cloneMatrixA [0][1]);


        for (int jj = 0; jj < cloneMatrixA.length; jj++) {
            for (int ii = 0; ii < cloneMatrixA[jj].length; ii++) {
                System.out.print(cloneMatrixA[jj][ii] + " ");
            }
            System.out.println();
        }

    }
}
