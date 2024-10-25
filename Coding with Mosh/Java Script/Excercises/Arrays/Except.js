const numbers = [1, 2, 3, 4, 5, 1, 4];

const ex = except(numbers, [1, 4]);
console.log(ex);


function except(array, excepted) {
    let output = [];
    for (let element of array) {
        if (excepted.includes(element) === false)
            output.push(element);
    }

    return output;
}