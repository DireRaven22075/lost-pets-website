let URL = "/api/posts";

document.querySelector("form#post-create").addEventListener("submit", (e) => {
    e.preventDefault();
    let data = new FormData();
    data.append("title", document.querySelector("input[name=title]").value);
    data.append("content", document.querySelector("textarea[name=content]").value);
    let files = document.querySelector("input[name=files]").files;
    for (var i = 0; i < files.length; i++) {
        data.append("files", files[i]);
    }
    fetch(URL, {
        method: "POST",
        credentials: "include",
        body: data
    }).then(
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

            }
        }
    ).catch(err => console.error(err));
});