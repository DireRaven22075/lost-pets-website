let URL = "/api/auth/logout";

function logout() {
    fetch(URL, {
        method: "DELETE",
        credentials: "include",
        headers: {
            "Content-Type": "applicaion/json"
        }
    }).then(res => res.json()).then(data => {
        if (data["status"] === "success") {
            alert("로그아웃이 완료되었습니다.");
        }
    }).catch(err => console.log(err));
}