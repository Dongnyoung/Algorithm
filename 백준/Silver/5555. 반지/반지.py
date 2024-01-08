#반지는 문자열의 시작과 끝이 연결된 형태
#문자열이 포함된 반지는 몇개??

search = input()
n=int(input())
count=0
for i in range(n):
  word = input()
  if search in word*2:
    count+=1
print(count)