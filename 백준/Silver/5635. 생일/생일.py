#나이가 가장 적은 사람과 많은 사람을 구하기
import sys
input= sys.stdin.readline
n=int(input())

l=[]
#이름 일 월 생년
for i in range(n):
  name,d,m,y =input().rstrip().split()
  d,m,y=map(int,(d,m,y))
  l.append((y,m,d,name))
l.sort()

print(l[-1][3])
print(l[0][3])
