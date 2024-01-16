#한번입었던 옷들의 조합을 절대 다시 입지 않는다

#안입는경우를+1 해서 곱해주고 마지막에 알몸인경우 -1
import sys
input = sys.stdin.readline
T=int(input())

for _ in range(T):
  n=int(input())
  clothes={}
  for j in range(n):
    cl_n,cl_t = input().split()

    #분류
    if cl_t not in clothes.keys():
      clothes[cl_t] = 1
    else:
      clothes[cl_t] +=1 
      
  result=1
  for i in clothes:
    result*=(clothes[i]+1)
  print(result-1)