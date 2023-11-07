import java.util.Scanner;

public class palindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел (n): ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введіть числа:");

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int firstPalindrome = -1; // Перше знайдене число-паліндром
        int secondPalindrome = -1; // Друге знайдене число-паліндром

        for (int number : numbers) {
            if (isPalindrome(number)) {
                if (firstPalindrome == -1) {
                    firstPalindrome = number;
                } else {
                    secondPalindrome = number;
                    break; // Знайдено два числа-паліндрома, виходимо з циклу
                }
            }
        }

        if (firstPalindrome != -1) {
            System.out.println("Перше число-паліндром: " + firstPalindrome);
            if (secondPalindrome != -1) {
                System.out.println("Друге число-паліндром: " + secondPalindrome);
            } else {
                System.out.println("Другого числа-паліндрома не знайдено.");
            }
        } else {
            System.out.println("Чисел-паліндромів не знайдено.");
        }
    }

    // Функція для перевірки, чи число є паліндромом
    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;

        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }

        return originalNumber == reverse;
    }
}
