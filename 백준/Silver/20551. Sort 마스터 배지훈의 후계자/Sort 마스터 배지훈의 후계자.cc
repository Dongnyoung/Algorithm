#include <iostream>
#include <algorithm>
#include <vector>

#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;


int main() {
	fastio;
	int n, m; cin >> n >> m;
	vector <int> v(n);
	for (int i = 0; i < n; i++) cin >> v[i];
	sort(v.begin(), v.end());
	while (m--) {
		int t; cin >> t;
		auto w = lower_bound(v.begin(), v.end(), t);
		if (w == v.end() || *w != t) cout << -1 << '\n';
		else cout << w - v.begin() << '\n';
	}
}