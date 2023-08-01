package Seminar2.homeWork2;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] myArr = { 1, 4, 6556, 776, 77, 87, 5, 66, };
        System.out.println(Arrays.toString(myArr));
        HeapSort.sort(myArr);
        System.out.println(Arrays.toString(myArr));
    }
}
