#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>
#define fastio cin.tie(0)->sync_with_stdio(0)
using namespace std;

int main() {
    fastio;
    deque<int> dq;
    int n, m;
    cin >> n >> m;

    int cnt = 0;

    // 1~n까지 수를 넣어준다
    for (int i = 1; i <= n; i++)
        dq.push_back(i);

    while (m--) {
        // 위치 값 받기
        int t;
        cin >> t;

        int idx = 0;

        // 위치 찾기
        for (int i = 0; i < dq.size(); i++) {
            if (dq.front() == t) {
                idx = i;
                break;
            }
            dq.push_front(dq.back());
            dq.pop_back();
        }

        // 회전 횟수 계산
        cnt += min<int>(idx, dq.size() - idx);

        // 현재 위치의 숫자 제거
        dq.pop_front();
    }

    cout << cnt << '\n';

    return 0;
}
