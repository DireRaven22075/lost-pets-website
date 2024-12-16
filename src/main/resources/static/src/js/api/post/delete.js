let URL = "/api/posts";

document.querySelector("form#Post-Delete").addEventListener("submit", (e) => {
    e.preventDefault();
    fetch(URL, {
        method: "DELETE",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        if (data["status"] === "success") {

        } else {
            
        }
    }).catch(err => console.error(err));
});