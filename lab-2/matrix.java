import java.util.Random;
import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність матриці n: ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                int[][] matrix = generateRandomMatrix(n);
                printMatrix(matrix);

                double norm = calculateMatrixNorm(matrix);
                System.out.println("Норма матриці: " + norm);
            } else {
                System.out.println("Розмірність матриці повинна бути більше 0.");
            }
        } else {
            System.out.println("Невірний формат введення.");
        }
    }

    // Генерація матриці з випадковими значеннями
    public static int[][] generateRandomMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        return matrix;
    }

    // Виведення матриці на консоль
    public static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Обчислення норми матриці
    public static double calculateMatrixNorm(int[][] matrix) {
        int n = matrix.length;
        double norm = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                norm += Point.abs(matrix[i][j]);
            }
        }

        return norm;
    }
}
