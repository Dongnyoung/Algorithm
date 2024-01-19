#include <iostream>
// 첫번째 두번째 1로 고정
using namespace std;
int main() {
  long long dp[81];
  int n;
  cin >> n;
  dp[1] = 1;
  dp[2] = 1;
  for (int i = 3; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  long long result = dp[n] * 2 + (dp[n] + dp[n - 1]) * 2;
  cout << result << endl;
  return 0;
}