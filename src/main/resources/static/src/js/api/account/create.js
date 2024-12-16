let URL = "/api/users";
/// Register (User - CREATE)
document
    // Select the form element with the ID of account-register
    .querySelector(
        "form#form-register"
    // Add an event listener for the submit event
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            let data = {
                id: document.querySelector("input[name=id]").value,
                pw: document.querySelector("input[name=pw]").value,
                mail: document.querySelector("input[name=mail]").value,
                name: document.querySelector("input[name=name]").value
            };
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
                (res) => res.json()
            ).then(
                (data) => {
                    if (data["status"] === "success") {
                        window.location.href='/login';
                    } else {
                        document
                            .querySelector(
                                "p#text-msg"
                            ).innerHTML =
                                data["message"];
                    }
                }
            ).catch(
                (err) => console.error(err)
            );
        }
    );