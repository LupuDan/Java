// Задание

// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(3);
        numbers.add(8);
        numbers.add(1);

        // 1) Удаление чётных чисел
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }

        // 2) Поиск минимального значения
        int min = oddNumbers.get(0);
        for (int number : oddNumbers) {
            if (number < min) {
                min = number;
            }
        }

        // 3) Поиск максимального значения
        int max = oddNumbers.get(0);
        for (int number : oddNumbers) {
            if (number > max) {
                max = number;
            }
        }

        // 4) Вычисление среднего значения
        int sum = 0;
        for (int number : oddNumbers) {
            sum += number;
        }
        double average = (double) sum / oddNumbers.size();

        System.out.println("Исходный список чисел: " + numbers);
        System.out.println("Список чисел после удаления чётных чисел: " + oddNumbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}