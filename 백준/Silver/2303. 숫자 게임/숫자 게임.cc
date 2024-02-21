#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#include <queue>
#include <list>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int card[1000][5];
int score[1000];
int main()
{
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			cin >> card[i][j];
		}
	}
	//최대값을 구하자
	int max_value = 0;
	//각 인원의 최대값을 구하기위해 22행수행
	for (int i = 0; i < n; i++)
	{
		//5개 카드중 3개조합으로 최대값구하기
		for (int j = 0; j < 5; j++)
		{
			for (int k = j + 1; k < 5; k++)
			{
				for (int l = k + 1; l < 5; l++)
				{
					//각 인원의 최대값 저장
					score[i] = max(score[i], (card[i][j] + card[i][k] + card[i][l]) % 10);
				}
			}
		}
		//비교연산을 위해 전체 최대값저장
		max_value = max(max_value, score[i]);
	}
	int index = 0;
	//각 인원의 값과 비교해가며 최대값일 때 index출력
	for (int i = 0; i < n; i++)
	{
		if (score[i] == max_value)
			index = i + 1;
	}
	cout << index << endl;
}
