let URL = "/api/comments";

document
    .querySelector(
        "form#comment-delete"
    ).addEventListener(
        "submit",
        (event) => {
            event.preventDefault();
            let data = {
                sn: document.querySelector("input[name=sn]").value,
                text: document.querySelector("input[name=text]").value
            };
        }
    );