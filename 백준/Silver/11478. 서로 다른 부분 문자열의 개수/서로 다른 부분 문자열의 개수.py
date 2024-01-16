n=input()
c=[]
for i in range(len(n)):
  for j in range(i,len(n)):
    c.append(n[i:j+1])

n_c=set(c)

print(len(n_c))