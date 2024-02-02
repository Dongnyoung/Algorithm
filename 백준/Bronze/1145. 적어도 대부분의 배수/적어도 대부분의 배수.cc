//다섯개 자연수
#include <iostream>
using namespace std;
int main() {
	int l[5] = {};
	int min = 1;
	for (int i = 0; i < 5; i++) {
		cin >> l[i];

	}
	while (1) {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (min % l[i] == 0) {
				cnt++;
			}
		}
		if (cnt >= 3) {
			cout << min << endl;
			break;
		}
		min++;
	}
}