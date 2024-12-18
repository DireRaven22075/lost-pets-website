let id = document.querySelector("#input-id");
let idMsg = document.querySelector("#text-id");
let pw = document.querySelector("#input-pw");
let pwMsg = document.querySelector("#text-pw");
let submit = document.querySelector("#btn-submit");
let form = document.querySelector("#form-login");
let _id = document.querySelector("#container-id");
let _pw = document.querySelector("#container-pw");
form
    .addEventListener(
        "change",
        () => {
            submit.disabled = document.querySelectorAll(".is-valid").length != 2;
        }
    );

id
    .addEventListener(
        "change",
        () => {
            idMsg.hidden = false;
            _id.classList.add("is-invalid");
            _id.classList.remove("is-valid");
            if (id.value.length < 4) {
                idMsg
                    .innerText = "아이디는 4자 이상이어야 합니다.";
            }
            else {
                _id.classList.remove("is-invalid");
                _id.classList.add("is-valid");
                idMsg.hidden = true;
            }
        }
    );
pw
    .addEventListener(
        "change",
        () => {
            pwMsg.hidden = false;
            _pw.classList.add("is-invalid");
            _pw.classList.remove("is-valid");
            if (pw.value.length < 4) {
                pwMsg
                    .innerText = "비밀번호는 4자 이상이어야 합니다.";
            }
            else {
                _pw.classList.remove("is-invalid");
                _pw.classList.add("is-valid");
                pwMsg.hidden = true;
            }
        }
    );

