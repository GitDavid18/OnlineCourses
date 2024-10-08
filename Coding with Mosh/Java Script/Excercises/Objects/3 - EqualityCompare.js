let address1 = new Address('a', 'b', 'c');
let address2 = new Address('a', 'b', 'c');

console.log(areEqual(address1, address2));
console.log(areSame(address1, address2));

address2 = new Address('a', 'b', 'd')
console.log(areEqual(address1, address2));

address1 = address2;
console.log(areEqual(address1, address2));
console.log(areSame(address1, address2));


function Address(street, city, zipCode) {
    return {
        street,
        city,
        zipCode
    }
}

function areEqual(object1, object2) {
    for (let key in object1) {
        if (object1[key] !== object2[key])
            return false;
    }

    return true;
}

function areSame(object1, object2) {
    return object1 === object2;
}