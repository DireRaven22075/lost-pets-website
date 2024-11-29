document.getElementById("Form-Register").addEventListener("submit", (e) => {
    e.preventDefault();
    const formData = {
        id: document.querySelector("input[name=id]").value,
        pw: document.querySelector("input[name=pw]").value,
        name: document.querySelector("input[name=name]").value,
        mail: document.querySelector("input[name=mail]").value
    }
    fetch("/api/users", {
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