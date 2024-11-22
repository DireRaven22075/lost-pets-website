function logout() {
    fetch("/api/auth/logout", {
        method: "DELETE",
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (data['status'] === "success") {
                alert(data["message"]);
                window.location.href='/';
            }
        })
        .catch(error => {
            console.error(error);
        });
}