#include <iostream>
using namespace std;
//첫번째 기준 별4, 다음 동그라미3, 다음 네모2, 세모1, 모두같으면 무승부 
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int an, bn; // a,b개수
		int a, b;
		int A[5] = { 0 }, B[5] = { 0 };
		int cnt = 0;

		cin >> an;
		for (int i = 0; i < an; i++) {
			cin >> a;
			A[a]++;
		}
        cin >> bn;
        for (int i = 0; i < bn; i++) {
            cin >> b;
            B[b]++;
        }

        // 개수 비교 (4부터 내림차순으로)
        for (int i = 4; i > 0; i--) {
            if (A[i] > B[i]) {
                cout << "A\n";
                break;
            }
            else if (A[i] < B[i]) {
                cout << "B\n";
                break;
            }
            else cnt++;  // 개수가 똑같을 경우 카운트
        }
        // 4개 모두 개수가 같을 경우 무승부
        if (cnt == 4) cout << "D\n";
	}
}