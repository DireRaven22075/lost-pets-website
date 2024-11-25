// 이미지 변경 처리
document
.getElementById("upload-image")
.addEventListener("change", function (event) {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("profile-pic").src = e.target.result;
    };
    reader.readAsDataURL(file);
  }
});

// Edit 버튼 클릭 시 input 표시
document.querySelectorAll(".edit-btn").forEach((button) => {
button.addEventListener("click", function () {
  const target = this.getAttribute("data-target");
  document.getElementById(`edit-${target}`).style.display = "block";
});
});

// Confirm 버튼 클릭 시 정보 업데이트
document.querySelectorAll(".confirm-btn").forEach((button) => {
button.addEventListener("click", function () {
  const target = this.getAttribute("data-target");
  const inputField = document.getElementById(`input-${target}`);
  const newValue = inputField.value;

  if (newValue.trim()) {
    if (target === "pw") {
      const maskedPassword = "*".repeat(newValue.length);
      document.getElementById(
        `user-${target}-length`
      ).textContent = `${maskedPassword} (${newValue.length} characters)`;
    } else {
      document.getElementById(`user-${target}`).textContent = newValue;
    }

    alert(`${target} 정보가 업데이트되었습니다.`);
  } else {
    alert(`${target} 값을 입력하세요.`);
  }

  // 입력 필드 초기화 및 숨김 처리
  inputField.value = "";
  document.getElementById(`edit-${target}`).style.display = "none";
});
});

// 로그아웃 처리
document
.getElementById("logoutButton")
.addEventListener("click", function () {
  localStorage.setItem("logInFlag", 0);
  alert("로그아웃 되었습니다.");
  window.location.href = "index.html";
});