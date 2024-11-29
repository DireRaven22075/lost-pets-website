document.addEventListener("DOMContentLoaded", () => {
    const comments = [];

    // 댓글 렌더링 함수
    function renderComments() {
      const commentsList = document.getElementById("comments-list");
      commentsList.innerHTML = "";

      comments.forEach((comment) => {
        const commentItem = document.createElement("div");
        commentItem.classList.add("comment-item");
        commentItem.innerHTML = `
        <span class="comment-author">${comment.author}</span>
        <span class="comment-content">${comment.content}</span>
      `;
        commentsList.appendChild(commentItem);
      });
    }

    // 댓글 추가 함수
    document
      .getElementById("submit-comment")
      .addEventListener("click", () => {
        const userName =
          document.getElementById("user-name").value || "익명 사용자";
        const commentContent =
          document.getElementById("comment-input").value;

        if (!commentContent.trim()) {
          alert("댓글 내용을 입력하세요.");
          return;
        }

        comments.push({ author: userName, content: commentContent });
        renderComments();
        document.getElementById("comment-input").value = "";
      });


    // 로그아웃 버튼 클릭 시

    renderComments();
  });