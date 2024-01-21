#include <iostream>
using namespace std;

int l, p, v,i;
int main() {
	do {
		i++;
		cin >> l >> p >> v;
		if (l == 0 && p == 0 && v == 0)
			break;
		int ans = (v / p) * l + min(v % p, l);
		cout <<"Case "<<i<<": "<< ans<<"\n";
	} while (1);
	return 0;
}