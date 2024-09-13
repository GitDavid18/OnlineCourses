console.log(fizzBuzz(3));
console.log(fizzBuzz(5));
console.log(fizzBuzz(15));
console.log(fizzBuzz(14));


function fizzBuzz(input) {
    if (typeof (input) !== 'number')
        return "Is not a number"

    let fizzy = "";

    if (input % 3 === 0)
        fizzy += "fizz";

    if (input % 5 === 0)
        fizzy += "buzz";

    return fizzy == "" ? input : fizzy;
}