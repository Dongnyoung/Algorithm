import java.util.*;

class Main {
    private static int dp[][] = new int[201][201];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        
        //j개로 0을 만들수있는 경우의수 모두 1로 초기화
        for(int j=0;j<201;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<201;i++){
            for(int j=0;j<201;j++){
                if(j==0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
                }
            }
        }
        System.out.println(dp[n][k]);
        
    }
}