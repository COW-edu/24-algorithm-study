import sys

input = sys.stdin.readline

n, m = map(int, input().split())

pokemonDict = {}

for i in range(1, n + 1):
    name = input().strip()
    pokemonDict[str(i)] = name
    pokemonDict[name] = str(i)

for _ in range(m):
    question = input().strip()
    print(pokemonDict[question])
