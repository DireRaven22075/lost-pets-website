document.addEventListener("DOMContentLoaded", function() {
    window.logInFlag = localStorage.getItem("logInFlag");

    const getStartedButton = document.getElementById("getStartedButton");
    if (logInFlag == 1) {
      getStartedButton.href = "/ami";
    } else {
      getStartedButton.href = "/login";
    }
    
  });

