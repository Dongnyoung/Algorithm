#가장 적은 수의 나무를 심고싶다.
#위치는 기준점으로 부터 떨어져있는거리
#모든 가로수가 같은 가격이 되도록 새로 심어야 하는 가로수의 최소

#가로수의 간격이 최대공약수다..!
import sys
from math import gcd

n = int(input())
d = []

# 가로수의 간격 입력 받기
l=[]
for _ in range(n):
    l.append(int(input()))

d =[]
for i in range(len(l)-1):
    d.append(abs(l[i+1]-l[i]))

# 가로수 간격의 최대공약수 찾기
a = d[0]
for j in d:
    a = gcd(a,j)

# 새로 심어야 하는 가로수 

count=0
for i in d:
  count+=(i//a)-1

print(count)