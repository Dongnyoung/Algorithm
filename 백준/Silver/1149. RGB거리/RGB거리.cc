//RGB거리에 집이 n개 1~n번 집이 순서대로 잇음
//빨 초 파 
#include <iostream>
using namespace std;
int dp[1001][3];
int main() {
	int n;
	cin >> n;
	dp[0][0] = 0;
	dp[1][0] = 0;
	dp[2][0] = 0;
	for (int i = 1; i <= n; i++) {
		cin >> dp[i][0] >> dp[i][1] >> dp[i][2];
		dp[i][0] += min(dp[i-1][1], dp[i-1][2]);
		dp[i][1] += min(dp[i-1][0], dp[i-1][2]);
		dp[i][2] += min(dp[i-1][0], dp[i-1][1]);
	}
	cout << min(min(dp[n][1], dp[n][2]), dp[n][0]) << endl;


}