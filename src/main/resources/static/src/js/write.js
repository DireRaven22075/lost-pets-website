// 게시글 저장 기능
document
.getElementById("postForm")
.addEventListener("submit", function (event) {
  event.preventDefault();

  // 입력값 가져오기
  const title = document.getElementById("title").value;
  const content = document.getElementById("content").value;
  const files = document.getElementById("uploadImage").files[0];

  // 게시글 객체 생성
  const newPost = {
    title: title,
    content: content,
    files: files ? URL.createObjectURL(files) : null, // 업로드된 파일 URL 생성
    date: new Date().toLocaleString(),
    view: 0,
    comment: 0,
  };

  // 기존 게시글 가져오기
  let posts = JSON.parse(localStorage.getItem("posts")) || [];
  posts.push(newPost); // 새 게시글 추가

  // localStorage에 저장
  localStorage.setItem("posts", JSON.stringify(posts));

  // 게시글 목록 페이지로 이동
  alert("게시글이 성공적으로 저장되었습니다!");
  window.location.href = "report.html";
});

// 로그아웃 기능
function logout() {
localStorage.setItem("logInFlag", 0);
alert("로그아웃되었습니다.");
window.location.href = "/";
}