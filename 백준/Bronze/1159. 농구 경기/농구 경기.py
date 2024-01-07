n=int(input())
player=[]
result=[]
for i in range(n):
  a=input()
  player.append(a[0])

first=set(player)

for i in first:
  if player.count(i)>=5:
     result.append(i)
    
if len(result)>=1:
  print(*sorted(result),sep='')

else:
  print('PREDAJA')