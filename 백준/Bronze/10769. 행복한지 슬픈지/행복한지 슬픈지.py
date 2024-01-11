#어떤 이모티콘 없으면none
#행복 수 =슬픔 수 unsure
#행복>슬픔happy
#행복<슬픔 sad

n=input()

if n.count(':-)')>n.count(':-('):
  print('happy')
elif n.count(':-)')<n.count(':-('):
  print('sad')
elif n.count(':-)')==0 and n.count(':-(')==0:
  print('none')
elif n.count(':-)')==n.count(':-('):
  print('unsure')