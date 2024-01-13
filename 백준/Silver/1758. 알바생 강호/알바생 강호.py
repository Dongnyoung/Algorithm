# 입구에 들어갈때 팁을 준다
# 주려고 생각했던 돈 - (받은등수-1)의팁을 준다

# 입력은 사람수와 각사람이 주려고 생각한 팁
import sys
input = sys.stdin.readline
n=int(input())
think=[]
for i in range(n):
    
  think.append(int(input()))

#많은돈에서 적게 빼는느낌으로가야함. 즉 , 많은돈 일수록 등수를 높여라

r_think=sorted(think,reverse=True)

money=[]
for i in range(len(r_think)):
  money.append((r_think[i]-(i+1-1)))

  #만약 0보다작은 음수값이 나올때 0으로 처리해줘야함
  if money[i]<0:
    money[i]=0

print(sum(money))