const movies = [
    {title: 'a', year: 2018, rating: 4.5},
    {title: 'b', year: 2017, rating: 5},
    {title: 'c', year: 2017, rating: 4.7},
    {title: 'd', year: 2018, rating: 3},
    {title: 'e', year: 2018, rating: 4.6},
];

const moviesInYear = releaseYear(movies, 2018);
console.log(moviesInYear);

const moviesWithMinRating = minRating(moviesInYear, 4);
console.log(moviesWithMinRating);

const sorted = moviesWithMinRating.sort((a,b) =>  b.rating - a.rating
);
console.log(sorted);

function minRating(movies, minRating){
    return movies.filter(currentMovie => currentMovie.rating >= minRating)
}

function releaseYear(movies, year){
    return movies.filter(currentMovie => currentMovie.year === year);
}