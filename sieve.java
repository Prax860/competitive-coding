import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
