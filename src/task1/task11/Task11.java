package task1.task11;

import java.util.List;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task11Service task11Service = new Task11Service();
        System.out.println("-------------Task 1.1 a ----------");
        System.out.println("Nhập N: ");
        int n = sc.nextInt();
        int[] a = task11Service.inputOutPutArray(n);
        System.out.println();

        while (true) {
            System.out.println("Task 1.1");
            System.out.println("Chọn 1->3 để chọn chức năng, chọn 0 để thoát ");
            System.out.println("1. In ra các số nguyên tố trong mảng vừa nhập.");
            System.out.println("2. Sắp xếp mảng bằng thuật toán Insertion Sort.");
            System.out.println("3. Sắp xếp mảng bằng thuật toán Quick Sort. ");

            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("-------------Task 1.1 b ----------");
                    List<Integer> listPrime = task11Service.listingPrimeNumber(a);
                    System.out.println("Các số nguyên tố trong chuỗi vừa nhập là: ");
                    System.out.println(listPrime.toString());
                    break;
                case 2:
                    System.out.println("-------------Task 1.1 c ----------");
                    List<Integer> listInsertionSort = task11Service.insertionSortRes(a);
                    System.out.println("Mảng đã được sắp xếp theo thuật toán insertion sort là: ");
                    System.out.println(listInsertionSort.toString());
                    break;
                case 3:
                    System.out.println("-------------Task 1.1 d ----------");
                    List<Integer> listQuickSort = task11Service.quickSortRes(a);
                    System.out.println("Mảng đã được sắp xếp theo thuật toán quick sort là: ");
                    System.out.println(listQuickSort.toString());
                    break;
                default:
                    System.out.println("Nhập sai, vui lòng nhập lại!!");
                    break;
            }
        }
    }
}