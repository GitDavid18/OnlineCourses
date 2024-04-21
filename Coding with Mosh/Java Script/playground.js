let test = {
    prop1: 55.6,
    prop2: 'other prop'
}

console.log(test);

let colors = ['red', 'green'];
colors[2] = 'blue';

console.log(colors);


function greet(name){
    console.log('Hello ' + name);    
}

greet('John');
greet('Peter');

function square(number){
    return number * number;
}

console.log(square(5));
console.log(square(7));


let userColor = 'red';
let defaultColor = 'blue';
let currentColor = userColor || defaultColor;

console.log(currentColor);