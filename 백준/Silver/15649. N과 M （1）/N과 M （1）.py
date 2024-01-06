n,m=map(int,input().split())
#백트래킹
l=[]

def back():
  if len(l)==m:
    print(*l)
    return
  for i in range(1,n+1):
    if i not in l:
      l.append(i)
      back()
      l.pop()

back()