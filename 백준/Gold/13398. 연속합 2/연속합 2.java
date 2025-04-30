import java.util.*;

class Main {
    private static int dp[] = new int[100001];
    private static int dp_del[] = new int[100001];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt(); // 무게받기
        }
        /*
        //확인용
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        */
        dp_del[0] = -1000000000; // 가장 작은값으로 초기화
        dp[0] = arr[0];
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            dp_del[i] = Math.max(dp_del[i - 1] + arr[i], dp[i - 1]);
            answer = Math.max(answer, Math.max(dp[i], dp_del[i]));
        }
        
        System.out.println(answer);

    }
}