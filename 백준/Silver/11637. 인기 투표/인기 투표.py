#각 케이스 별로 가장 큰놈 찾고 과반수 체크하고 위너선정 없으면 위너없음

T = int(input())

for i in range(T):
  n = int(input())
  stu = []
  for _ in range(n):
    s = int(input())
    stu.append(s)
  check = max(stu)
  k = int(sum(stu) // 2)
  check_index = stu.index(check) + 1
  if stu.count(check) >= 2:
    print('no winner')
  else:

    if check > k:
      print(f'majority winner {check_index}')

    else:
      print(f'minority winner {check_index}')
