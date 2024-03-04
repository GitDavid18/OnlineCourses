def fizz_buzz(input):
    if (input % 3 != 0 and input % 5 != 0):
        return input

    message = ""
    if (input % 3 == 0):
        message += "Fizz"

    if (input % 5 == 0):
        message += "Buzz"

    return message


print(fizz_buzz(15))
print(fizz_buzz(10))
print(fizz_buzz(6))
print(fizz_buzz(11))
