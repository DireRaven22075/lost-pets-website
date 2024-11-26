document.addEventListener("DOMContentLoaded", function() {
    const logInFlag = localStorage.getItem("logInFlag");

    const getStartedButton = document.getElementById("getStartedButton");
    if (logInFlag == 1) {
      getStartedButton.href = "/ami";
    } else {
      getStartedButton.href = "/login";
    }
    
  });
  

  function logout() {
    localStorage.setItem("logInFlag", 0);
    alert("로그아웃되었습니다.");
    window.location.href = "/";
    }