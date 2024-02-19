#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#include <queue>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;
struct cmp {
    bool operator()(int a,int b) {
        if (abs(a) != abs(b)) return(abs(a) > abs(b));
        return a > b;
    }
};

int main() {
    fastio;
    priority_queue<int, vector<int>, cmp> pq;
    int n,t; cin >> n;
    vector <int> result;
    for (int i = 0; i < n; i++) {
        cin >> t;
        if (t == 0) {
            if (pq.empty()) {
                result.push_back(0);
            }

            else {
                result.push_back(pq.top());
                pq.pop();
            }
        }
        else {
            pq.push(t);
        }
    }
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << '\n';
    }

    return 0;
}
