const marks = [0, 9, 90];

console.log(overallAverage(marks));

function overallAverage(marks) {
    let sum = 0;
    for (let mark of marks) {
        sum += mark;
    }

    const average = sum / marks.length;

    if (average < 60)
        return 'F';
    if (average < 70)
        return 'D';
    if (average < 80)
        return 'C';
    if (average < 90)
        return 'B';

    return 'A';
}