showPrimes(0);
showPrimes(1);
showPrimes(167);

function showPrimes(limit) {
    if (limit <= 0) {
        console.log('Limit cannot be less than or equal to 0');
        return;
    }

    if (limit === 1) {
        console.log('input is 1');
        return;
    }

    let primes = [];

    for (let i = 2; i <= limit; i++) {
        if (isPrime(i) === false)
            continue;

        primes.push(i);
        // console.log('pushing', i);
    }
    console.log(primes);
}

function isPrime(number) {
    for (let factor = 2; factor < number; factor++) {
        if (number % factor === 0)
            return false;
    }

    return true;
}