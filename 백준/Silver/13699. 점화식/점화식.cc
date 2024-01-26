#include <iostream>
using namespace std;
//점화식
//문제를 보니 k-1*i-k 인듯하다
long long dp[36];
int main(){
    int n;
    cin >> n;
    dp[0]=1;
    for (int i = 1; i <= n; i++)
        for (int k = 1; k <= i; k++)
            dp[i] += dp[k - 1] * dp[i - k];
     
        cout << dp[n] << endl;
     
        return 0;
    }
