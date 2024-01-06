import sys
import math
T = int(input())


for _ in range(T):
  num = list(map(int, input().split()))
  s=0
  for i in range(1, len(num)):
    for j in range(i + 1, len(num)):
      s += math.gcd(num[i], num[j])

  print(s)
