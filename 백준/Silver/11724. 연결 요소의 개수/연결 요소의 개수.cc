#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
int n, m, visited[1001];
int count;
vector <int> adj[1001];
void DFS(int cur) {
	visited[cur] = 1;
	for (int nxt : adj[cur]) {
		if (!visited[nxt])
			DFS(nxt);
	}
}

int main() {
	fastio;
	int count = 0;
	cin >> n >> m;
	while (m--) {
		int a, b; cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	
	for (int i = 1; i <= n; i++) {
		if (visited[i]) continue;
		DFS(i);
		count++;
	}

	cout << count << '\n';



}