#include <iostream>
#include <string>

using namespace std;

// 1부터 N까지 수를 이어붙인 길이 구하기
long long cal_length(int N)
{
	long long len = 0;
	for (int start = 1, i = 1; start <= N; start *= 10, ++i)
	{
		int end = start * 10 - 1;
		if (end > N)
		{
			end = N;
		}

		len += (long long)(end - start + 1) * i;
	}
	return len;
}

int binary_search(int left, int right, int target)
{
	if (left >= right)
	{
		return right;
	}

	int mid = (left + right) / 2;
	long long len = cal_length(mid);

	/*
		1부터 mid까지 이어붙인 수의 길이 < target 이면
		[mid + 1, right] 범위에서 재 탐색
	*/
	if (len < target)
	{
		return binary_search(mid + 1, right, target);
	}
	/*
		1부터 mid까지 이어붙인 수의 길이 >= target 이면
		[left, mid] 범위에서 재 탐색 (mid값 포함)
	*/
	else
	{
		return binary_search(left, mid, target);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	// 입력
	int N, K;
	cin >> N >> K;

	// 수의 길이가 K보다 작은 경우
	if (cal_length(N) < K)
	{
		cout << -1;
		return 0;
	}

	// 1부터 num까지 이어붙였을 때의 길이가 K보다 같거나 큰 최소의 수 num구하기
	int num = binary_search(1, N, K);

	// 1부터 num까지 이어붙였을 때의 길이 num_len구하기
	int num_len = cal_length(num);
	
	string s_num = to_string(num);

	// num에서 뒤에서 (num - K)만큼 앞에 있는 숫자 구하기
	cout << s_num[(s_num.size() - 1 - (num_len - K))];

	return 0;
}
