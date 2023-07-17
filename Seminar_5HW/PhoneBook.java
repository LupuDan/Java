// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "5555555555");
        addContact(phoneBook, "Иванов", "1111111111");
        addContact(phoneBook, "Петров", "2222222222");

        List<String> sortedNames = getSortedNames(phoneBook);

        for (String name : sortedNames) {
            System.out.println(name + ": " + phoneBook.get(name));
        }
    }

    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static List<String> getSortedNames(Map<String, List<String>> phoneBook) {
        List<String> names = new ArrayList<>(phoneBook.keySet());

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                int phoneCount1 = phoneBook.get(name1).size();
                int phoneCount2 = phoneBook.get(name2).size();
                return phoneCount2 - phoneCount1;
            }
        });

        return names;
    }
}