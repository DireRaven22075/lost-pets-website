document
        .querySelector("form")
        .addEventListener("submit", function (event) {
          event.preventDefault();
          var id = document.getElementById("id").value;
          var password = document.getElementById("password").value;

          // Simulate database check
          var exID = "user456"; // Replace with your database check logic
          var exPW = "pass456"; // Replace with your database check logic

          if (id === exID && password === exPW) {
            // 로그인 성공 시 logInFlag를 localStorage에 설정
            localStorage.setItem("logInFlag", "1"); // 1 means logged in
            alert("Login successful!");
            window.location.href = "/"; // 로그인 후 index.html로 이동
          } else {
            alert("Invalid username or password.");
          }
        });