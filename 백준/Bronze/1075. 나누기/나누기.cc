//n,f 주어짐.
//n의 가장 뒤 두자리를 적절히 바꿔 n을 f로 나누어떨어지게!
//여러가지면 가장작은 뒤 두자리
//뒤자리 00으로 설정.


#include <iostream>
using namespace std;

int n;
int f;
int result = 0;
int main() {

	cin >> n >> f;

	n /= 100;
	n *= 100;
	while (n % f != 0) {
		n++;
		result++;
	}
	if (result < 10) {
		cout << '0'<<result << endl;
	}
	else
		cout << result << endl;
}


