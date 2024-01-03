#0을 추가해서 가로 세로 배열 만들고
#0이면 가로에다가 , 1이면 세로에다가
n,m=map(int,input().split())
t=int(input())
garo=[0,n]
sero=[0,m]
result=0
for i in range(t):
  a,b=map(int,input().split())
  
  if a==0:
    sero.append(b)
  elif a==1:
    garo.append(b)


sero.sort()
garo.sort()
result=0
#각 원소들의 차를 구하고 가로세로 곱이 가장 큰것
for i in range(len(garo)-1):
  for j in range(len(sero)-1):
    x=garo[i+1]-garo[i]
    y=sero[j+1]-sero[j]
    result=max(result,x*y)
print(result)