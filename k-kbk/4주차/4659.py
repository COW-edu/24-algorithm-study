while True:
    password = input()
    if password == "end":
        break

    aeiou = ["a", "e", "i", "o", "u"]

    if all(char not in aeiou for char in password):
        print(f"<{password}> is not acceptable.")
        continue

    jCount = 0
    mCount = 0
    isAcceptable = True

    for i in range(len(password)):
        char = password[i]

        if char in aeiou:
            mCount += 1
            jCount = 0
        else:
            jCount += 1
            mCount = 0

        if mCount == 3 or jCount == 3:
            isAcceptable = False
            break
        if i > 0 and password[i - 1] == char and char not in ["e", "o"]:
            isAcceptable = False
            break

    if isAcceptable:
        print(f"<{password}> is acceptable.")
    else:
        print(f"<{password}> is not acceptable.")
