#평균 구하기??

c= int(input())

avg=0
#평균을 구하고 평균을 넘는 학생드르이 비율을 구하라
for i in range(c):
  n=list(map(int,input().split()))
  avg = sum(n[1:])/n[0]
  count=0
  for score in n[1:]:
    if score>avg:
      count+=1
  rate = count/n[0] *100

  print(f'{rate:.3f}%')