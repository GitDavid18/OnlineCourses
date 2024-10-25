const numbers = [1, 2, 3, 4, 5];

console.log(move(numbers, 2, -2));
console.log(move(numbers, 0, 0));
console.log(move(numbers, 2, -5));
console.log(move(numbers, 2, 5));
console.log(numbers);

function move(array, index, offset) {
    if (index >= array.length || index < 0) {
        console.error('Invalid index');
        return;
    }

    if (index + offset >= array.length || index + offset < 0) {
        console.error('Invalid offset');
        return;
    }

    let output = array.slice();
    output.splice(index, 1);
    output.splice(index + offset, 0, array[index]);

    return output;
}