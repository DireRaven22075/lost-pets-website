
document
    .querySelector(
        "form#form-comment"
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            let URL = "/api/comments";
            let data = {
                sn: document.querySelector("#input-pst").value,
                text: document.querySelector("#input-content").value
            }
            fetch(
                URL,
                {
                    method: "POST",
                    credentials: "include",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(data)
                }
            ).then(

                (res) => {
                    if (res.ok) {
                        history.go(0);
                    }
                }
            )
        }
    );