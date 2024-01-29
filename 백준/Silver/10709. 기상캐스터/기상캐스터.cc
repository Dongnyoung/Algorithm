//c인곳은 출력 0 무조건 왼->오른쪽으로 구름 이동
//즉 같은 줄의 c와 얼만큼 떨어져있는지? 
//c가 올리가없으면 -1

//같은줄에 c의 오른쪽은 c의 위치에서 +1 c의 왼쪽에있는것들은 -1
//같은줄에 c가없으면 -1

//배열을 선언하고 각 요소들을 받고, 구름검사를하고 같은줄에 c가있으면 없으면으로 나누자
// 있으면 c의 오른쪽에 c가 또있는지 없는지 검사. c가 또있다면 c가있으면 0 c가없으면 +1, 또 c의 왼쪽은 -1
//없으면 -1
// 너무 복잡해서 뒤에있는 요소가 0보다 크다면(구름이있거나 구름이 곧도착하거나) 뒤요소 +1 해준다


#include <iostream>
#include <cstring>
using namespace std;
char c[100][100];
int board[100][100];
int main() {
	int h, w;
	cin >> h >> w;
	memset(board, -1, sizeof(board));
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cin >> c[i][j];
		}
	}
	//구름검사
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (c[i][j] == 'c') {
				board[i][j] = 0;
			}
			else if (j>0 && board[i][j - 1] >= 0) {
				board[i][j] = board[i][j - 1] + 1;
			}
		}
	}
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			cout << board[i][j]<<' ';
		}
		cout << '\n';
	}
}
