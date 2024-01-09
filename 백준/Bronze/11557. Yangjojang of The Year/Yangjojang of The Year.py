T=int(input())
for _ in range(T):
  n=int(input())

  max=0
  for i in range(n):
    a,b = input().split()
    b=int(b)
    if b>max:
      max=b
      bname=a

  print(bname)