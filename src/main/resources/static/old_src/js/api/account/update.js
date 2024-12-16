let URL = "/api/comments"
document.querySelector("form#Comment-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    let data = new FormData();
    data.append("key", document.querySelector("p#Value-Key").innerHTML);
    data.append("value", document.querySelector("p#Value-Value").innerHTML);
    fetch(URL, {
        method: "PUT",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: data
    }).then(res => res.json()).then((data) => {
        if (data["status"] === "success") {

        } else {

        }
    }).catch(err => console.error(err));
});