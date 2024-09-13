console.log(sumOfMultiples(10));

function sumOfMultiples(limit) {
    let nums = 0;
    for (let i = 0; i <= limit; i++)
        if (i % 3 === 0 || i % 5 === 0)
            nums += i;

    return nums;
}