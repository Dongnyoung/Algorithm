#include <iostream>

#include <vector>

using namespace std;

int main() {
	string str;
	cin >> str;
	vector<char> word;
	word.push_back(str[0]);
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == '-') {
			word.push_back(str[i+ 1]);
		}
	}
	
	for (int i = 0; i < word.size(); i++) {
		cout << word[i];
	}
}