#우측으로 이동하는데, 자신보다 낮은게 있으면 count
n=int(input())
data=list(map(int,input().split()))
high=0
count=0
result=[]
for i in data:
  if i>high:
    high=i
    count=0
  else:
    count+=1
  result.append(count)

print(max(result))