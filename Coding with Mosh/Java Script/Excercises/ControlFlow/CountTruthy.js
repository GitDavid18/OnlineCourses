const array = [2, null, undefined, 5, "yes"]

console.log(countTruthy(array));

function countTruthy(array) {
    let count = 0;
    for (let value of array)
        if (value)
            count++;

    return count
}