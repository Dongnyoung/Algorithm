#include <iostream>
#include <vector>
using namespace std;
#define d 1000000000
//계단수,,
//n은 길이
//전체적으로는 a[i][j] (길이가i인 j로 끝나는수?) == a[i-1][j-1] + a[i-1][j+1]
//0과 9로 끝날때는 각각 1과 8이 앞에와야한다 따라서  j+1, j-1일때이다
int n;
int dp[101][10];
int main() {
	cin >> n;
	for (int i = 1; i <= 9; i++) {
		dp[1][i] = 1;
	}
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) 
				dp[i][0] = dp[i - 1][j + 1];
			
			else if (j == 9) 
				dp[i][9] = dp[i - 1][j - 1];
			
			else
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
			dp[i][j] %= d;
		}
	}
	int result = 0;
	for (int i = 0; i < 10; i++) {
		result = (result + dp[n][i]) % d;
	}
	cout << result << endl;
	return 0;
}