#0의개수

n=int(input())

for i in range(n):
  a,b=map(int,input().split())


  count=0
  for j in range(a,b+1):
    l=str(j)
    count+=l.count('0')

  print(count)