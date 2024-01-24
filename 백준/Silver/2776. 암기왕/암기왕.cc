//하루동안 본 정수 수첩1에정리 연종이가
// 동규가 수첩2에 연종이가 주장하는 수 
// 수첩1과 수첩2를 비교해서 수첩2에있는 수가 1에있으면 1, 없으면 0
//해시맵
#include <iostream>
#include <unordered_map>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	int T,n,m;
	cin >> T;
	for (int k = 0; k < T; k++) {
		cin >> n;
		unordered_map<int, int>u_m;
		for (int i = 0; i < n; i++) {
			int num;
			cin >> num;
			u_m[num] = 1;
		}
		cin >> m;
		for (int i = 0; i < m; i++) {
			int num2;
			cin >> num2;
			if (u_m[num2] == 1)
				cout << '1' << '\n';
			else
				cout << '0'<< "\n";

		}


	}
	return 0;
}