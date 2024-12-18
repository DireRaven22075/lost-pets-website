let URL = "/api/users"
document.querySelector("form#User-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    let data = {
        id: document.querySelector("input[name=id]").value,
        pw: document.querySelector("input[name=pw]").value,
        name: document.querySelector("input[name=name]").value,
        mail: document.querySelector("input[name=mail]").value,
    };

    fetch(URL, {
        method: "POST",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then((data) => {
        if (data["status"] === "success") {

        } else {

        }
    }).catch(err => console.error(err));
});