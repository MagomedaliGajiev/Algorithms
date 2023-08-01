package Seminar1;

public class Task1 {
    // Необходимо написать алгоритм, считающий сумму всех чисел
    // от 1 до N. Согласно свойствам линейной сложности,
    // количество итераций цикла будет линейно изменяться
    // относительно изменения размера N.

    public static void main(String[] args) {
        
        
        
    }

    public static int sum(int num) {
            int sum = 0;

            for (int i = 1; i < num; i++) {
                sum += i;
            }
            return sum;
        }
}
