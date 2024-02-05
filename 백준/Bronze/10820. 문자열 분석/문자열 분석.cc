#include <iostream>
#include <string>
using namespace std;
int main() {
	for (string s; getline(cin, s);) {
		int cnt[4]{};
		for (int i = 0; i < s.size(); i++) {
			if (islower(s[i])) cnt[0]++;
			else if (isupper(s[i]))cnt[1]++;
			else if (isdigit(s[i]))cnt[2]++;
			else cnt[3]++;
		}
		for  (int i = 0 ; i<4;i++) cout << cnt[i] << endl;

	}
	
}