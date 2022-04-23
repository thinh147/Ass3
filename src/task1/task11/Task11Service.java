package task1.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task11Service {
    private static final Scanner sc = new Scanner(System.in);

    public int[] inputOutPutArray(int n) {
        int[] a = new int[n];
        //input array having n integer
        System.out.println(String.format("Vui lòng nhập %s phần tử của mảng: ", n));
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //output array having n integer
        System.out.println(String.format("Mảng với %s phần tử bạn vừa nhập là : ", n));
        System.out.print("[");
        for (int i = 0; i < n -1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[n-1]);
        System.out.print("]");
        System.out.println();
        return a;
    }

    //hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        //nếu n <= 1 thì không phải số nguyên tố
        if (n <= 1) return false;
        //nếu n = 2 thì n là số nguyên tố
        if (n == 2) return true;
        //duyệt từ từ 2 đến căn bậc 2 của n nếu n chia hết cho số nào đấy trong khoảng thì
        //n không phải số nguyên tố (Số nguyên tố là số chỉ chia hết cho 1 và chính nó)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        //các trường hợp còn lại là số nguyên tố
        return true;
    }

    //hàm trả về kết quả liệt kê các số nguyên tố trong mảng
    public List<Integer> listingPrimeNumber(int[] a) {
        List<Integer> listRes = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (isPrime(a[i])) listRes.add(a[i]);
        }
        return listRes;
    }

    //hàm thực thi thuật toán insertion sort
    public void insertionSort(int[] a) {
        //duyệt qua các phần tử của mảng
        for (int i = 1; i < a.length; i++) {
            //Đặt key là một phần tử của mảng (bắt đầu từ 1)
            int key = a[i];
            //gán một biến j bằng chỉ số của phần tử phía trước key
            int j = i - 1;

            // so sánh key với mỗi phần tử ở phía bên trái của nó cho tới khi gặp phần tử nhỏ hơn
            // thì thay thế với phần tử đã được tìm thấy
            // Để sắp xếp giảm dần thì đổi  key<a[j] thành key>a[j].
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j]; //gán phần tử phía sau thành phần tử trước nó
                --j; //và giảm chỉ số j đi
            }
            //Đặt lại key sau khi vừa kết thúc mỗi vòng lặp (sau khi vừa tìm thấy phần tử nhỏ hơn nó)
            a[j + 1] = key;
        }
    }

    //hàm trả về kết quả của insertion sort
    public List<Integer> insertionSortRes(int[] a){
        insertionSort(a);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            res.add(a[i]);
        }
        return res;
    }

    //hàm đổi chỗ 2 phần tử
    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    //phân đoạn mảng
    public int partition(int[] a, int l, int h){
        int pivot = a[h];    // pivot
        int left = l;
        int right = h - 1;
        while(true){
            while(left <= right && a[left] < pivot) left++; // Tìm phần tử >= a[pivot]
            while(right >= left && a[right] > pivot) right--; // Tìm phần tử <= a[pivot]
            if (left >= right) break; // Đã duyệt xong thì thoát vòng lặp
            swap(a[left], a[right]); // Nếu chưa xong, đổi chỗ.
            left++; //đã xét xong tại left hiện tại, tăng left lên để xét tiếp
            right--; //đã xét xong tại right hiện tại, giảm right đi để xét tiếp
        }
        swap(a[left], a[h]); // đổi chỗ tại chỉ số left và hight khi không tìm thấy
        return left; //trả về vị trí hiện tại dùng để chia đôi mảng
    }

    //hàm xử lý logic thuật toán quicksort
    public void quickSort(int[] arr, int l, int h)
    {
        if (l < h)
        {
        // pos là chỉ số nơi phần tử này đã đứng đúng vị trí
        // và là phần tử chia mảng làm 2 mảng con trái & phải
            int pos = partition(arr, l, h);

            // Gọi đệ quy sắp xếp 2 mảng con trái và phải
            quickSort(arr, l, pos - 1);
            quickSort(arr, pos + 1, h);
        }
    }

    //Hàm trả về kết quả
    public List<Integer> quickSortRes(int[] a){
        List<Integer> res = new ArrayList<>();
        int size = a.length;
        quickSort(a,  0, size - 1);
        for(int i = 0; i<size; i++){
            res.add(a[i]);
        }
        return res;
    }
}
