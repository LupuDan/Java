import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        int factorial = calculateFactorial(n);

        System.out.println("n-ое треугольное число: " + triangularNumber);
        System.out.println("n-ый факториал: " + factorial);
    }

    // Вычисление n-ого треугольного числа
    private static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Вычисление факториала числа n
    private static int calculateFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}