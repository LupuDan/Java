// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// import org.json.JSONObject;

// public class Main {
//     public static void main(String[] args) {
//         String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
//         JSONObject filters = new JSONObject(jsonString);

//         StringBuilder whereClause = new StringBuilder();
//         boolean isFirstFilter = true;

//         for (String key : filters.keySet()) {
//             String value = filters.getString(key);
//             if (!value.equals("null")) {
//                 if (!isFirstFilter) {
//                     whereClause.append(" AND ");
//                 }

//                 whereClause.append(key).append(" = '").append(value).append("'");
//                 isFirstFilter = false;
//             }
//         }

//         String sqlQuery = "SELECT * FROM students WHERE " + whereClause.toString();
//         System.out.println(sqlQuery);
//     }
// }


// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

// import java.io.FileWriter;
// import java.io.IOException;

// public class BubbleSort {
//     public static void main(String[] args) {
//         int[] array = {5, 2, 8, 12, 1};
//         bubbleSort(array);
//     }

//     public static void bubbleSort(int[] array) {
//         int n = array.length;
//         boolean swapped;
//         String logFilePath = "bubble_sort_log.txt";

//         try (FileWriter writer = new FileWriter(logFilePath)) {
//             for (int i = 0; i < n - 1; i++) {
//                 swapped = false;

//                 for (int j = 0; j < n - i - 1; j++) {
//                     if (array[j] > array[j + 1]) {
//                         int temp = array[j];
//                         array[j] = array[j + 1];
//                         array[j + 1] = temp;
//                         swapped = true;
//                     }
//                 }

//                 // Записываем текущее состояние массива в лог-файл
//                 writer.write("Iteration " + (i + 1) + ": ");
//                 for (int num : array) {
//                     writer.write(num + " ");
//                 }
//                 writer.write(System.lineSeparator());

//                 // Если на текущей итерации не было обменов, то массив уже отсортирован
//                 if (!swapped) {
//                     break;
//                 }
//             }

//             // Записываем окончательный отсортированный массив в лог-файл
//             writer.write("Final sorted array: ");
//             for (int num : array) {
//                 writer.write(num + " ");
//             }
//             writer.write(System.lineSeparator());

//             System.out.println("Sorting completed. Results are saved in the log file: " + logFilePath);
//         } catch (IOException e) {
//             System.out.println("An error occurred while writing to the log file: " + e.getMessage());
//         }
//     }
// }


// 3) Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// import org.json.JSONArray;
// import org.json.JSONException;
// import org.json.JSONObject;

// public class JSONParser {
//     public static void main(String[] args) {
//         String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

//         try {
//             JSONArray jsonArray = new JSONArray(jsonString);
//             StringBuilder result = new StringBuilder();

//             for (int i = 0; i < jsonArray.length(); i++) {
//                 JSONObject jsonObject = jsonArray.getJSONObject(i);
//                 String фамилия = jsonObject.getString("фамилия");
//                 String оценка = jsonObject.getString("оценка");
//                 String предмет = jsonObject.getString("предмет");

//                 result.append("Студент ").append(фамилия).append(" получил ").append(оценка).append(" по предмету ").append(предмет).append(".\n");
//             }

//             System.out.println(result.toString());
//         } catch (JSONException e) {
//             System.out.println("Ошибка при парсинге JSON: " + e.getMessage());
//         }
//     }
// }


// 4) К калькулятору из предыдущего ДЗ добавить логирование.

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Введите первое число: ");
        double num1 = scanner.nextDouble();

        logger.info("Введите оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        logger.info("Введите второе число: ");
        double num2 = scanner.nextDouble();

        double result = 0.0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    logger.error("Ошибка: деление на ноль");
                    return;
                }
                break;
            default:
                logger.error("Ошибка: некорректный оператор");
                return;
        }

        logger.info("Результат: " + result);
    }
}
