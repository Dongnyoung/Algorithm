#5개 나무조각
#과정...
#순서가 1 2 3 4 5가 될때까지 반복
#자기보다 1큰 번째의 수보다 크면 위치를 바꾼다 그렇게 네번째조각 다섯번째조작까지 간다.

#출력은 각 과정들을 출력
answer=[1,2,3,4,5]
a = list(map(int,input().split()))


while a!=answer:
  
  for i in range(len(a)-1):
    if a[i] > a[i+1]:
      a[i], a[i+1]=a[i+1],a[i]

      print(*a)
