function Logout() {
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
                alert("로그아웃되었습니다.");
                history.go(0);
            }
        })
        .catch(error => {
            console.error(error);
        });
}