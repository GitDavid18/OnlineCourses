let address = {
    street: 'Mystreet',
    city: 'AwesomeTown',
    zipCode: 'ABC123'
};

function showAddress(address) {
    for (let key in address)
        console.log(key, address[key]);
}

showAddress(address);