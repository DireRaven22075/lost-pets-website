document.getElementById("Form-Login").addEventListener("submit", (e) => {
    e.preventDefault();
    const formData = {
        id: document.querySelector("input[name=id]").value,
        pw: document.querySelector("input[name=pw]").value
    }
    fetch("/api/auth/login", {
        method: "POST",
        credentials: 'include',
        body: JSON.stringify(formData),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data["status"] == "success") {
                alert(data["message"]);
                window.location.href = "/";
            } else {
                document.getElementById("ERROR").innerHTML = data["message"];
            }
        })
        .catch(error => {
            console.error(error);
        });
});