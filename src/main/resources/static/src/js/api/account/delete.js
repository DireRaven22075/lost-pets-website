let URL = "/api/users";
// Delete (User - DELETE)
document
    .querySelector(
        "form#account-delete"
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            fetch(
                URL,
                {
                    method: "DELETE",
                    credentials: "include",
                    headers: {
                        "Content-Type": "application/json"
                    }    
                }
            ).then(
                res => res.json()
            ).then(
                data => {
                    if (data["status"] === "success") {
                        location.href = "/";
                    } else {
                        alert("Failed to delete");
                    }
                }
            ).catch(
                err => console.error(err)
            );
        }
    );