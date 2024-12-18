document
    .querySelector(
        "form#form-post"
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            let URL = "/api/posts/test2";
            let data = new FormData();
            data.append("title", document.querySelector("#input-title").value);
            data.append("content", document.querySelector("#input-content").value);
            data.append("uid", document.querySelector("#input-bbs").value);
            let files = document.querySelector("#input-file").files;
            for (var i = 0; i < files.length; i++) {
                data.append("files", files[i]);
            }
            fetch(
                URL,
                {
                    method: "POST",
                    credentials: "include",
                    body: data
                }
            ).then(
                res => res.json()
            ).then(
                (data) => {
                    let status = data["status"];
                    if (status === "success") {
                    //현재 페이지를 리로드
                    history
                        .go(0);
                    }
                    else {
                        alert(data.message);
                    }
                }
            ).catch(
                err => console.error(err)
            );
        }
    );