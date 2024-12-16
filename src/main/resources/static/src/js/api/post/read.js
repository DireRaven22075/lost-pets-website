let URL = "/api/posts";

document.querySelector("form#post-read").addEventListener("submit", (e) => {
    e.preventDefault();

    fetch(URL, {
        method: "GET",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => res.json()).then(data => {
        if (data["status"] === "success") {
            let posts = data["posts"];
            let postList = document.querySelector("ul#post-list");
            postList.innerHTML = "";
            posts.forEach(post => {
                let postItem = document.createElement("li");
                postItem.innerText = post["title"];
                postItem.addEventListener("click", () => {
                    location.href = `/post/${post["id"]}`;
                });
                postList.appendChild(postItem);
            });
        } else {
            alert("Failed to read posts");
        }
    })
});