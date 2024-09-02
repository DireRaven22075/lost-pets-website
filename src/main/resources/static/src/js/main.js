function goto(dest) {
    window.scrollTo(0, 0);
    window.location.href = dest;
    return;
}
function toggle(id, name) {
    document.querySelector("#" + id).classList.toggle(name);
    return;
}