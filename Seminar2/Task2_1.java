package Seminar2;

// 1.
// Необходимо написать один из простых алгоритмов сортировки,
// имеющий сложность O(n 2 ).
// 2.
// Можно выбрать из пузырьковой сортировки, сортировки вставками и
// сортировки выбором.
// 3.
// Следует обратить внимание на сложность данных алгоритмов и
// указать признаки квадратичной сложности для каждого из них.
public class Task2_1 {
    public static void bubbleSort(int[] array) {
        boolean flag = false; // false - не было обменов, true - был хотя бы 1 обмен

        // на какое место будем ставим наибольший элемент
        for (int i = array.length - 1; i > 0; i--) {
            // проходим по не отсортированной последовательности
            for (int j = 0; j < i; j++) {
                // если порядок элементов неправильный
                if (array[j] > array[j + 1]) {
                    // меняем местами пары
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true; // меняем флажок
                }
            }
            // если значение флага не поменялось
            if (!flag) {
                return; // массив отсортирован. Выходим с функции
            }
        }
    }

    public static void main(String[] args) {
        int[] myArr = { 1, 4, 6556, 776, 77, 87, 5, 66, };
        for (int i : myArr) {
            System.out.print(i + " ");
        }
        bubbleSort(myArr);
        System.out.println();
        for (int i : myArr) {
            System.out.print(i + " ");
        }
    }
}
