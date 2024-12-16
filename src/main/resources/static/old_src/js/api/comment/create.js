let URL = "/api/comments"
document.querySelector("form#Comment-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    let data = {
        content: document.querySelector("input[name=content]").value,
        pst: document.querySelector("p#Value-PST").innerHTML
    }
    fetch(URL, {
        method: "POST",
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