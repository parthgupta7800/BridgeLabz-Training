import java.util.Scanner;

public class ArrayIndex {
    static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }
    static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = sc.next();
        }
        handleException(names);
    }
}
