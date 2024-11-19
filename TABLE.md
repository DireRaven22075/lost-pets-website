# 전체 DATABASE - TABLE 구조

## 1. user_main (Entity) User
  Long sn (PK)
  Post posts (OneToMany)
  Replay replys (OneToMany)
String id
String pw (SHA256.Encode)
String name
String email
String icon
String uid

## 2. board_main (Entity) Board
  Long sn (PK)
  Post child (OneToMany)

## 3. board_data (Entity) Post
  Long sn (PK)
  File files (OneToMany)
  Board board (ManyToOne)
  User owner (ManyToOne)
String title
  Long viewCnt
  Long likeCnt
LnStr  content

## 4. board_file (Entity) File
  Long sn (PK)
  Post post (ManyToOne)
  User owner (ManyToOne)
String path

## 5. board_comments (Entity) Reply
  Long sn (PK)
  Post post (ManyToOne)
  User owner (ManyToOne)
  String text