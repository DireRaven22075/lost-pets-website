document.getElementById("Form-Comment").addEventListener("submit", () => {
    e.preventDefault();
    const formData = {
        content: document.querySelector("input[type=text]#Input-Comment-Content").value,
        pst: document.querySelector("input[type=text]#Input-Comment-PostSN").value,
        bbs: document.querySelector("input[type=text]#Input-Comment-BoardSN").value
    }
    fetch("/api/comment/", {
        method: "POST",
        credentials: 'include',
        body: JSON.stringify(formData),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data['status'] === "success") {
                window.location.href = '/';
            } else {
                alert(data["message"]);
            }
        })
        .catch(error => {
            console.error(error);
        });
});