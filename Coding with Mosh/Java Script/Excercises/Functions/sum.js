console.log(sum(1, 2, 3, 4));
console.log(sum([1, 2, 3, 5]));


function sum(...input) {
    let numbers = input;

    if (input.length === 1 && Array.isArray(input[0]))
        numbers = input[0];
    return numbers.reduce((a, b) => a + b);
}
