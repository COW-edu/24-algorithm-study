line = list(map(int, input().split(" ")))

if line == sorted(line):
    print("ascending")
elif line == sorted(line, reverse=True):
    print("descending")
else:
    print("mixed")
