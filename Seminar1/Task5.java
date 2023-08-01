package Seminar1;

public class Task5 {
    // 1.Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот
    // раз
    // откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
    // линейную сложность, т.к. вычисление каждого из чисел последовательности будет
    // происходить ровно 1 раз.

    // 2.Вариантов решения может быть несколько, но нужно предложить студентам
    // считать
    // последовательность с первого числа и далее до тех пор, пока не доберемся до
    // нужного номера. При этом значение предыдущих элементов нужно сохранять, чтобы
    // не приходилось вычислять заново, как это происходило при рекурсивном методе.

    public static void main(String[] args) {
        System.out.println(fb(6));// 1 1 2 3 5 8
    }

    public static int fb(int num) {
        if (num <= 2) {
            return 1;
        } else {
            final int[] numbers = new int[num];
            numbers[0] = 1;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[num - 1];
        }
    }
}
