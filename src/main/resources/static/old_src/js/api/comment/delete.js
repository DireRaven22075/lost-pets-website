let URL = "/api/comments"
document.querySelector("form#Comment-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    let data = new FormData();

    fetch(URL, {
        method: "DELETE",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then((data) => {
        if (data["status"] === "success") {

        } else {

        }
    }).catch(err => console.error(err));
});