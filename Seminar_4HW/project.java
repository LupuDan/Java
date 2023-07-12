import java.util.Deque;
import java.util.LinkedList;

public class project {
    public static LinkedList<Integer> multiplyNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        for (int digit1 : num1) {
            int tempCarry = 0;
            LinkedList<Integer> partialProduct = new LinkedList<>();

            for (int digit2 : num2) {
                int product = (digit1 * digit2) + tempCarry;
                tempCarry = product / 10;
                partialProduct.add(product % 10);
            }

            if (tempCarry > 0) {
                partialProduct.add(tempCarry);
            }

            for (int i = 0; i < carry; i++) {
                partialProduct.addFirst(0);
            }

            result = addNumbers(result, partialProduct);
            carry++;
        }

        return result;
    }

    public static LinkedList<Integer> addNumbers(Deque<Integer> num1, Deque<Integer> num2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }

        if (carry > 0) {
            result.add(carry);
        }

        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> num1 = new LinkedList<>();
        Deque<Integer> num2 = new LinkedList<>();

        // Заполните num1 и num2 соответствующими цифрами в обратном порядке

        LinkedList<Integer> product = multiplyNumbers(num1, num2);
        LinkedList<Integer> sum = addNumbers(num1, num2);

        System.out.println("Произведение: " + product);
        System.out.println("Сумма: " + sum);
    }
}