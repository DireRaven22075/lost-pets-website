let URL = "/api/users";
function check(key) {
    let value = document.querySelector(`input[id=input-register-${key}]`).value;
    let data = {
        key: key,
        value: value
    }
    fetch(
        URL,
        {
            method: "GET",
            credentials: "include",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        }
    ).then(
        (res) => res.json()
    ).then(
        (data) => {
            let status = data["status"];
        }
    ).catch(
        (err) => console.error(err)
    );
}