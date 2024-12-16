// 작성자 : 한윤수 (DireRaven22075)

//let URL = "/api/users/check";
//Element Declaration

let id = document.querySelector("#input-id");
let idMsg = document.querySelector("#text-id");
let _id = document.querySelector("#container-id");

let pw = document.querySelector("#input-pw");
let pwMsg = document.querySelector("#text-pw");
let _pw = document.querySelector("#container-pw");


let pwCheck = document.querySelector("#input-pw-confirm");
let pwCheckMsg = document.querySelector("#text-pw-confirm");
let _pwCheck = document.querySelector("#container-pw-confirm");

let _name = document.querySelector("#input-name");
let nameMsg = document.querySelector("#text-name");
let __name = document.querySelector("#container-name");

let mail = document.querySelector("#input-mail");
let mailMsg = document.querySelector("#text-mail");
let _mail = document.querySelector("#container-mail");

let submit = document.querySelector("#btn-submit");

let form = document.querySelector("#form-register");
form.addEventListener(
    "change",
    () => {
        submit.disabled = document.querySelectorAll(".is-valid").length != 5;
    }
);
id.addEventListener(
    "change",
    () => {
        idMsg.hidden = false;
    _id.classList.add("is-invalid");
    _id.classList.remove("is-valid");
        if (id.value.length < 4) {
            idMsg
                .innerText = "아이디는 4자 이상이어야 합니다.";
        }
        else if (id.value === "admin") {
            idMsg.innerText = "해당 아이디는 사용할 수 없습니다.";
        }
        else if (id.value === "test50") {
            idMsg.innerText = "해당 아이디는 이미 사용중입니다.";
        }
        else {
            idMsg.innerText = "사용 가능한 아이디입니다.";
            _id.classList.remove("is-invalid");
            _id.classList.add("is-valid");
            idMsg.hidden = true;
        }
    }
);
_name.addEventListener(
    "change",
    () => {
        nameMsg.hidden = false;
        __name.classList.add("is-invalid");
        __name.classList.remove("is-valid");
        if (_name.value.length < 3) {
            nameMsg.innerText = "닉네임은 3자 이상이어야 합니다.";
        }
        else {
            nameMsg.innerText = "사용 가능한 이름입니다.";
            __name.classList.remove("is-invalid");
            __name.classList.add("is-valid");
            nameMsg.hidden = true;
        }
    }
)
mail.addEventListener(
    "change",
    () => {
        mailMsg.hidden = false;
        _mail.classList.add("is-invalid");
        _mail.classList.remove("is-valid");
        if (mail.value.split("@").length != 2) {
            mailMsg.innerText = "이메일 형식이 올바르지 않습니다.";
        }
        else if (mail.value.split("@")[1].split(".").length < 2) {
            mailMsg.innerText = "이메일 형식이 올바르지 않습니다.";
        }
        else {
            mailMsg.innerText = "사용 가능한 이메일입니다.";
            _mail.classList.remove("is-invalid");
            _mail.classList.add("is-valid");
            mailMsg.hidden = true;
        }
    }
)
pw.addEventListener(
    "change",
    () => {
        pwMsg.hidden = false;
        _pw.classList.add("is-invalid");
        _pw.classList.remove("is-valid");
        if (pw.value.length < 4) {
            pwMsg.innerText = "비밀번호는 4자 이상이어야 합니다.";
        }
        else if (pw.value === id.value) {
            pwMsg.innerText = "아이디와 비밀번호는 같을 수 없습니다.";
        }
        else {
            pwMsg.innerText = "사용 가능한 비밀번호입니다.";
            _pw.classList.remove("is-invalid");
            _pw.classList.add("is-valid");
            pwMsg.hidden = true;
        }
    }
)
pwCheck.addEventListener(
    "change",
    () => {
        pwCheckMsg.hidden = false;
        _pwCheck.classList.add("is-invalid");
        _pwCheck.classList.remove("is-valid");
        if (pwCheck.value != pw.value) {
            pwCheckMsg.innerText = "비밀번호가 일치하지 않습니다.";
        }
        else {
            pwCheckMsg.innerText = "비밀번호가 일치합니다.";
            _pwCheck.classList.remove("is-invalid");
            _pwCheck.classList.add("is-valid");
            pwCheckMsg.hidden = true;
        }
    }
)
