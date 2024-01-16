cam = ['C','A','M','B','R','I','D','G','E']

n =list(input())
n_n= []
for i in n:
  if i not in cam:
    n_n.append(i)

print(*n_n,sep='')