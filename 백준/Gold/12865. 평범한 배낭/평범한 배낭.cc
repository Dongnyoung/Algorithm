//n개의 물건, 무게w와 가치v
//v만큼 즐길수잇음 
//최대 k만큼의 무게만을 넣을수있음
//최댓값.. k에 근사치만큼의 값을구해야할듯 


//입력 물품의 수 n, 무게k
//w무게 와 가치 v
// 문제를 물건을 넣을때와 안넣을때로 작게 쪼갤수있다.
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int dp[101][100001];
int w[101];
int v[101];
int n, k;

int main()
{
    cin >> n >> k;
    for (int i = 1; i <= n; i++)
    {
        cin >> w[i] >> v[i];
    }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= k; j++)
        {
            //물건을 넣을 수 있는 경우
            if (j >= w[i])
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            //물건을 넣을 수 없는 경우
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    cout << dp[n][k];
    return 0;
}
