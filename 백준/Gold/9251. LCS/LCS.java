import java.util.*;

class Main {
    private static int dp[][] = new int[1001][1001];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        String m = scan.nextLine();
        for (int i = 1; i < n.length()+1; i++) {
            for (int j = 1; j < m.length()+1; j++) {
                
                    // 같으면 왼쪽위 +1
                    if (n.charAt(i-1) == m.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    // 다르면 왼쪽,위쪽중 max
                    else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
        }
        System.out.println(dp[n.length()][m.length()]);
        scan.close();
        }
        

}
