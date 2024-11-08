# 전체 URL 구조
## 가. View URL Mapping
| 제목 | URL | 설명 |
| --- | --- | --- |
| 메인 | /   | 웹페이지 접근시 볼 수 있는 웹 페이지 |
| 로그인 | /login | 웹페이지에 로그인 하기 위한 페이지 |
| 회원가입 | /register | 웹페이지에 회원가입을 하기 위한 페이지 |
| 회원정보 | /info | 로그인한 사용자의 정보를 확인하기 위한 페이지 |
| 사이트소개 | /about | 사이트의 공개 정보를 확인하기 위한 페이지 |
| 글작성 | /write | 게시글을 작성하기 위한 페이지 |
| 글수정 | /modify | 게시글을 수정하기 위한 페이지 |
| 게시판 | /board/{boardId} | 게시판 페이지 |
| 게시글 | /post/{boardId}/{postId} | 게시글 페이지 |

## 나. API URL Mapping
### 1. 회원 관련 기능
| 기능 | 메서드 | URL | 설명 |
| --- | --- | --- | --- |
| 로그인 | POST | /api/auth/login | 로그인 시 인증 토큰 또는 세션 생성 |
| 로그아웃 | DELETE | /api/auth/logout | 로그아웃 시 인증 세션 삭제 |
| 비밀번호 찾기 요청 | POST | /api/auth/password/reset-request | 비밀번호 재설정 요청 |
| 비밀번호 업데이트 | PUT | /api/auth/password/reset | 비밀번호 재설정 |
| 회원가입 | POST | /api/users | 새 사용자 계정을 생성 |
| 회원탈퇴 | DELETE | /api/users/{uid} | 특정 사용자의 계정을 삭제 |
| 회원정보 업데이트 | PUT | /api/users/{uid} | 특정 사용자의 정보를 전체 수정 |

### 2. 게시판, 게시글 관련 기능
| 기능 | 메서드 | URL | 설명 |
| --- | --- | --- | --- |
| 게시글 목록 조회 | GET | /api/boards/{id1}/posts | 특정 게시판의 모든 게시글 조회 |
| 게시글 생성 | POST | /api/boards/{id1}/posts | 특정 게시판에 새 게시글 추가 |
| 게시글 검색 조회 | GET | /api/boards/{id1}/posts/{id2} | 특정 게시판 내 특정 게시글 조회 |
| 게시글 수정 | PUT | /api/boards/{id1}/posts/{id2} | 특정 게시판 내 특정 게시글 수정 |
| 게시글 삭제 | DELETE | /api/boards/{id1}/posts/{id2} | 특정 게시판 내 특정 게시글 삭제 |
### 3. 댓글 관련 기능
| 기능 | 메서드 | URL | 설명 |
| --- | --- | --- | --- |
| 댓글 목록 조회| GET | /api/boards/{id1}/posts/{id2}/comments | 특정 게시글 내의 모든 댓글 조회 |
| 댓글 생성 | POST | /api/boards/{id1}/posts/{id2}/comments | 특정 개시글에 댓글 추가 |
| 댓글 검색 조회 | GET | /api/boards/{id1}/posts/{id2}/comments/{id3} | 특정 게시글 내 특정 댓글 조회 |
| 댓글 수정 | PUT | /api/boards/{id1}/posts/{id2}/comments/{id3} | 특정 게시글 내 특정 댓글 수정 |
| 댓글 삭제 | DELETE | /api/boards/{id1}/posts/{id2}/comments/{id3} | 특정 게시글 내 특정 댓글 삭제 |