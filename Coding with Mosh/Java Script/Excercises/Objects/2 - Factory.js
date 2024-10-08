let address = {
    street: 'Mystreet',
    city: 'AwesomeTown',
    zipCode: 'ABC123'
};

//factory function
function createAddress(street, city, zipCode) {
    return {
        street,
        city,
        zipCode
    }
}
let firstAddress = createAddress('someStreet', 'anyCity', '987YIU');
console.log(firstAddress);

//constructor
function Address(street, city, zipCode) {
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
}

let newAddress = new Address('Mystreet', 'ACity', 'ASD456');
console.log(newAddress);