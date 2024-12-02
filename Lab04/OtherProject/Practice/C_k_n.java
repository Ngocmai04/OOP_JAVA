package Lab04.OtherProject.Practice;
import java.util.*;
public class C_k_n {
    public static int combine(int n, int k) {
        if (k > n) {
            return 0;
        } else if (k == 0 || k == n) {
            return 1;
        } else {
            return combine(n - 1, k) + combine(n - 1, k - 1);
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int result = combine(n, k);
            System.out.println(result);
        }
    }

   
}
