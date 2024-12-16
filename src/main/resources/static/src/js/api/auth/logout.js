let URL = `/api/auth/logout`;

function logout() {
    fetch(
        URL,
        {
            method: "DELETE",
            credentials: "include",
            headers: {
                "Content-Type": "application/json"
            }
        }
    ).then(
        (res) => res.json()
    ).then(
        (data) => {
            let status = data["status"];
            if (status === "success") {
                alert("로그아웃 되었습니다");
                history.go(0);
            }
        }
    )
}
document
    .querySelector(
        "form#auth-logout"
    ).addEventListener(
        "submit",
        (event) => {
            event
                .preventDefault();
            fetch(
                URL,
                {
                    method: "DELETE",
                    credentials: "include",
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            ).then(
                (res) => res.json()
            ).then(
                data => {
                    if (data["status"] == "success") {
                        location.href = "/";
                    } else {
                        alert("Failed to logout");
                    }
                }
            ).catch(
                (err) => console.error(err)
            );
        }
    );