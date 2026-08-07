import java.util.Scanner;

public class acp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of matrix: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean found = false;

        for (int i = 0; i < n; i++) {

            // Find minimum element in the row
            int minCol = 0;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] < arr[i][minCol]) {
                    minCol = j;
                }
            }

            // Check if it is maximum in its column
            boolean saddle = true;
            for (int k = 0; k < n; k++) {
                if (arr[k][minCol] > arr[i][minCol]) {
                    saddle = false;
                    break;
                }
            }

            if (saddle) {
                System.out.println("Saddle Price = " + arr[i][minCol]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}