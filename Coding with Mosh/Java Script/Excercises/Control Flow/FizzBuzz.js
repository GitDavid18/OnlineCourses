function fizzBuzz(num){
    if(typeof num !== 'number')
        return 'not a number';
    let fizzy = "";
    
    if(num % 3 === 0)
        fizzy += "Fizz";
    
    if(num % 5 === 0)
        fizzy += "Buzz"

    if(fizzy === "")
        fizzy = num;

    return fizzy;
}

console.log(fizzBuzz(false));