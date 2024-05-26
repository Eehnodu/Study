function plus() {
    num += 1
    document.getElementById("txt").innerHTML = num
}

function minus() {
    if (num > 0) {
        num -= 1
        document.getElementById("txt").innerHTML = num
    }
}