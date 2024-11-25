document
              .querySelector(".signup-box form")
              .addEventListener("submit", function (event) {
                event.preventDefault();
                const username = document.getElementById("username").value;
                const name = document.getElementById("name").value;
                const email = document.getElementById("email").value;
                const password = document.getElementById("password").value;
                const confirmPassword =
                  document.getElementById("confirm-password").value;

                if (username && name && email && password && confirmPassword) {
                  if (password === confirmPassword) {
                    alert("회원가입 되었습니다.");
                  } else {
                    alert("Passwords do not match.");
                  }
                } else {
                  alert("All fields are required.");
                }
              });

              document
              .querySelector(".btn.home")
              .addEventListener("click", function () {
                window.location.href = "/";
              });