#include <iostream>
using namespace std;
int score[200][3];
int total[200];
int main() {
	int n;

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> score[i][j];
		}
	}
	for (int s = 0; s < 3; s++) {
		for (int k = 0; k < n; k++) {
			int cnt = 0;
			for (int y = 0; y < n; y++) {
				if (score[k][s] == score[y][s] && y != k) {
					cnt++;
				}
			}
			if (cnt == 0) {
				total[k] += score[k][s];
			}

		}

	}
	for (int r = 0; r < n; r++) {
		cout << total[r] << '\n';
	}

}