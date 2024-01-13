#반복문 과정 b[i]=a[i+1]-a[i]

n,k=map(int,input().split())

l=list(map(int,input().split(',')))


for _ in range(k):
  l=[l[i+1]-l[i] for i in range(len(l)-1)]
print(*l,sep=',')
  