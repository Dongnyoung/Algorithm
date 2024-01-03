n=int(input())
m=int(input())
l=[]
for i in range(n,m+1):
  t=int(i**0.5)**2
  if i==t:
    l.append(i)

if l:
  print(sum(l))
  print(min(l))

else:
  print(-1)