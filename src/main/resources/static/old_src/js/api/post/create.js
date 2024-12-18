let URL = "/api/post";
document.querySelector("form#Comment-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    let data = new FormData();

    fetch(URL, {
        method: "POST",
        credentials: "include",
        body: data
    }).then(res => res.json()).then((data) => {
        if (data["status"] === "success") {

        } else {

        }
    }).catch(err => console.error(err));
});