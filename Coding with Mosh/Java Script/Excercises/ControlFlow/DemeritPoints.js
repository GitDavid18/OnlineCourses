checkSpeed(69)
checkSpeed(74.9)
checkSpeed(75.1)
checkSpeed(100.8)
checkSpeed(180)

function checkSpeed(speed) {
    const speedLimit = 70;
    const kmPerPoint = 5;

    if (speed < speedLimit + kmPerPoint) {
        console.log("Speed ok");
        return;
    }


    const points = Math.floor((speed - speedLimit) / kmPerPoint);
    if (points < 12)
        console.log("Points: " + points);
    else
        console.log("License suspended")
}