#include <iostream>
#include <vector>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
int main() {
	fastio;
	string str1,str2;
	cin >> str1>>str2;
	vector <int> a(26);
	vector <int> b(26);
	for (int i = 0; i < str1.size(); i++) a[str1[i] - 'a']++;
	for (int i = 0; i < str2.size(); i++) b[str2[i] - 'a']++;
	int result = 0;
	for (int i = 0; i < 26; i++)
		result += abs(a[i] - b[i]);
	cout << result; 

}