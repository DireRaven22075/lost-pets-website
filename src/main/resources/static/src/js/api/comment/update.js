let URL = "/api/comments";
document
    .querySelector(
        "form#comment-update"
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            let data = {
                sn: document.querySelector("input[name=sn]").value,
                text: document.querySelector("input[name=text]").value
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
                res => res.json()
            ).then(
                data => {
                    if (data["status"] === "success") {
                        location.href = history.go(0);
                    } else {
                        alert("Failed to update");
                    }
                }
            ).catch(
                err => console.error(err)
            );
        }
    );