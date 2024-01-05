#j개의 사탕을 보내기 위해 상자에 포장해야함
#상자n개
#사탕개수와 상자개수가 입력  다음줄 부터는 i번째 상자의 세로 길이 r 가로길이 c가 주어짐.
#각 상자에 담을 수 잇는 개수는 r*c를 넘을수없다

#최소로 해야하니까 결국은 n개의 크기중에서 가장 큰걸 빼면서 count+=1 해주면 될듯
#j와 크거나 같으면 break

T=int(input())
for _ in range(T):
  j,n=map(int,input().split())
  count=0
  size=[]
  for i in range(n):
    r,c=map(int,input().split())
    size.append(r*c)
  size.sort(reverse=True)

  for i in range(len(size)):
    j-=size[i]
    count+=1
    if j<=0:
      break

  print(count)