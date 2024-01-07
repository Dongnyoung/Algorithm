#길이 a1~an 총 n개의 쇠막대가 필요함
#a1+...+an 쇠막대 하나 뿐
#직접 잘라서 n개 막대 만들 것.
# x+y막대길이를 x,y 두개의 막대로 만들때는 비용 x*y가 든다
#최소비용 구하기


#입력에는 n개
#둘째줄에는 a1..+an이 주어진다

n=int(input())
a=sorted(list(map(int,input().split())))
total=0
s=sum(a)


for i in range(n):
  s-=a[i]
  total += a[i]*s

print(total)