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
