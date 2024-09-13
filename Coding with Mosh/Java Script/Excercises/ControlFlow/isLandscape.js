console.log("Is the following in landscape?")

console.log("1080 x 1920 - " + isLandscape(1080, 1920))
console.log("1920 x 1080 - " + isLandscape(1920, 1080))
console.log("1080 x 1080 - " + isLandscape(1080, 1080))

function isLandscape(width, height) {
    return width > height;
}