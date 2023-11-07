import java.util.Scanner;

public class month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число від 1 до 12: ");
        
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number >= 1 && number <= 12) {
                String[] months = {
                    "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень",
                    "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"
                };
                String monthName = months[number - 1];
                System.out.println("Місяць: " + monthName);
            } else {
                System.out.println("Введене число повинно бути від 1 до 12.");
            }
        } else {
            System.out.println("Введене значення не є цілим числом.");
        }
    }
}