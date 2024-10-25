const numbers = [1, 2, 3, 4, 5];
console.log(includes(numbers, 5));
console.log(includes(numbers, 50));
console.log(includes(numbers, 1));

function includes(array, element) {
    return array.some((cur) => cur == element);
}