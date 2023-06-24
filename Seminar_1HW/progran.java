// Вычислить n-ое треугольного число (сумма чисел от 1 до n),
// n! (произведение чисел от 1 до n)
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Введите значение n: ");
//         int n = scanner.nextInt();

//         int triangularNumber = calculateTriangularNumber(n);
//         int factorial = calculateFactorial(n);

//         System.out.println("n-ое треугольное число: " + triangularNumber);
//         System.out.println("n-ый факториал: " + factorial);
//     }

//     // Вычисление n-ого треугольного числа
//     private static int calculateTriangularNumber(int n) {
//         int sum = 0;
//         for (int i = 1; i <= n; i++) {
//             sum += i;
//         }
//         return sum;
//     }

//     // Вычисление факториала числа n
//     private static int calculateFactorial(int n) {
//         int factorial = 1;
//         for (int i = 1; i <= n; i++) {
//             factorial *= i;
//         }
//         return factorial;
//     }
// }


// Вывести все простые числа от 1 до 1000

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Простые числа от 1 до 1000:");
//         for (int i = 2; i <= 1000; i++) {
//             if (isPrime(i)) {
//                 System.out.println(i);
//             }
//         }
//     }

//     // Проверка, является ли число простым
//     private static boolean isPrime(int number) {
//         if (number <= 1) {
//             return false;
//         }
//         for (int i = 2; i <= Math.sqrt(number); i++) {
//             if (number % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


// Реализовать простой калькулятор

// import java.util.Scanner;

// public class Calculator {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Введите первое число: ");
//         double num1 = scanner.nextDouble();

//         System.out.print("Введите оператор (+, -, *, /): ");
//         char operator = scanner.next().charAt(0);

//         System.out.print("Введите второе число: ");
//         double num2 = scanner.nextDouble();

//         double result = 0.0;

//         switch (operator) {
//             case '+':
//                 result = num1 + num2;
//                 break;
//             case '-':
//                 result = num1 - num2;
//                 break;
//             case '*':
//                 result = num1 * num2;
//                 break;
//             case '/':
//                 if (num2 != 0) {
//                     result = num1 / num2;
//                 } else {
//                     System.out.println("Ошибка: деление на ноль");
//                     return;
//                 }
//                 break;
//             default:
//                 System.out.println("Ошибка: некорректный оператор");
//                 return;
//         }

//         System.out.println("Результат: " + result);
//     }
// }

// (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.


public class EquationSolver {
    public static void main(String[] args) {
        solveEquation();
    }

    private static void solveEquation() {
        for (int q = 0; q <= 9; q++) {
            for (int w = 0; w <= 9; w++) {
                for (int e = 0; e <= 9; e++) {
                    if (isValidSolution(q, w, e)) {
                        System.out.println("Решение найдено:");
                        System.out.println(q + "? + ?" + w + " = " + e);
                        return;
                    }
                }
            }
        }
        System.out.println("Решение не найдено.");
    }

    private static boolean isValidSolution(int q, int w, int e) {
        // Проверка условия q + w = e
        return (q + w == e);
    }
}