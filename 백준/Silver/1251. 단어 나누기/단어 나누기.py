#입력받고
import sys

n=list((input().rstrip()))


#자르고
ans=[]
for i in range(1,len(n)-1):
  for j in range(i+1,len(n)):
    
    first=n[:i]
    second=n[i:j]
    third=n[j:]

    #뒤집기
    first.reverse()
    second.reverse()
    third.reverse()

    ans.append("".join(first+second+third))



print(min(ans))