let URL = "/api/users";
// GET User Information (User - READ)

function readUser() {
    fetch(URL, {
        method: "GET",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {

    }).catch(err => console.error(err));
}