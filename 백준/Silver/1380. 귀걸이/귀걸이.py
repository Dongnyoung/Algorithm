#번호가 뺏김,돌려받음 순으로 두번 나오니까 학생수의 두배만큼 나와야한다
test=0
while True:
  
  n=int(input())
  if n==0:
    break
  else:
    test+=1
  l=[]
  for i in range(n):
    l.append(input())
  
  end=[]
  for j in range(n*2-1):
    a,b = input().split()
    end.append(int(a))
  stu=0
  #end에서 값이 두번 안나왔다면 그사람이 정답이고
  for k in range(1,n+1):
    if end.count(k)==1:
      stu=k
      break

  print(test,l[stu-1])