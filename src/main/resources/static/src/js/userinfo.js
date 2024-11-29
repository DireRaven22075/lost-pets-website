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
        // 비밀번호 변경 처리 (API 호출, 리다이렉션)
        fetch('/api/users/' + document.querySelector("#Value-User-SN").innerHTML, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ password: newValue }),
        })
          .then((response) => response.json())
          .then((data) => {
            if (data.status === 'success') {
              alert('비밀번호가 성공적으로 변경되었습니다.');
              window.location.href = '/reset-password'; // reset password URL로 리다이렉트
            } else {
              alert(data.message || '비밀번호 변경 중 오류가 발생했습니다.');
            }
          })
          .catch((error) => {
            console.error(error);
            alert('비밀번호 변경에 실패했습니다. 나중에 다시 시도해주세요.');
          });
      } else {
        // 다른 정보 업데이트 (화면에 반영)
        document.getElementById(`user-${target}`).textContent = newValue;
        alert(`${target} 정보가 업데이트되었습니다.`);
      }
    } else {
      alert(`${target} 값을 입력하세요.`);
    }

    // 입력 필드 초기화 및 숨김 처리
    inputField.value = "";
    document.getElementById(`edit-${target}`).style.display = "none";
  });
});

// 회원 탈퇴 처리
document.getElementById('deleteIDButton').addEventListener('click', function () {
  const userId = document.getElementById('user-id').textContent;

  if (confirm('회원 탈퇴를 진행하시겠습니까?')) {
      fetch(`/api/users/${userId}`, {
          method: 'DELETE',
          headers: { 'Content-Type': 'application/json' },
          credentials: 'include',
      })
          .then((response) => response.json())
          .then((data) => {
              if (data.status === 'success') {
                  alert(data.message || '회원 탈퇴가 완료되었습니다.');
                  window.location.href = '/';
              } else {
                  alert(data.message || 'Error. Try again.');
              }
          })
          .catch((error) => {
              console.error('Error:', error);
              alert('Error. Try again.');
          });
  }
});
