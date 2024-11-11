const numbers = [1, 2, 3, 4, 5, 3, 5, 2, 2];

console.log(countOccurrences(numbers, -1));
console.log(countOccurrences(numbers, 1));
console.log(countOccurrences(numbers, 2));
console.log(countOccurrences(numbers, 3));
console.log(countOccurrences(numbers, 4));
console.log(countOccurrences(numbers, 5));

try {
    console.log(countOccurrences(true, 5));
}
catch (e) {
    console.error(`Problem counting occurrences: ${e}`);
}

function countOccurrences(array, searchObject) {
    if (Array.isArray(array) === false)
        throw new Error('value is not an array');

    return array.reduce((accumulator, curVal) => {
        if (curVal === searchObject)
            return ++accumulator;
        return accumulator;
    }, 0)
}