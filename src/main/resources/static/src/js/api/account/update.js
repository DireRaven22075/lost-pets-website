let URL = "/api/users";
// Modify (User - UPDATE)
document
    .querySelector(
        "form#account-update"
    ).addEventListener(
        "submit",
        (event) => {
            event.preventDefault();
            let data = {
                key: document.querySelector("input[name=key]").value,
                value: document.querySelector("input[name=value]").value
            };
            fetch(
                URL,
                {
                    method: "PUT",
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
                    if (data["status"] === "success") {
                        location.href = "/";
                    } else {
                        alert("Failed to update");
                    }
                }
            ).catch(
                (err) => console.error(err)
            );
        }
    );