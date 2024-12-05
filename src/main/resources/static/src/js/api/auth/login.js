let URL = "/api/auth/login";
document.querySelector("form#Comment-Post").addEventListener("submit", (e) => {
    e.preventDefault();
    let data = {
        id: document.querySelector("input[name=id]").value,
        pw: document.querySelector("input[name=pw]").value
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
            window.location.href = '/';
        } else {
            document.querySelector("p#Text-Error").innerHTML = data["message"];
        }
    }).catch(err => console.error(err));
});