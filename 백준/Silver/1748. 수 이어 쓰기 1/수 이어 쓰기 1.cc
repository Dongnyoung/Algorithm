#include <iostream>
using namespace std;
//수 이어쓰기..
//1부터 쭈욱 수를 써가는데 이 수가 몇자리 수일까 를 구하는문제
// 따지고보면 10부터는 따로나눠서 볼수밖에없다
// 따라서 n 을 각자리수로 쪼개고 이 수가 차례대로 나오고 마지막 자릿수의 자리를 출력하면될듯하다

// 우선 10이하일때는 그대로 출력

// n-1 +1, n-10 +1, n-100 +1 이 각각 1의자리수를 갖고있는개수, 10의 자리수를 갖고있는개수, 100의자리수를 갖고있는개수 이렇게 생각

int main() {
	int n;
	int count=0;
	cin >> n; 
	if (n < 10) {
		cout << n;
		return 0;
	}
	for (int i = 1; i <= n; i *= 10) {
		count += n - i + 1;
	}
	cout << count;
	return 0;
}