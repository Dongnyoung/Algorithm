#백트래킹

n=int(input())
l=[]

def back():
  if len(l)==n:
    print(*l)
    return
  for i in range(1,n+1):
    if i not in l:
      l.append(i)
      back()
      l.pop()

back()