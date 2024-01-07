#집합a에 속하고 집합b에 속하지 않는 원소 구하기

#입력 집합 a의 원소 개수, b의 원소개수
n,m=map(int,input().split())
#집합의 원소
a=set(list(map(int,input().split())))
b=set(list(map(int,input().split())))

re=a-b
res=sorted(re)

print(len(res))
print(*res)