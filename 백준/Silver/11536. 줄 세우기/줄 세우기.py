#이름순이닞 아닌지 확인
#증가순이면 INCREASING, 감소하는 순이면 DECREASING을 한 줄에 출력한다. 만약 위의 두 경우가 아니라면 NEITHER로 출력


# 먼저 sort 메서드는 리스트를 정렬하고 반환하지만, 반환된 값은 항상 None입니다. 이게 매우 중요
# sorted()는 원본 유지가 핵심!
n=int(input())
name=[]
for i in range(n):
  name.append(list(input().split()))

in_name  = sorted(name)
de_name  = sorted(name, reverse=True)

if in_name == name:
  print("INCREASING")
elif de_name == name:
  print("DECREASING")
else:
  print("NEITHER")