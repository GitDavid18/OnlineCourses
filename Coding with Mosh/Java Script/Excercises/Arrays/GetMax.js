const numbers = [1, 2, 3, 4, 5, 7, 4];

const max = getMax(numbers);

console.log(max);

// use reduce method
function getMax(array){
    if (array.length === 0)
        return undefined;
    return array.reduce((curMax, curValue) => curMax < curValue ? curValue : curMax);
}