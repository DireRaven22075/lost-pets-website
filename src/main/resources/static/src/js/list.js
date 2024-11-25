// Example data (should be replaced with data from server or database)
const posts = [
    { title: "잃어버린 강아지를 찾아요", view: 0, date: "2024-11-21", comment: 0 },
    { title: "고양이 임시보호 구합니다", view: 3, date: "2024-11-20", comment: 1 },
    { title: "유실 동물 교육 자료 공유", view: 12, date: "2024-11-18", comment: 2 },
];

// Render posts dynamically
const bulletinList = document.getElementById("bulletin-list");

// Display posts in reverse chronological order
posts.sort((a, b) => new Date(b.date) - new Date(a.date));

posts.forEach(post => {
    const row = document.createElement("tr");

    row.innerHTML = 
        <td>${post.title}</td>
        <td>${post.view}</td>
        <td>${post.date}</td>
        <td>${post.comment}</td>
    ;

    bulletinList.appendChild(row);
});