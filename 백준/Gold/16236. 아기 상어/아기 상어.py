from collections import deque
n = int(input())

graph =[]
for _ in range(n):
  graph.append(list(map(int,input().split())))



dx=[0,0,-1,1]
dy=[1,-1,0,0]

pos=[]
for i in range(n):
  for j in range(n):
    if graph[i][j]==9:
      
      pos.append(i)
      pos.append(j)

count=0
def bfs(x,y):
  visited = [[0]*n for _  in range(n)]
  queue = deque([[x,y]])
  cand=[]
  visited[x][y]=1
  while queue:
    i,j = queue.popleft()
    for idx in range(4):
      nx = i+dx[idx]
      ny = j+dy[idx]
      
      if 0<=nx<n and 0<=ny<n and visited[nx][ny] ==0:
        if graph[x][y] > graph[nx][ny] and graph[nx][ny]!=0:
          visited[nx][ny]=visited[i][j]+1
          cand.append((visited[nx][ny]-1,nx,ny))
        elif graph[x][y] == graph[nx][ny]:
          visited[nx][ny]=visited[i][j]+1
          queue.append([nx,ny])
        elif graph[nx][ny]==0:
          visited[nx][ny]=visited[i][j]+1
          queue.append([nx,ny])
  return sorted(cand,key=lambda x:(x[0],x[1],x[2]))

i,j = pos
size= [2,0]

while True:
  graph[i][j] = size[0]
  cand = deque(bfs(i,j))
  if not cand:
    break
  d,xx,yy = cand.popleft()
  count+=d
  size[1]+=1
  if size[0]==size[1]:
    size[0]+=1
    size[1]=0
  graph[i][j]=0
  i,j = xx,yy

print(count)