showStars(15)

function showStars(rows) {
    let stars = "";
    for (let i = 1; i <= rows; i++) {
        stars += "*";
        console.log(stars);
    }
}