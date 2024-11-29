document.getElementById("Form-Post").addEventListener("submit", (e) => {
    e.preventDefault();

    const formData = new FormData();
    let variable1 = document.querySelector("form>input[type='file']").files;
    if (variable1.length !== 0) {
        Array.from(variable1).forEach((file, index) => {
            formData.append("files", file);
        });
    }
    let data = {
        title: document.querySelector("input[name='title']").value,
        content: document.querySelector("textarea[name='content']").value,
        status: 'W',
        uid: 1
    }
    formData.append("data", data);
    fetch("/api/posts", {
        method: "POST",
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json'
        },
        body: formData
    }).then(response => {
        return response.json()
    }).then(data => {
        if (data["status"] === "success") {
            alert(data.message);
            history.back();
        } else {
            alert(data["message"]);
        }
    }).catch(error => console.error(error));
});