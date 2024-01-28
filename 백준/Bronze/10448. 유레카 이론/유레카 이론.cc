#include <iostream>
#include <vector>
using namespace std;

vector<int>eureka;
//1000보다 작은 삼각수계산
void cal(){
	int n = 1;
	while ((n)*(n + 1) / 2 < 1000) {
		eureka.push_back(n * (n + 1) / 2);
		n++;
	}
}
//삼각수 판별
bool tri(int n) {
	for (int i = 0; i < eureka.size(); i++) {
		for (int j = 0; j < eureka.size(); j++) {
			for (int k = 0; k < eureka.size(); k++) {
				if (eureka[i] + eureka[j] + eureka[k] == n)
					return true;
			}
		}
	
	}
	return false;
}

int main() {
	int T;
	int n;
	cin >>T;
	cal();
	for (int i = 0; i < T; i++) {
		
		
		
		cin >> n;
		cout << tri(n) << endl;

	}
	return 0;
}