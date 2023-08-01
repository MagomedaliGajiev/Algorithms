package Seminar1;

public class Task4 {
    // 1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
    // 2. Считаем, что 1 и 2 значения последовательности равны 1.
    // 3. Искать будем по формуле On=On-1+On-2 что предполагает использовать
    // рекурсивного алгоритма.

    public static void main(String[] args) {
        System.out.println(fb(6));// 1 1 2 3 5 8
    }

    public static int fb(int num) {
        if (num <= 2) {
            return 1;
        } else {
            return fb(num - 1) + fb(num - 2);
        }
    }
}
