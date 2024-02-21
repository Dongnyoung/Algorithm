#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#include <queue>
#include <list>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;


int main() {
	fastio;
	int n;
	string s;
	cin >> s >> n;
	list <char> L(s.begin(), s.end());


	for (auto it = L.end(); n--;) {
		char m ,a_m; 
		cin >> m;
		if (m == 'L') {
			if(it != L.begin()) it--;
		}
		else if (m == 'D') {
			if (it != L.end()) it++;
		}
		else if (m == 'B') {
			if (it != L.begin()) it = L.erase(prev(it));
		}
		else { cin >> a_m; L.insert(it, a_m); }

	}
	cout << string(L.begin(),L.end()) << '\n';
}
