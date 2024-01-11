import sys
input = sys.stdin.read

# *S로 선언한 이유 : Python에서 *을 붙여서 변수를 선언해주면 정해지지 않은 개수의 입력값이 들어온다는 의미이다. 
N, *S = input().split()
for i in range(int(N)):
    S[i] = S[i][::-1]
S = list(map(int, S))
print(*sorted(S), sep="\n")