#include <iostream>
using namespace std;
//연속된 숫자는 한 히든 넘버
// 두 히든 넘버 사이에 글자가 적어도 한개있다
// 히든넘버 6자리 넘지 않는다.
#include <vector>
//숫자판단함수
char num[5000001];
int main() {
	int n;
	long long answer=0 ,sum = 0;


	cin >> n;
	cin >> num;
	for (int i = 0; i < n; i++)
	{
		if (num[i] > 47 && num[i] < 58)
		{
			answer = answer * 10 + num[i] - 48; // 0*10 + 1, 1*10+3			
		}
		else
		{
			sum += answer;
			answer = 0;
			
		}
	}
	sum += answer;
	cout << sum << endl;
	
}