import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        // 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        dp[0][0] = arr[0][0]; // 초기값

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j]; // 왼쪽 가장자리
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j]; // 오른쪽 가장자리
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j]; // 중간
                }
            }
        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n-1][j]);
        }

        System.out.println(max);
    }
}
