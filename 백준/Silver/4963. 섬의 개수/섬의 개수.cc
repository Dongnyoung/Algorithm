#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int n, m, v[50][50], visited[50][50];
int dx[8] = {1,1,0,-1,-1,-1,0,1},dy[8]={0,1,1,1,0,-1,-1,-1};

void DFS(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 8; i++) {
        const int nx = x + dx[i];
        const int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (v[nx][ny] && !visited[nx][ny]) DFS(nx, ny);
    }
}

int Sol() {
    int ret = 0; memset(visited, 0, sizeof visited);
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
        if (v[i][j] && !visited[i][j]){
            DFS(i, j); ret++;
        }
    }
    return ret;
}

int main() {
    fastio;
    while (cin >> m >> n && n) {
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) cin >> v[i][j];
        cout << Sol() << '\n';
    }
}
