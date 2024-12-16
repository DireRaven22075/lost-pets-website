document.addEventListener('DOMContentLoaded', function() {
    // Example data (should be replaced with data from server or database)
    const posts = [
        { title: "잃어버린 강아지를 찾아요", view: 0, date: "2024-11-21", comment: 0 },
        { title: "고양이 임시보호 구합니다", view: 3, date: "2024-11-20", comment: 1 },
        { title: "유실 동물 교육 자료 공유", view: 12, date: "2024-11-18", comment: 2 },
    ];

    // Sort posts in reverse chronological order
    posts.sort((a, b) => new Date(b.date) - new Date(a.date));

    // Get the container to display recent posts
    const recentPostsList = document.getElementById("recent-posts-list");

    // Limit to 3 most recent posts
    const topPosts = posts.slice(0, 3);

    // Check if we have the right div to append to
    if (recentPostsList) {
        // Render the posts dynamically under "최근 작성한 게시글"
        topPosts.forEach(post => {
            const postElement = document.createElement("div");
            postElement.classList.add("post-item");
            postElement.innerHTML = `<h3>${post.title}</h3>`;
            recentPostsList.appendChild(postElement);
        });
    } else {
        console.error("recent-posts-list div not found!");
    }
});

const logInFlag = localStorage.getItem("logInFlag"); // Assuming logInFlag is stored in localStorage

        function redirectToWrite() {
          if (logInFlag == 1) {
            window.location.href = "/write"; // 로그인 상태일 때 글쓰기 페이지로 연결
          } else if (logInFlag == 0 || logInFlag === null) {
            window.location.href = "/login"; // 비로그인 상태일 때 로그인 페이지로 연결
          }
        }

// Function to load posts from localStorage and display them
      function loadBulletin() {
        const bulletinList = document.getElementById("bulletin-list");

        // Get posts from localStorage
        const posts = JSON.parse(localStorage.getItem("posts")) || [];

        // Loop through each post and create a row
        posts.forEach((post) => {
          const row = document.createElement("tr");
          row.innerHTML = `
                    <td class="bulletin-title">${post.title}</td>
                    <td>${post.view}</td>
                    <td>${post.date}</td>
                    <td>${post.comment}</td>
                `;
          // Add click event to the title for redirection to board.html
          row
            .querySelector(".bulletin-title")
            .addEventListener("click", function () {
              window.location.href = "/board";
            });
          bulletinList.appendChild(row);
        });
      }

      // Load the posts when the page is loaded
      window.onload = loadBulletin;
