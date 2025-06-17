function solution(wallpaper) {
    let lux = [];
    let luy = [];

    for (let i = 0; i < wallpaper.length; i++) {
        for (let j = 0; j < wallpaper[i].length; j++) {
            if (wallpaper[i][j] === '#') {
                lux.push(i);
                luy.push(j);
            }
        }
    }

    const top = Math.min(...lux);
    const left = Math.min(...luy);
    const bottom = Math.max(...lux) + 1;
    const right = Math.max(...luy) + 1;

    return [top, left, bottom, right];
}
