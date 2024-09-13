const movie = {
    title: 'Star Wars',
    year: 2018,
    actor: 'Harrison Ford',
    length: 145
};
console.log(movie);
stringProperties(movie);

function stringProperties(obj) {
    for (let key in obj) {
        // console.log(key);
        if (typeof (obj[key]) === 'string')
            console.log(key, obj[key])
    }
}