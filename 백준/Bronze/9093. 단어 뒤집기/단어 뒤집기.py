import sys
n = int(input())

for i in range(n):
    str = sys.stdin.readline().rstrip()
    words = list(str.split())
    reverse_words = []
    
    for j in words:
        reverse_words.append(j[::-1])
        
    answer = " ".join(reverse_words)
    print(answer)