const numbers = [1, 2, 3, 4, 5, 3, 5, 2, 2];

console.log(countOccurrences(numbers, -1));
console.log(countOccurrences(numbers, 1));
console.log(countOccurrences(numbers, 2));
console.log(countOccurrences(numbers, 3));
console.log(countOccurrences(numbers, 4));
console.log(countOccurrences(numbers, 5));

function countOccurrences(array, searchObject) {
    // let occurrences = 0;

    // for (let num of array)
    //     if (num === searchObject)
    //         occurrences++;

    // return occurrences;

    return array.reduce((accumulator, curVal) => {
        if (curVal === searchObject)
            return ++accumulator;
        return accumulator;
    }, 0)
}