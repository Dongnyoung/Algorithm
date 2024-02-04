#include <iostream>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
int main() {
	fastio;
	int n;
	bool flag;
	cin >> n;
	while (n--) {
		string str1, str2;
		cin >> str1 >> str2;
		vector <int> cnt(26);
		flag = true;
		for (int i = 0; i < str1.size(); i++) cnt[str1[i] - 'a']++;
		for (int i = 0; i < str2.size(); i++) cnt[str2[i] - 'a']--;

		for (int i = 0; i < 26; i++)
			if (cnt[i] != 0) {
				flag = false;
				break;
			}
		if (flag) {
			cout << "Possible"<<'\n';

		}
		else {
			cout << "Impossible"<<'\n';
		}
	}
}