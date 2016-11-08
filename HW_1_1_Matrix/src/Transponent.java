import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Альберт on 18.10.2016.
 */
public class Transponent {

    public static void Transp() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество строк матрицы:");
        int row = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество столбцов матрицы:");
        int colum = Integer.parseInt(reader.readLine());

        int[][] matrixA = new int[row][colum];

        for (int j = 0; j < matrixA.length; j++) {
            for (int i = 0; i < matrixA[j].length; i++) {
                System.out.println("Введите значение ячейки " + j + " " + i);
                matrixA[j][i] = Integer.parseInt(reader.readLine());
            }
            System.out.println();
        }

        int[][] cloneMatrixA = new int[matrixA[0].length][matrixA.length];

        System.out.println("Исходная матрица: ");
        System.out.println();

        for (int j = 0; j < matrixA.length; j++) {
            for (int i = 0; i < matrixA[j].length; i++) {
                System.out.print(matrixA[j][i] + " ");
                cloneMatrixA[i][j] = matrixA[j][i];
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Транспонированная матрица: ");
        // System.out.println(cloneMatrixA [0][1]);

        for (int jj = 0; jj < cloneMatrixA.length; jj++) {
            for (int ii = 0; ii < cloneMatrixA[jj].length; ii++) {
                System.out.print(cloneMatrixA[jj][ii] + " ");
            }
            System.out.println();
        }

    }
}
