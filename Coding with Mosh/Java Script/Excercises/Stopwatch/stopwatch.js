function Stopwatch() {
    this.Start = function () {
        if (started)
            return new Error("Watch already started");
        console.log("Start");
        startTime = new Date();
        started = true;
    };

    this.Stop = function () {
        if (!started)
            return new Error("Watch not running");
        console.log("Stop");
        started = false;
        let endTime = new Date();
        duration += (endTime.getTime() - startTime.getTime()) / 1000;
    };

    this.Reset = function () {
        console.log("Reset");
        started = false;
        duration = 0;
    };

    let started = false;
    let duration = 0;
    let startTime = 0;
    Object.defineProperty(this, 'duration', {
        get: function () {
            return duration;
        }
    })
}

function timeout(ms) {
    return new Promise((resolve) => {
        setTimeout(resolve, ms * 1000);
    });
}
let sw = new Stopwatch();

async function main() {
    sw.Start();
    await timeout(5);
    sw.Stop();
    console.log(sw.duration);
    sw.Stop();
    console.log(sw.duration);
    sw.Start();
    await timeout(7);
    sw.Start();
    await timeout(5);
    sw.Stop();
    console.log(sw.duration);
    sw.Reset();
    console.log(sw.duration);
    sw.Start();
    await timeout(5);
    sw.Stop();
    console.log(sw.duration);
}

main();