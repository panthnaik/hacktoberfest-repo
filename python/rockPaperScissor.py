import random
rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''


inputplay = input("what do you choose? type 0 for rock 1 for paper and 2 for scissors?? \n")

r=p=s=0
if inputplay == 0:
  r = 1
  print(rock)
elif inputplay == 1:
  p = 1
  print(paper)
else:
  s = 1
  print(scissors)
rps = [rock,paper,scissors]
ran = random.choice(rps)
print("\n")
print("computer chose:")
print("\n")
print(ran)
if r == 1 and ran == rock:
  print("tie")
elif p == 1 and ran == paper:
  print("tie")
elif s == 1 and ran == scissors:
  print("tie")
elif r == 1 and ran == paper:
  print("paper beats rock, you loose")
elif r == 1 and ran == scissors:
  print("rock beats scissors, you win")
elif p == 1  and ran == rock:
  print("paper beats rock ,you win")
elif p == 1 and ran == scissors:
  print("scissors beat paper, you loose")
elif s ==1 and ran == rock:
  print("rock beats scissiors,you loose")
elif s == 1 and ran == paper:
  print("scissors beats paper, you win")
else:
  print("error")




