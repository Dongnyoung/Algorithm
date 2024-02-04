#include <iostream>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
int main() {
	fastio;
	string str;
	cin >> str;
	vector <int> a(26);
	for (int i = 0; i < str.size(); i++) a[str[i] - 'a']++;
	for (int i = 0; i < 26; i++)cout << a[i] << ' ';
	cout << '\n';
}