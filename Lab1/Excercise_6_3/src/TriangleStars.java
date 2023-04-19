import java.util.*;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number n: ");
        int n = scan.nextInt();

        int maxStars = (n % 2 == 0) ? ((n - 1) * 2 + n % 2 + 1) : ((n - 1) * 2 + 1);
   

        for (int i = 1; i < n; ++i) {
            int numStars = (i % 2 == 0) ? ((i - 1) * 2 + i % 2 + 1) : ((i - 1) * 2 + 1);
            int numSpaces = (maxStars - numStars) / 2;
            System.out.println(" ".repeat(numSpaces) + "*".repeat(numStars) + " ".repeat(numSpaces));
        }
        System.out.println("*".repeat(maxStars));
        scan.close();
    }
}