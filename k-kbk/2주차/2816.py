n = int(input())

channels = [input() for _ in range(n)]

result = ""

cursor = 0
kbs1 = channels.index("KBS1")
result += "1" * kbs1
result += "4" * kbs1

channels.remove("KBS1")
channels.insert(0, "KBS1")

kbs2 = channels.index("KBS2")
result += "1" * kbs2
result += "4" * (kbs2 - 1)

print(result)
