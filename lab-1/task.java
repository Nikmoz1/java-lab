import java.util.Scanner;

public class task{

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості чисел (n)
        System.out.print("Count (n): ");
        int n = scanner.nextInt();

        // Ініціалізація масиву для зберігання чисел
        int[] numbers = new int[n];

        // Введення чисел і заповнення масиву
        for (int i = 0; i < n; i++) {
            System.out.print("Input number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Сортування методом бульбашки по спаданню модулів
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Point.abs(numbers[j]) < Point.abs(numbers[j + 1])) {
                    // Обмін елементів
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        // Виведення відсортованого масиву
        System.out.println("Sorted numbers by decreasing modules:");
        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }
    }
}
