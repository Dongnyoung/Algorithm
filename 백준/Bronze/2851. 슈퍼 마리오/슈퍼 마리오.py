#최대한 100에 가깝게 하기
l=[]
score=0
for i in range(10):
  l.append(int(input()))

for j in l:
  score+=j
  if score>=100:
    if score-100>100-(score-j):
        score-=j
    break

print(score)